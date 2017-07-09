package testModel;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.polimi.ingsw.GC_04.server.controller.Initializer;
import it.polimi.ingsw.GC_04.server.model.DiceColor;
import it.polimi.ingsw.GC_04.server.model.Model;
import it.polimi.ingsw.GC_04.server.model.Player;
import it.polimi.ingsw.GC_04.server.model.action.GoToTheCouncilPalace;

public class TestGoToTheCouncilPalace {
	
	private int servants1 = 2;
	private int servants2 = 6;
	private int servants3 = 0;
	private GoToTheCouncilPalace goToTheCouncilPalace1;
	private GoToTheCouncilPalace goToTheCouncilPalace2;
	private GoToTheCouncilPalace goToTheCouncilPalace3;
	private GoToTheCouncilPalace goToTheCouncilPalace4;
	private Model model;
	private int last;
	
	@Before
	public void inizializer(){
		model = new Model();
		Player player1 = new Player("Luigi", 1);
		Player player2 = new Player("Martin", 2);
		Player[] players = new Player[2];
		players[0] = player1;
		players[1] = player1;
		Initializer initializer = new Initializer(players, model);
		last = model.getCouncilPalace().getASpaces().size();
		
		goToTheCouncilPalace1 = new GoToTheCouncilPalace(model, player1, player1.getFamilyMember(DiceColor.BLACK), servants1);
		goToTheCouncilPalace2 = new GoToTheCouncilPalace(model, player1, player1.getFamilyMember(DiceColor.BLACK), servants2);
		goToTheCouncilPalace3 = new GoToTheCouncilPalace(model, player1, player1.getFamilyMember(DiceColor.NEUTRAL), servants1);
		goToTheCouncilPalace4 = new GoToTheCouncilPalace(model, player1, player1.getFamilyMember(DiceColor.NEUTRAL), servants3);
		
		goToTheCouncilPalace1.createNewASpace();
	}
	
	
	
	@Test
	public void testCheckValueDice() {
		
		assertTrue(goToTheCouncilPalace1.isApplicable());
		assertFalse(goToTheCouncilPalace2.isApplicable());
		assertTrue(goToTheCouncilPalace3.isApplicable());
		assertFalse(goToTheCouncilPalace4.isApplicable());
		assertEquals(model.getCouncilPalace().getActionSpaceDefault(), model.getCouncilPalace().getASpaces().get(last));
	}
	
	

}
