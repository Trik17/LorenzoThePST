package testResource;

import static org.junit.Assert.*;

import org.junit.Test;

import it.polimi.ingsw.GC_04.model.Coins;
import it.polimi.ingsw.GC_04.model.Resource;

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
		assertEquals(-1, c.getQuantity());
	}
	
	@Test
	public void testModifyQuantityPos() {
		c=new Coins();
		c.modifyQuantity(5);
		assertEquals(5, c.getQuantity());
	}
	
	@Test
	public void testModifyQuantityNeg() {
		c=new Coins();
		c.modifyQuantity(-5);
		assertEquals(-5, c.getQuantity());
	}
	@Test
	public void testModifyQuantityZero() {
		c=new Coins(1);
		c.modifyQuantity(0);
		assertEquals(1, c.getQuantity());
	}

	

}
