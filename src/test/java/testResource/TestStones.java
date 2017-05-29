package testResource;

import static org.junit.Assert.*;

import org.junit.Test;


import it.polimi.ingsw.GC_04.model.Resource.Resource;
import it.polimi.ingsw.GC_04.model.Resource.Stones;

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
		assertEquals(-1, s.getQuantity());
	}
	
	@Test
	public void testModifyQuantityPos() {
		s=new Stones();
		s.modifyQuantity(5);
		assertEquals(5, s.getQuantity());
	}
	
	@Test
	public void testModifyQuantityNeg() {
		s=new Stones();
		s.modifyQuantity(-5);
		assertEquals(-5, s.getQuantity());
	}
	@Test
	public void testModifyQuantityZero() {
		s=new Stones(1);
		s.modifyQuantity(0);
		assertEquals(1, s.getQuantity());
	}

}
