package dojo.lab1.ferroviaria.core;

import java.util.Date;

public class Operacao {

	private String nomeLinha;
	private String nomeCarro;
	private int posicao;
	private int tempoCorrido;
	private int velocidadeCarro;

	public Operacao(String nomeLinha, String nomeCarro) {
		this.nomeLinha = nomeLinha;
		this.nomeCarro = nomeCarro;
	}

	public int getPosicaoAtual(String nomeCarro) {
		return posicao;
	}

	public String getNomeLinha() {
		return nomeLinha;
	}

	public void setNomeLinha(String nomeLinha) {
		this.nomeLinha = nomeLinha;
	}

	public String getNomeCarro() {
		return nomeCarro;
	}

	public void setNomeCarro(String nomeCarro) {
		this.nomeCarro = nomeCarro;
	}

	public void iniciaCorrida(int velocidadeCarro) {
		new CorridaThread(velocidadeCarro, posicao).run();
	}
}
