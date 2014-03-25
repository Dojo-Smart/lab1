package dojo.lab1.ferroviaria.core;

import java.util.HashMap;
import java.util.Map;

public class LinhaDAO {

	Map<String, Linha> linhas = new HashMap<String, Linha>();

	public Linha getLinha(String nomeLinha) {
		return linhas.get(nomeLinha);
	}

	public void addLinha(Linha linha) {
		
		linhas.put(linha.getNome(), linha);
	}
}
