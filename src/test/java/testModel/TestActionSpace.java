package testModel;

import static org.junit.Assert.*;

import org.junit.Test;

import it.polimi.ingsw.GC_04.server.model.ActionSpace;

public class TestActionSpace {
	ActionSpace actionSpace;
	
	@Test
	public void testCostNeg() {
		actionSpace=new ActionSpace(-4, null);
		assertEquals(0, actionSpace.getActivationCost());
	}
	
	@Test
	public void testCostPos() {
		actionSpace=new ActionSpace(4, null);
		assertEquals(4, actionSpace.getActivationCost());
	}
	
	@Test
	public void testEffectNull() {
		actionSpace=new ActionSpace(-4, null);
		assertEquals(null, actionSpace.getEffect());
	}
	
	
	

}
