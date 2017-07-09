package testModel;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import it.polimi.ingsw.GC_04.server.model.ActionSpace;
import it.polimi.ingsw.GC_04.server.model.area.TerritoryTower;
import it.polimi.ingsw.GC_04.server.model.area.Tower;
import it.polimi.ingsw.GC_04.server.model.card.TerritoryCard;

public class TestAreas {

	@Test
	public void testTower() {
		TerritoryCard tCard = new TerritoryCard();
		TerritoryCard[] cards = new TerritoryCard[4];
		for (int i = 0; i < cards.length; i++) {
			cards[i] = tCard;
		}
		
		ActionSpace aSpace = new ActionSpace(0, null);
		List<ActionSpace> aSpaces = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			aSpaces.add(aSpace);
		}
		Tower tower = new TerritoryTower(cards, aSpaces);
		
		tower.reset(cards);
		
		assertArrayEquals(cards,tower.getCards());
		for (int j = 0; j < tower.getASpaces().size(); j++) {
			assertEquals(null,tower.getASpaces().get(j).getPresentColor());
		}
			
		
		
	}
}
