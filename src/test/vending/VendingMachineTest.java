package vending;

import static org.junit.Assert.*;

import org.junit.Test;

public class VendingMachineTest {
	
	protected VendingMachine vend;
	protected Dispenser d;
	
	
	
	@Test
	public void inicializacaoMaquinaTest() {
		vend = new VendingMachine();
		assertEquals("inicializacao com valor 0 para curValue",
				0, vend.currValue);
		
		assertEquals("inicializacao com valor 0 para totValue",
				0, vend.totValue);
		
		assertTrue(vend.d != null);
		assertTrue(vend.d instanceof Dispenser);
	} 
	
	@Test
	public void verificaMoedaInserida() {
		vend = new VendingMachine();
		vend.insertCoin();
		assertEquals(vend.currValue, vend.COIN);
	}
	
	@Test
	public void retornaZero() {
		vend = new VendingMachine();
		vend.insertCoin();
		int value = vend.returnCoin();
		assertEquals(value, vend.COIN);
		assertEquals(vend.currValue,0);
	}
	
	@Test
	public void seDispenserMaiorQueZero() {
		vend = new VendingMachine();
		vend.insertCoin();
		vend.insertCoin();
		int selection = 1;
		assertEquals(vend.vendItem(selection),vend.currValue);
		
	}


}
