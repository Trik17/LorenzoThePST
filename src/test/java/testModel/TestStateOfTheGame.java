package testModel;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import it.polimi.ingsw.GC_04.server.controller.Initializer;
import it.polimi.ingsw.GC_04.server.controller.StateOfTheGameCLI;
import it.polimi.ingsw.GC_04.server.model.Dice;
import it.polimi.ingsw.GC_04.server.model.DiceColor;
import it.polimi.ingsw.GC_04.server.model.Model;
import it.polimi.ingsw.GC_04.server.model.Player;
import it.polimi.ingsw.GC_04.server.model.StateOfTheGame;
import it.polimi.ingsw.GC_04.server.model.StateOfTheGameGUI;
import it.polimi.ingsw.GC_04.server.model.card.BuildingCard;
import it.polimi.ingsw.GC_04.server.model.card.CharacterCard;
import it.polimi.ingsw.GC_04.server.model.card.TerritoryCard;
import it.polimi.ingsw.GC_04.server.model.card.VentureCard;

public class TestStateOfTheGame {
	
	StateOfTheGame state;
	StateOfTheGameGUI stateGUI;
	Model model;
	Player[] players;
	
	@Before
	public void initialize() {
		model = new Model();
		Player player1 = new Player("p1", 1);
		Player player2 = new Player("p2", 1);
		Player player3 = new Player("p3", 1);
		players = new Player[3];
		players[0] = player1;
		players[1] = player2;
		players[3] = player3;
		model.setPlayers(players);
		
		state = new StateOfTheGame();
		Initializer initializer = new Initializer(players, model);
		
	}

	@Test
	public void testState(){
		TerritoryCard[] tCards = (TerritoryCard[]) model.getTower(new TerritoryCard()).getCards();
		CharacterCard[] cCards = (CharacterCard[]) model.getTower(new CharacterCard()).getCards();
		BuildingCard[] bCards = (BuildingCard[]) model.getTower(new BuildingCard()).getCards();
		VentureCard[] vCards = (VentureCard[]) model.getTower(new VentureCard()).getCards();
		Map<DiceColor, Dice> dices = model.getDices();
		
		String stateCLI = StateOfTheGameCLI.printStateOfTheGame(model, tCards, cCards, bCards, vCards, dices);
		state.setStateCLI(stateCLI);
		assertEquals(stateCLI, state.getStateCLI());
		
		stateGUI= new StateOfTheGameGUI(model, players[0].getName());
		state.setStateGUI(stateGUI);
		for (int i = 0; i < tCards.length; i++) {
			assertEquals(tCards[i].getImage(), state.getStateGUI().getBigTower(new TerritoryCard())[i]);
			
		}
	}
}