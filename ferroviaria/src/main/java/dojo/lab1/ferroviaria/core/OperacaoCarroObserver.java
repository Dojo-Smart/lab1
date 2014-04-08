package dojo.lab1.ferroviaria.core;

public interface OperacaoCarroObserver {
	
	OperacaoCarroEvento getEvento();

	void update(OperacaoCarroCommand comando);

}
