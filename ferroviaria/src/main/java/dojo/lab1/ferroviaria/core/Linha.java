package dojo.lab1.ferroviaria.core;

import java.util.ArrayList;
import java.util.List;

public class Linha {

	private float tamanho;
	private String nome;
	private List<Float> estacoes = new ArrayList<Float>() {
		{
			add(500f);
			add(1000f);
			add(1500f);
			add(2000f);
			add(2500f);
			add(3000f);
		}
	};

	public Linha(String nome, float tamanho) {
		super();
		this.tamanho = tamanho;
		this.nome = nome;
	}

	public float getTamanho() {
		return tamanho;
	}

	public void setTamanho(float tamanho) {
		this.tamanho = tamanho;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Float> getEstacoes() {
		return estacoes;
	}

	public void setEstacoes(List<Float> estacoes) {
		this.estacoes = estacoes;
	}

}
