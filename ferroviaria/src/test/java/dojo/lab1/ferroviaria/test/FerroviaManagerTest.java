package dojo.lab1.ferroviaria.test;

import static org.testng.Assert.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dojo.lab1.ferroviaria.core.FerroviaManager;
import dojo.lab1.ferroviaria.core.Linha;
import dojo.lab1.ferroviaria.core.LinhaDAO;
import dojo.lab1.ferroviaria.core.LinhaNotFoundException;
import dojo.lab1.ferroviaria.core.OperacaoCarroInfo;
import dojo.lab1.ferroviaria.core.OperacaoCarroNotFoundException;
import dojo.lab1.ferroviaria.core.OperacaoLinhaInfo;
import dojo.lab1.ferroviaria.core.OperacaoLinhaNotFoundException;

public class FerroviaManagerTest {

	private LinhaDAO linhaDAO;
	private FerroviaManager manager;
	private static final String NOME_LINHA = "linha1";

	@BeforeClass
	public void setUp() {
		linhaDAO = new LinhaDAO();
		manager = new FerroviaManager(linhaDAO);

		linhaDAO.addLinha(new Linha(NOME_LINHA, 30000f));

	}

	@Test(groups = "ferrovia")
	public void testOperacao() throws InterruptedException, LinhaNotFoundException, OperacaoLinhaNotFoundException,
			OperacaoCarroNotFoundException {

		// LinhaManager lm = manager.getLinha("linha1");

		manager.iniciaOperacao(NOME_LINHA, "carro1", 200);

		OperacaoLinhaInfo operacaoLinha = manager.getOperacao(NOME_LINHA);

		OperacaoCarroInfo operacaoCarro = operacaoLinha.getOperacao("carro1");

		// estacao 1... aguarda X tempos e após verifica se o carro chegou na
		// próxima estação
		Thread.sleep(11000);

		assertTrue(operacaoCarro.getPosicaoAtual() >= operacaoLinha.getLinha().getEstacoes().get(0));
		assertEquals(FerroviaManager.PARADO, manager.getStatus("carro1"));
		// estacao 2
		Thread.sleep(11000);

		assertTrue(operacaoCarro.getPosicaoAtual() >= operacaoLinha.getLinha().getEstacoes().get(1));
		assertEquals(FerroviaManager.PARADO, manager.getStatus("carro1"));

	}
}
