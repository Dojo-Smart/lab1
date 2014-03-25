package dojo.lab1.ferroviaria.core;

public class OperacaoCarroImpl implements OperacaoCarroCommand {

	private String nomeCarro;

	private float velocidadeCarro;

	private float posicao = 0;
	private Linha linha;

	public OperacaoCarroImpl(Linha linha, String nomeCarro) {

		this.linha = linha;
		this.nomeCarro = nomeCarro;
	}

	public String getNomeCarro() {
		return nomeCarro;
	}

	public void setNomeCarro(String nomeCarro) {
		this.nomeCarro = nomeCarro;
	}

	public float getPosicao() {
		return this.posicao;
	}

	public void iniciaCorrida(float velocidade) {

		this.posicao = 0;
		this.velocidadeCarro = velocidade;
		// this.status = ...;
	}

	@Override
	public void alterarPosicao(float posicao) {
		this.posicao = posicao;
	}

	@Override
	public float getVelocidade() {
		return this.velocidadeCarro;
	}

	@Override
	public Linha getLinha() {
		return this.linha;
	}

	@Override
	public float getPosicaoAtual() {
		return this.posicao;
	}
}
