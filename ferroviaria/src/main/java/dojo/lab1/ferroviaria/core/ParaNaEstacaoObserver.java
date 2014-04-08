package dojo.lab1.ferroviaria.core;

public class ParaNaEstacaoObserver implements OperacaoCarroObserver {

	@Override
	public void update(OperacaoCarroCommand comando) {
		System.out.println("        --- passou aqui ");
		for (float estacao : comando.getLinha().getEstacoes()) {
			System.out.println("estacao " + estacao + "   posicaoAtual " + comando.getPosicaoAtual());
			if (comando.getPosicaoAtual() >= estacao) {
				comando.parar();
			}
		}
	}

	@Override
	public OperacaoCarroEvento getEvento() {
		return OperacaoCarroEvento.ALTERAR_POSICAO;
	}

}
