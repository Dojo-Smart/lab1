package dojo.lab1.ferroviaria.core;

public class OperacaoCarroStateManager implements OperacaoCarroCommand {

	private OperacaoCarroCommand comando;

	private OperacaoCarroState estado = new OperacaoCarroParadoState();

	public OperacaoCarroStateManager(OperacaoCarroCommand operacao) {
		this.comando = operacao;
	}

	@Override
	public void iniciaCorrida(float velocidade) {

		estado = estado.iniciaCorrida(comando, velocidade);
	}

	@Override
	public void alterarPosicao(float posicao) {

		estado = estado.alterarPosicao(comando, posicao);
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
