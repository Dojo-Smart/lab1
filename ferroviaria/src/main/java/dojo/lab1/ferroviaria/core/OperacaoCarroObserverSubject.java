package dojo.lab1.ferroviaria.core;

import java.util.ArrayList;
import java.util.List;

public class OperacaoCarroObserverSubject extends AbstractOperacaoCarroCommandDecorator {

	private List<OperacaoCarroObserver> observers = new ArrayList<OperacaoCarroObserver>();

	public OperacaoCarroObserverSubject(OperacaoCarroCommand operacao) {
		super(operacao);
	}

	public void attach(OperacaoCarroObserver observer) {
		observers.add(observer);
	}

	private void notifyObservers(OperacaoCarroEvento evento) {
		for (OperacaoCarroObserver observer : observers) {
			if (evento.equals(observer.getEvento())) {
				observer.update(delegate);
			}
		}
	}

	@Override
	public void partir(float velocidade) {
		super.partir(velocidade);
		notifyObservers(OperacaoCarroEvento.PARTIR);
	}

	@Override
	public float getVelocidade() {
		return super.getVelocidade();
	}

	@Override
	public Linha getLinha() {
		return super.getLinha();
	}

	@Override
	public float getPosicaoAtual() {
		return super.getPosicaoAtual();
	}

	@Override
	public long getUltimaVerificacaoDeVelocidade() {
		return super.getUltimaVerificacaoDeVelocidade();
	}

	@Override
	public void alterarPosicao(float posicao) {
		super.alterarPosicao(posicao);
		notifyObservers(OperacaoCarroEvento.ALTERAR_POSICAO);
	}

}
