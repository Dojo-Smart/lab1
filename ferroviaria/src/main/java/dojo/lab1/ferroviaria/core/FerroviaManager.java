package dojo.lab1.ferroviaria.core;

import java.util.HashMap;
import java.util.Map;

public class FerroviaManager {

	public static final Long PARADO = 0L;

	private LinhaDAO linhaDAO;

	private Map<String, OperacaoLinha> operacoes = new HashMap<String, OperacaoLinha>();

	public FerroviaManager(LinhaDAO linhaDAO) {
		this.linhaDAO = linhaDAO;
	}

	public void iniciaOperacao(String nomeLinha, String nomeCarro, float velocidade) throws LinhaNotFoundException {

		Linha linha = linhaDAO.getLinha(nomeLinha);

		if (linha == null)
			throw new LinhaNotFoundException(nomeLinha);

		OperacaoLinha operacao = operacoes.get(nomeLinha);
		if (operacao == null) {
			operacao = new OperacaoLinha(linha);
			operacoes.put(nomeLinha, operacao);
		}

		operacao.iniciaCorrida(nomeCarro, velocidade);
	}

	public OperacaoLinhaInfo getOperacao(String nomeLinha) throws OperacaoLinhaNotFoundException {
		final OperacaoLinha operacaoLinha = operacoes.get(nomeLinha);
		if (operacaoLinha == null)
			throw new OperacaoLinhaNotFoundException(nomeLinha);

		return new OperacaoLinhaInfo() {

			@Override
			public Linha getLinha() {
				return operacaoLinha.getLinha();
			}

			@Override
			public OperacaoCarroInfo getOperacao(String nomeCarro) throws OperacaoCarroNotFoundException {
				return operacaoLinha.getOperacao(nomeCarro);
			}

		};
	}
}
