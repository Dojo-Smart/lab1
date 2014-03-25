package dojo.lab1.ferroviaria.core;

public interface OperacaoLinhaInfo {

	Linha getLinha();

	OperacaoCarroInfo getOperacao(String nomeCarro) throws OperacaoCarroNotFoundException;

}
