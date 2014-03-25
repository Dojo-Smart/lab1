package dojo.lab1.ferroviaria.core;

import java.util.HashMap;
import java.util.Map;

public class FerroviaManager {

	public static final Long PARADO = 0L;

	private Operacao operacao;

	private LinhaDAO linhaDAO;

	private Map<String, Operacao> operacoes = new HashMap<String, Operacao>();

	public FerroviaManager(LinhaDAO linhaDAO) {
		this.linhaDAO = linhaDAO;
	}

	public void iniciaOperacao(String nomeLinha, String nomeCarro, float velocidade) throws LinhaNotFoundException {

		Linha linha = linhaDAO.getLinha(nomeLinha);

		if (linha == null)
			throw new LinhaNotFoundException(nomeLinha);

		operacao = new Operacao(linha, nomeCarro);
		
		operacao.iniciaCorrida(velocidade, linha);
		operacoes.put(nomeLinha, operacao);
	}

	public Operacao getOperacao(String nomeLinha) {
		return operacoes.get(nomeLinha);
	}

	public Long getStatus(String nomeCarro) {
		return 0L;
	}

	public LinhaManager getLinha(String string) {

		return null;
	}

}
