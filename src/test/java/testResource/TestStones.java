package testResource;

import static org.junit.Assert.*;

import org.junit.Test;

import it.polimi.ingsw.GC_04.server.model.resource.Resource;
import it.polimi.ingsw.GC_04.server.model.resource.Stones;

public class TestStones {
	Resource s;
	
	@Test
	public void testIntEmpty() {
		s=new Stones();
		assertEquals(0, s.getQuantity());
	}
	
	@Test
	public void testIntPos() {
		s=new Stones(1);
		assertEquals(1, s.getQuantity());
	}
	
	@Test
	public void testIntNeg() {
		s=new Stones(-1);
		assertEquals(0, s.getQuantity());
	}
	
	@Test
	public void testModifyQuantityPos() {
		s=new Stones();
		s.addQuantity(5);
		assertEquals(5, s.getQuantity());
	}
	
	@Test
	public void testModifyQuantityNeg() {
		s=new Stones(10);
		s.addQuantity(-5);
		assertEquals(5, s.getQuantity());
	}
	@Test
	public void testModifyQuantityZero() {
		s=new Stones(1);
		s.addQuantity(0);
		assertEquals(1, s.getQuantity());
	}
	@Test
	public void testReset(){
		s=new Stones(3);
		s.reset();
		assertEquals(0, s.getQuantity());
	}
}
