package testResource;

import static org.junit.Assert.*;

import org.junit.Test;

import it.polimi.ingsw.GC_04.server.model.resource.Coins;
import it.polimi.ingsw.GC_04.server.model.resource.Resource;

public class TestCoins {
	Resource c;
	
	@Test
	public void testIntEmpty() {
		c=new Coins();
		assertEquals(0, c.getQuantity());
	}
	
	@Test
	public void testIntPos() {
		c=new Coins(1);
		assertEquals(1, c.getQuantity());
	}
	
	@Test
	public void testIntNeg() {
		c=new Coins(-1);
		assertEquals(0, c.getQuantity());
	}
	
	@Test
	public void testModifyQuantityPos() {
		c=new Coins();
		c.addQuantity(5);
		assertEquals(5, c.getQuantity());
	}
	
	@Test
	public void testModifyQuantityNeg() {
		c=new Coins(6);
		c.addQuantity(-5);
		assertEquals(1, c.getQuantity());
	}
	@Test
	public void testModifyQuantityZero() {
		c=new Coins(1);
		c.addQuantity(0);
		assertEquals(1, c.getQuantity());
	}
	
	@Test
	public void testClone(){
		c=new Coins(3);
		c.addQuantity(2);
		Resource c1=Resource.clone(c);
		assertEquals(5, c1.getQuantity());
	}
	
	@Test
	public void testReset(){
		c=new Coins(3);
		c.reset();
		assertEquals(0, c.getQuantity());
	}

	

}
