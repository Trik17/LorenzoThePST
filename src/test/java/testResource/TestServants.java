package testResource;

import static org.junit.Assert.*;

import org.junit.Test;

import it.polimi.ingsw.GC_04.server.model.resource.Coins;
import it.polimi.ingsw.GC_04.server.model.resource.Resource;
import it.polimi.ingsw.GC_04.server.model.resource.Servants;

public class TestServants {

	Resource s;
	
	@Test
	public void testIntEmpty() {
		s=new Servants();
		assertEquals(0, s.getQuantity());
	}
	
	@Test
	public void testIntPos() {
		s=new Servants(1);
		assertEquals(1, s.getQuantity());
	}
	
	@Test
	public void testIntNeg() {
		s=new Servants(-1);
		assertEquals(0, s.getQuantity());
	}
	
	@Test
	public void testModifyQuantityPos() {
		s=new Servants();
		s.addQuantity(5);
		assertEquals(5, s.getQuantity());
	}
	
	@Test
	public void testModifyQuantityNeg() {
		s=new Servants(10);
		s.addQuantity(-5);
		assertEquals(5, s.getQuantity());
	}
	@Test
	public void testModifyQuantityZero() {
		s=new Servants(1);
		s.addQuantity(0);
		assertEquals(1, s.getQuantity());
	}

	@Test
	public void testReset(){
		s=new Servants(3);
		s.reset();
		assertEquals(0, s.getQuantity());
	}

}
