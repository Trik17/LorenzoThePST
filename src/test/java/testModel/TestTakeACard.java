package testModel;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import it.polimi.ingsw.GC_04.server.model.ActionSpace;
import it.polimi.ingsw.GC_04.server.model.Production;
import it.polimi.ingsw.GC_04.server.model.action.TakeACard;
import it.polimi.ingsw.GC_04.server.model.action.TakeTerritory;
import it.polimi.ingsw.GC_04.server.model.card.BuildingCard;
import it.polimi.ingsw.GC_04.server.model.card.DevelopmentCard;
import it.polimi.ingsw.GC_04.server.model.card.TerritoryCard;
import it.polimi.ingsw.GC_04.server.model.effect.CouncilPrivilege;
import it.polimi.ingsw.GC_04.server.model.effect.Effect;
import it.polimi.ingsw.GC_04.server.model.effect.ExchangeResourcesEffect;
import it.polimi.ingsw.GC_04.server.model.effect.ResourceEffect;
import it.polimi.ingsw.GC_04.server.model.effect.SimpleResourceEffect;
import it.polimi.ingsw.GC_04.server.model.resource.FaithPoints;
import it.polimi.ingsw.GC_04.server.model.resource.Resource;
import it.polimi.ingsw.GC_04.server.model.resource.Stones;
import it.polimi.ingsw.GC_04.server.model.resource.VictoryPoints;

public class TestTakeACard extends TestAction {
	
	DevelopmentCard territoryCard;
	DevelopmentCard buildingCard;
	ActionSpace aSpace;
	Production production;
	
	@Before
	public void inizializer(){
		super.inizializer();
		CouncilPrivilege cp1 = new CouncilPrivilege();
		cp1.setCouncilPrivilege(new VictoryPoints(3));
		List<Effect> aSpaceEff = new ArrayList<>();
		aSpaceEff.add(cp1);
		
		aSpace = new ActionSpace(1, aSpaceEff);
		List<Resource> eff2 = new ArrayList<>();
		eff2.add(new FaithPoints(4));
		
		ResourceEffect sre = new SimpleResourceEffect(eff2);
		
		List<Resource> cost = new ArrayList<>();
		cost.add(new Stones(1));
		
		List<ResourceEffect> eff1 = new ArrayList<>();
		eff1.add(sre);
		
		ExchangeResourcesEffect ere = new ExchangeResourcesEffect(eff1, cost, null, null);
		ere.setEffect(eff1, cost);
		
		List<Effect> effects = new ArrayList<>();
		effects.add(ere);
		
		production = new Production(1, effects);
		
		territoryCard = new TerritoryCard();
		buildingCard = new BuildingCard(0, null, null, null, cost, null, effects, production);
		
	}
	
	
	@Test
	public void testTakeABuilding(){
		TakeACard takeBCard = buildingCard.takeCard(model, player1, aSpace, fMemberNeutralP1, servants2, buildingCard.getCost1());
		
		assertTrue(takeBCard.isAffordable());
		assertTrue(takeBCard.isPBoardNotFull());
		
		takeBCard.checkExtraordinaryEffect();
		takeBCard.apply();
		assertEquals(production, player1.getProduction().get(1));
		assertEquals(3, player1.getResource(new VictoryPoints()).getQuantity());
		assertEquals(4, player1.getResource(new FaithPoints()).getQuantity());
		assertEquals(0, player1.getResource(new Stones()).getQuantity());
		
		DevelopmentCard card = new BuildingCard();
		
		player1.getCards(new BuildingCard()).add(card);
		player1.getCards(new BuildingCard()).add(card);
		player1.getCards(new BuildingCard()).add(card);
		player1.getCards(new BuildingCard()).add(card);
		player1.getCards(new BuildingCard()).add(card);
		
		assertFalse(takeBCard.isPBoardNotFull());
		
	}

	@Test
	public void testTakeATerritory() {
		
		TakeTerritory takeTCard = (TakeTerritory) territoryCard.takeCard(model, player1, aSpace, fMemberBlackP1, 0, null);
		assertTrue(takeTCard.isApplicable());
		
		assertEquals(territoryCard, takeTCard.getCard());
		
		player1.getCards(new TerritoryCard()).add(territoryCard);
		player1.getCards(new TerritoryCard()).add(territoryCard);
		
		takeTCard = (TakeTerritory) territoryCard.takeCard(model, player1, aSpace, fMemberNeutralP1, servants2, null);
		assertFalse(takeTCard.isApplicable());
		assertFalse(takeTCard.checkRequestedMilitaryPoints());
		
		
		
	}
	
	
	
}
