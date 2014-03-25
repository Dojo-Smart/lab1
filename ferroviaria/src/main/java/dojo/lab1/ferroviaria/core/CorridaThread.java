package dojo.lab1.ferroviaria.core;

import java.util.Date;

public class CorridaThread extends Thread {

	private float velocidadeCarro;

	private float posicao = 0;
	private Linha linha;

	public CorridaThread(float velocidadeCarro, Linha linha) {
		this.velocidadeCarro = velocidadeCarro;
		this.linha = linha;
	}

	@Override
	public void run() {
		int cont = 0 ;
		while (!estaEmUmaEstacao()) {
			long tempo = 500;
			try {
				Thread.sleep(tempo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			posicao += calculaNovaPosicao(tempo);
			System.out.println(tempo);
			System.out.println("posicao atual " + cont++ + " " + posicao);
		}
	}

	private float calculaNovaPosicao(long tempo) {
		float milisegundosPorSegundo = 1000;
		return velocidadeCarro * (tempo/milisegundosPorSegundo);
	}

	
	private boolean estaEmUmaEstacao() {
		//System.out.println("entrei aqui");
		return linha.getEstacoes().contains(posicao);
		
	}

	public float getPosicao() {
		return this.posicao;
	}

}
