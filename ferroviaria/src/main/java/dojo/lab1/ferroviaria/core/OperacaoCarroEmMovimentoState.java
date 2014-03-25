package dojo.lab1.ferroviaria.core;

public class OperacaoCarroEmMovimentoState implements OperacaoCarroState {

	@Override
	public OperacaoCarroState iniciaCorrida(OperacaoCarroCommand comando, float velocidade) {

		throw new UnsupportedOperationException();
	}

	@Override
	public OperacaoCarroState alterarPosicao(OperacaoCarroCommand comando, float posicao) {
		comando.alterarPosicao(posicao);
		return this;
	}

}
