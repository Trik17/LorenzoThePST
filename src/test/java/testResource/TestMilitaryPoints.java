package testResource;

import static org.junit.Assert.*;

import org.junit.Test;

import it.polimi.ingsw.GC_04.server.model.resource.MilitaryPoints;

public class TestMilitaryPoints {
	MilitaryPoints m;
	
	@Test
	public void testIntEmpty() {
		m=new MilitaryPoints();
		assertEquals(0, m.getQuantity());
	}
	
	@Test
	public void testIntPosMalus() {
		m=new MilitaryPoints(1,3);
		assertEquals(3, m.getMalus());
	}
	
	@Test
	public void testIntPos() {
		m=new MilitaryPoints(1);
		assertEquals(1, m.getQuantity());
	}
	
	@Test
	public void testIntNeg() {
		m=new MilitaryPoints(-1);
		assertEquals(0, m.getQuantity());
	}
	
	@Test
	public void testIntNegMalus() {
		m=new MilitaryPoints(1,-3);
		assertEquals(0, m.getMalus());
	}
	
	@Test
	public void testModifyQuantityPos() {
		m=new MilitaryPoints();
		m.addQuantity(5);
		assertEquals(5, m.getQuantity());
	}
	
	@Test
	public void testModifyQuantityNeg() {
		m=new MilitaryPoints(6);
		m.addQuantity(-5);
		assertEquals(1, m.getQuantity());
	}
	@Test
	public void testModifyQuantityZero() {
		m=new MilitaryPoints(1);
		m.addQuantity(0);
		assertEquals(1, m.getQuantity());
	}
	@Test
	public void testReset(){
		m=new MilitaryPoints(3);
		m.reset();
		assertEquals(0, m.getQuantity());
	}
}
