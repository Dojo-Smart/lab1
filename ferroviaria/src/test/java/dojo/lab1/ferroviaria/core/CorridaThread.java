package dojo.lab1.ferroviaria.core;

import java.util.Date;

public class CorridaThread extends Thread {

	private int velocidadeCarro;

	private long posicao;

	public CorridaThread(int velocidadeCarro, long posicao) {
		this.velocidadeCarro = velocidadeCarro;
		this.posicao = posicao;
	}

	@Override
	public void run() {
		long ultimoTempoVerificado = 0;
		while (true) {

			long agora = new Date().getTime();
			posicao = (velocidadeCarro * agora - ultimoTempoVerificado);
			ultimoTempoVerificado = agora;
		}
	}

}
