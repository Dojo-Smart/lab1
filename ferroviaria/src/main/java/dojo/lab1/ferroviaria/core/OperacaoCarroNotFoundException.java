package dojo.lab1.ferroviaria.core;

public class OperacaoCarroNotFoundException extends Exception {

	public OperacaoCarroNotFoundException(String nomeCarro) {
		super(nomeCarro);
	}

}
