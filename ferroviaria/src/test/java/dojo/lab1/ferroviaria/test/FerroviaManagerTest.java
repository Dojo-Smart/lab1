package dojo.lab1.ferroviaria.test;

import static org.testng.Assert.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dojo.lab1.ferroviaria.core.FerroviaManager;

public class FerroviaManagerTest {

	private FerroviaManager manager = new FerroviaManager();

	@BeforeClass
	public void setUp() {

	}

	@Test(groups = "ferrovia")
	public void testOperacao() throws InterruptedException {

		manager.iniciaOperacao("linha1", "carro1");

		Thread.sleep(10002);

		assertTrue(manager.getOperacao("linha1").getPosicaoAtual("carro1") >= 3000);
		assertEquals(FerroviaManager.PARADO, manager.getStatus("carro1"));
	}

}
