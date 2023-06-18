package vending;

import static org.junit.Assert.*;

import org.junit.Test;

public class DispenserTest {

	protected Dispenser d;
	
	
	
	@Test
	public void veSeTaDisponivel() {
		d = new Dispenser();
		int sel = 1;
		assertTrue(d.available(sel));
	}
	
	@Test
	public void veSeNaoTaDisponivel() {
		d = new Dispenser();
		int sel = 5;
		assertFalse(d.available(sel));
	}

}
