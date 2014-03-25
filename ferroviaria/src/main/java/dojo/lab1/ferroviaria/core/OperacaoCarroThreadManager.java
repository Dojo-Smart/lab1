package dojo.lab1.ferroviaria.core;

public class OperacaoCarroThreadManager implements OperacaoCarroCommand {

	private OperacaoCarroCommand comando;
	private CorridaThread corridaThread;

	public OperacaoCarroThreadManager(OperacaoCarroCommand operacao) {
		this.comando = operacao;
	}

	@Override
	public void iniciaCorrida(float velocidade) {

		corridaThread = new CorridaThread(comando, velocidade);
		corridaThread.start();
	}

	class CorridaThread extends Thread {

		private OperacaoCarroCommand operacao;
		private float velocidadeInicial;

		public CorridaThread(OperacaoCarroCommand operacao, float velocidadeInicial) {
			this.operacao = operacao;
			this.velocidadeInicial = velocidadeInicial;
		}

		@Override
		public void run() {
			operacao.iniciaCorrida(velocidadeInicial);
			this.inciar();
		}

		private void inciar() {
			int cont = 0;

			// Deve ser trocada por implementação do padrão state

			float posicao = 0;

			while (!estaEmUmaEstacao(posicao)) {
				long tempo = 500;
				try {
					Thread.sleep(tempo);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				posicao += calculaNovaPosicao(tempo);

				operacao.alterarPosicao(posicao);

				System.out.println(tempo);
				System.out.println("posicao atual " + cont++ + " " + posicao);
			}
		}

		private float calculaNovaPosicao(long tempo) {
			float milisegundosPorSegundo = 1000;
			return operacao.getVelocidade() * (tempo / milisegundosPorSegundo);
		}

		private boolean estaEmUmaEstacao(float posicao) {
			// System.out.println("entrei aqui");
			return operacao.getLinha().getEstacoes().contains(posicao);
		}

	}

	@Override
	public void alterarPosicao(float posicao) {

		comando.alterarPosicao(posicao);
	}

	@Override
	public float getVelocidade() {
		return comando.getVelocidade();
	}

	@Override
	public Linha getLinha() {
		return comando.getLinha();
	}

	@Override
	public float getPosicaoAtual() {

		return comando.getPosicaoAtual();
	}
}
