package testResource;

import static org.junit.Assert.*;

import org.junit.Test;

import it.polimi.ingsw.GC_04.model.resource.MilitaryPoints;
import it.polimi.ingsw.GC_04.model.resource.Resource;

public class TestMilitaryPoints {
	Resource m;
	
	@Test
	public void testIntEmpty() {
		m=new MilitaryPoints();
		assertEquals(0, m.getQuantity());
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
}
