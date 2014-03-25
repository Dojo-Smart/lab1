package dojo.lab1.ferroviaria.core;

import java.util.HashMap;
import java.util.Map;

public class OperacaoLinha {

	private Linha linha;
	private Map<String, OperacaoCarroCommand> operacoes = new HashMap<String, OperacaoCarroCommand>();

	public OperacaoLinha(Linha linha) {
		this.linha = linha;
	}

	public Linha getLinha() {
		return linha;
	}

	public void setLinha(Linha linha) {
		this.linha = linha;
	}

	public void iniciaCorrida(String nomeCarro, float velocidade) {

		OperacaoCarroCommand operacao = operacoes.get(nomeCarro);
		if (operacao == null) {
			operacao = new OperacaoCarroImpl(this.linha, nomeCarro);

			operacao = new OperacaoCarroStateManager(operacao);

			operacao = new OperacaoCarroThreadManager(operacao);

			operacoes.put(nomeCarro, operacao);
		}

		operacao.iniciaCorrida(velocidade);
	}

	public OperacaoCarroInfo getOperacao(String nomeCarro) throws OperacaoCarroNotFoundException {

		final OperacaoCarroCommand operacao = operacoes.get(nomeCarro);
		if (operacao == null) {
			throw new OperacaoCarroNotFoundException(nomeCarro);
		}

		return new OperacaoCarroInfo() {

			@Override
			public float getPosicaoAtual() {
				return operacao.getPosicaoAtual();
			}

		};
	}
}
