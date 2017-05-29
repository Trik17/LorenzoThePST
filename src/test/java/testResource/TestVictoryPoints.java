package testResource;

import static org.junit.Assert.*;

import org.junit.Test;


import it.polimi.ingsw.GC_04.model.Resource.Resource;
import it.polimi.ingsw.GC_04.model.Resource.VictoryPoints;

public class TestVictoryPoints {
	Resource p;
	
	@Test
	public void testIntEmpty() {
		p=new VictoryPoints();
		assertEquals(0, p.getQuantity());
	}
	
	@Test
	public void testIntPos() {
		p=new VictoryPoints(1);
		assertEquals(1, p.getQuantity());
	}
	
	@Test
	public void testIntNeg() {
		p=new VictoryPoints(-1);
		assertEquals(-1, p.getQuantity());
	}
	
	@Test
	public void testModifyQuantityPos() {
		p=new VictoryPoints();
		p.modifyQuantity(5);
		assertEquals(5, p.getQuantity());
	}
	
	@Test
	public void testModifyQuantityNeg() {
		p=new VictoryPoints();
		p.modifyQuantity(-5);
		assertEquals(-5, p.getQuantity());
	}
	@Test
	public void testModifyQuantityZero() {
		p=new VictoryPoints(1);
		p.modifyQuantity(0);
		assertEquals(1, p.getQuantity());
	}
}
