package it.polimi.ingsw.GC_04;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.JsonMappingException;

import it.polimi.ingsw.GC_04.model.ActionSpace;
import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.area.BuildingTower;
import it.polimi.ingsw.GC_04.model.area.CharacterTower;
import it.polimi.ingsw.GC_04.model.area.CouncilPalaceArea;
import it.polimi.ingsw.GC_04.model.area.HarvestArea;
import it.polimi.ingsw.GC_04.model.area.MarketArea;
import it.polimi.ingsw.GC_04.model.area.ProductionArea;
import it.polimi.ingsw.GC_04.model.area.TerritoryTower;
import it.polimi.ingsw.GC_04.model.area.VentureTower;
import it.polimi.ingsw.GC_04.model.card.BuildingCard;
import it.polimi.ingsw.GC_04.model.card.CharacterCard;
import it.polimi.ingsw.GC_04.model.card.DevelopmentCard;
import it.polimi.ingsw.GC_04.model.card.TerritoryCard;
import it.polimi.ingsw.GC_04.model.card.VentureCard;

public class Initializer {
	private static int initialPosition = 0;
	private static int finalPosition = 4;
	
	private final TerritoryCard[] tCards;
	private final CharacterCard[] cCards;
	private final BuildingCard[] bCards;
	private final VentureCard[] vCards;

	
	public Initializer(Player[] players) throws JsonMappingException, IOException {
		JsonMapper jsonMapper=new JsonMapper();		
		
		int nrOfPlayers = players.length;
		
		this.tCards = jsonMapper.getTerritoryCardArray();
		this.cCards = jsonMapper.getCharacterCardArray();
		this.bCards = jsonMapper.getBuildingCardArray();
		this.vCards = jsonMapper.getVentureCardsArray();

		List<ActionSpace> aSpaces=jsonMapper.getActionSpaces();
		
		CouncilPalaceArea.instance(players);
		TerritoryTower.instance(Arrays.copyOfRange(tCards, initialPosition, finalPosition), aSpaces.subList(0,4));
		CharacterTower.instance(Arrays.copyOfRange(cCards, initialPosition, finalPosition), aSpaces.subList(5,8));
		BuildingTower.instance(Arrays.copyOfRange(bCards, initialPosition, finalPosition), aSpaces.subList(9,12));
		VentureTower.instance(Arrays.copyOfRange(vCards, initialPosition, finalPosition), aSpaces.subList(13,16));
		
		if (nrOfPlayers < 4)
			MarketArea.instance(aSpaces.subList(16, aSpaces.size()-2)); 
		else
			MarketArea.instance(aSpaces.subList(16, aSpaces.size()));
		
		HarvestArea.instance();
		ProductionArea.instance();
		
		initialPosition = 4;
		finalPosition = 8;
	}
	
	
	
	public void changeTurn() {
		TerritoryTower.instance().reset(Arrays.copyOfRange(tCards, initialPosition, finalPosition));
		CharacterTower.instance().reset(Arrays.copyOfRange(cCards, initialPosition, finalPosition));
		BuildingTower.instance().reset(Arrays.copyOfRange(bCards, initialPosition, finalPosition));
		VentureTower.instance().reset(Arrays.copyOfRange(vCards, initialPosition, finalPosition));
		
		MarketArea.instance().reset();
		HarvestArea.instance().reset();
		ProductionArea.instance().reset();
		
		initialPosition += 4;
		finalPosition += 4;
	}
	
	public List<DevelopmentCard> cardsOnTheTable() {
		List<DevelopmentCard> cardsOnTheTable = new ArrayList<DevelopmentCard>();
		cardsOnTheTable.addAll(Arrays.asList(TerritoryTower.instance().getCards()));
		cardsOnTheTable.addAll(Arrays.asList(CharacterTower.instance().getCards()));
		cardsOnTheTable.addAll(Arrays.asList(BuildingTower.instance().getCards()));
		cardsOnTheTable.addAll(Arrays.asList(VentureTower.instance().getCards()));
		System.out.println(VentureTower.instance().getASpaces().get(3));
		
		return cardsOnTheTable;
	}
	
}
