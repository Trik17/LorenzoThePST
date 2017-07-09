package testModel;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import it.polimi.ingsw.GC_04.server.model.ActionSpace;
import it.polimi.ingsw.GC_04.server.model.action.GoToTheMarket;

public class TestGoToTheMarket extends TestAction {

	GoToTheMarket goToTheMarket;
	List<ActionSpace> marketArea;
	
	@Before
	public void inizializer(){
		super.inizializer();
		marketArea = model.getMarket().getASpaces();
		goToTheMarket = new GoToTheMarket(model, player1, fMemberBlackP1, servants1,marketArea.get(1));
	
	}
	
	@Test
	public void testMarket1() {
		
		assertTrue(goToTheMarket.isApplicable());
		
		goToTheMarket.apply();
		
		assertEquals(fMemberBlackP1.getFamilyColor(), marketArea.get(1).getPresentColor());
		assertTrue(fMemberBlackP1.isUsed());
		
		goToTheMarket = new GoToTheMarket(model, player2, fMemberBlackP2, servants1,marketArea.get(1));
		assertFalse(goToTheMarket.isApplicable());
	
	}
	
}
