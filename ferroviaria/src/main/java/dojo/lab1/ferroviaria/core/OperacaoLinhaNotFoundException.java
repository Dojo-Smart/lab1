package dojo.lab1.ferroviaria.core;

public class OperacaoLinhaNotFoundException extends Exception {

	public OperacaoLinhaNotFoundException(String nomeLinha) {
		super(nomeLinha);
	}

}
