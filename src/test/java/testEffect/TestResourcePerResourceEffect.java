package testEffect;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.polimi.ingsw.GC_04.server.model.effect.Effect;
import it.polimi.ingsw.GC_04.server.model.effect.ResourcePerResourceEffect;
import it.polimi.ingsw.GC_04.server.model.resource.Coins;
import it.polimi.ingsw.GC_04.server.model.resource.MilitaryPoints;
import it.polimi.ingsw.GC_04.server.model.resource.Resource;
import it.polimi.ingsw.GC_04.server.model.resource.VictoryPoints;

public class TestResourcePerResourceEffect extends TestEffect {
	private Resource pRes;
	private Resource bRes;
	private Effect rprEff;
	private Effect rprEff2;
	
	
	@Before
	public void inizialize(){
		pRes=new MilitaryPoints(5);
		bRes=new VictoryPoints(3);
		player.getResource(new MilitaryPoints()).addQuantity(6);
		rprEff=new ResourcePerResourceEffect(pRes, bRes);
		rprEff2=ResourcePerResourceEffect.clone(rprEff);
	}
	
	@Test
	public void testResourcePerResourceEffect(){
		assertTrue(rprEff2.getClass().equals(rprEff.getClass()));
		assertFalse(rprEff.isAuthorizationRequested());		
		rprEff.apply(player);
		assertEquals(6, player.getResource(new MilitaryPoints()).getQuantity());
		assertEquals(3, player.getResource(new VictoryPoints()).getQuantity());
	}

}