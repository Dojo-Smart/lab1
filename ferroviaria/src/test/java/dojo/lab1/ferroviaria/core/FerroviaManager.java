package dojo.lab1.ferroviaria.core;

import java.util.HashMap;
import java.util.Map;

public class FerroviaManager {

	public static final Long PARADO = 0L;

	private Operacao operacao;

	private LinhaDAO linhaDAO = new LinhaDAO();

	private Map<String, Operacao> operacoes = new HashMap<String, Operacao>();

	public void iniciaOperacao(String nomeLinha, String nomeCarro) {

		String linha = linhaDAO.getLinha(nomeLinha);

		operacao = new Operacao(linha, nomeCarro);
		int velocidadeCarro = 300;
		operacao.iniciaCorrida(velocidadeCarro);
		operacoes.put(nomeLinha, operacao);
	}

	public Operacao getOperacao(String nomeLinha) {
		return operacoes.get(nomeLinha);
	}

	public Long getStatus(String nomeCarro) {
		return 0L;
	}

}
