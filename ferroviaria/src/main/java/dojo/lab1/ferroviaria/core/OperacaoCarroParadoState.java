package dojo.lab1.ferroviaria.core;

public class OperacaoCarroParadoState implements OperacaoCarroState {

	@Override
	public OperacaoCarroState iniciaCorrida(OperacaoCarroCommand comando, float velocidade) {

		comando.iniciaCorrida(velocidade);

		return new OperacaoCarroEmMovimentoState();
	}

	@Override
	public OperacaoCarroState alterarPosicao(OperacaoCarroCommand comando, float posicao) {

		throw new UnsupportedOperationException();
	}

}
