package dojo.lab1.ferroviaria.core;

public abstract class AbstractOperacaoCarroCommandDecorator implements OperacaoCarroCommand {

	protected OperacaoCarroCommand delegate;

	public AbstractOperacaoCarroCommandDecorator(OperacaoCarroCommand operacao) {
		this.delegate = operacao;
	}

	@Override
	public float getVelocidade() {

		return delegate.getVelocidade();
	}

	@Override
	public Linha getLinha() {

		return delegate.getLinha();
	}

	@Override
	public float getPosicaoAtual() {

		return delegate.getPosicaoAtual();
	}

	@Override
	public long getUltimaVerificacaoDeVelocidade() {
		return delegate.getUltimaVerificacaoDeVelocidade();
	}

	@Override
	public void partir(float velocidade) {
		delegate.partir(velocidade);
	}

	@Override
	public void alterarPosicao(float posicao) {
		delegate.alterarPosicao(posicao);
	}

	@Override
	public void parar() {
		delegate.parar();
		
	}
	
}
