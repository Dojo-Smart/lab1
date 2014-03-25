package dojo.lab1.ferroviaria.core;

public class Operacao {

	private Linha linha;
	private String nomeCarro;
	private CorridaThread corridaThread;

	public Operacao(Linha linha, String nomeCarro) {
		this.linha = linha;
		this.nomeCarro = nomeCarro;
	}

	public float getPosicaoAtual(String nomeCarro) {
		return corridaThread.getPosicao();
	}

	public Linha getLinha() {
		return linha;
	}

	public void setLinha(Linha linha) {
		this.linha = linha;
	}

	public String getNomeCarro() {
		return nomeCarro;
	}

	public void setNomeCarro(String nomeCarro) {
		this.nomeCarro = nomeCarro;
	}

	public void iniciaCorrida(float velocidadeCarro, Linha linha) {
		corridaThread = new CorridaThread(velocidadeCarro, linha);
		corridaThread.start();
	}
}
