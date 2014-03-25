package dojo.lab1.ferroviaria.core;

public interface OperacaoCarroState {

	OperacaoCarroState iniciaCorrida(OperacaoCarroCommand comando, float velocidade);

	OperacaoCarroState alterarPosicao(OperacaoCarroCommand comando, float posicao);

}
