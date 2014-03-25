package dojo.lab1.ferroviaria.core;

public class LinhaNotFoundException extends Exception {

	public LinhaNotFoundException(String nomeLinha) {
		super(nomeLinha);
	}

}
