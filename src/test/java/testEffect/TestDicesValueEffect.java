package testEffect;

import static org.junit.Assert.*;

import org.junit.Test;

import it.polimi.ingsw.GC_04.server.model.DiceColor;
import it.polimi.ingsw.GC_04.server.model.effect.DicesValueEffect;

public class TestDicesValueEffect extends TestEffect {

	private DicesValueEffect dVE;
	
	
	@Test
	public void testDicesValueEffect() {
		
		dVE = new DicesValueEffect(3, true, true);
		dVE.apply(player);
		
		assertEquals(3,player.getFamilyMember(DiceColor.NEUTRAL).getDice().getValue());
		
		dVE = new DicesValueEffect(3, false, false);
		dVE.apply(player);
		
		for (int i = 1; i < player.getFamily().length; i++) 
			assertEquals(3, player.getFamily()[i].getDice().getValue());
		
		dVE = new DicesValueEffect(3, true, false);
		dVE.apply(player);
		
		for (int i = 1; i < player.getFamily().length; i++) 
			assertEquals(6, player.getFamily()[i].getDice().getValue());
		
	}
}
