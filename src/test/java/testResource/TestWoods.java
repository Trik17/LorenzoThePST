package testResource;

import static org.junit.Assert.*;

import org.junit.Test;

import it.polimi.ingsw.GC_04.model.resource.Resource;
import it.polimi.ingsw.GC_04.model.resource.Woods;

public class TestWoods {
	Resource w;
	
	@Test
	public void testWoodsIntEmpty() {
		w=new Woods();
		assertEquals(0, w.getQuantity());
	}
	
	@Test
	public void testWoodsIntPos() {
		w=new Woods(1);
		assertEquals(1, w.getQuantity());
	}
	
	@Test
	public void testWoodsIntNeg() {
		w=new Woods(-1);
		assertEquals(-1, w.getQuantity());
	}
	
	@Test
	public void testModifyQuantityPos() {
		w=new Woods();
		w.addQuantity(5);
		assertEquals(5, w.getQuantity());
	}
	@Test
	public void testModifyQuantityNeg() {
		w=new Woods();
		w.addQuantity(-5);
		assertEquals(-5, w.getQuantity());
	}
	@Test
	public void testModifyQuantityZero() {
		w=new Woods(1);
		w.addQuantity(0);
		assertEquals(1, w.getQuantity());
	}

	

}
