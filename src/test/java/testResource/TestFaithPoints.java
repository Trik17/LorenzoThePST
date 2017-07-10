package testResource;

import static org.junit.Assert.*;

import org.junit.Test;

import it.polimi.ingsw.GC_04.server.model.resource.FaithPoints;
import it.polimi.ingsw.GC_04.server.model.resource.Resource;

public class TestFaithPoints {
	Resource p;
	
	@Test
	public void testIntEmpty() {
		p=new FaithPoints();
		assertEquals(0, p.getQuantity());
	}
	
	@Test
	public void testIntPos() {
		p=new FaithPoints(1);
		assertEquals(1, p.getQuantity());
	}
	
	@Test
	public void testIntNeg() {
		p=new FaithPoints(-1);
		assertEquals(0, p.getQuantity());
	}
	
	@Test
	public void testModifyQuantityPos() {
		p=new FaithPoints();
		p.addQuantity(5);
		assertEquals(5, p.getQuantity());
	}
	
	@Test
	public void testModifyQuantityNeg() {
		p=new FaithPoints(10);
		p.addQuantity(-5);
		assertEquals(5, p.getQuantity());
	}
	@Test
	public void testModifyQuantityZero() {
		p=new FaithPoints(1);
		p.addQuantity(0);
		assertEquals(1, p.getQuantity());
	}
	@Test
	public void testReset(){
		p=new FaithPoints(3);
		p.reset();
		assertEquals(0, p.getQuantity());
	}
}
