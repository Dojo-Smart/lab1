package dojo.lab1.ferroviaria.core;

interface OperacaoCarroCommand {

	void iniciaCorrida(float velocidade);

	void alterarPosicao(float posicao);

	float getVelocidade();

	Linha getLinha();

	float getPosicaoAtual();

}
