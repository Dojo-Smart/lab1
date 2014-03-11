package dojo.lab1.ferroviaria.core;

import java.util.HashMap;
import java.util.Map;

public class LinhaDAO {

	Map<String, String> linhas = new HashMap<String, String>();
	
	public String getLinha(String nomeLinha) {
		return linhas.get(nomeLinha);
	}

}
