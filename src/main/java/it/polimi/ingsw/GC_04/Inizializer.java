package it.polimi.ingsw.GC_04;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.JsonMappingException;

import it.polimi.ingsw.GC_04.model.ActionSpace;
import it.polimi.ingsw.GC_04.model.Model;
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
import it.polimi.ingsw.GC_04.model.card.TerritoryCard;
import it.polimi.ingsw.GC_04.model.card.VentureCard;

public class Inizializer {
	private static int initialPosition = 0;
	private static int finalPosition = 3;
	
	private final TerritoryCard[] tCards;
	private final CharacterCard[] cCards;
	private final BuildingCard[] bCards;
	private final VentureCard[] vCards;

	
	public Inizializer(Player[] players) throws JsonMappingException, IOException {
		JsonMapper jsonMapper=new JsonMapper();		
		this.tCards = jsonMapper.getTerritoryCardArray();
		this.cCards = jsonMapper.getCharacterCardArray();
		this.bCards = jsonMapper.getBuildingCardArray();
		this.vCards = jsonMapper.getVentureCardsArray();		
		List<ActionSpace> aSpaces=jsonMapper.getActionSpaces();
		
		CouncilPalaceArea.instance(players);
		TerritoryTower.instance(Arrays.copyOfRange(tCards, initialPosition, finalPosition), aSpaces.subList(0,3));
		CharacterTower.instance(Arrays.copyOfRange(cCards, initialPosition, finalPosition), aSpaces.subList(4,7));
		BuildingTower.instance(Arrays.copyOfRange(bCards, initialPosition, finalPosition), aSpaces.subList(8,11));
		VentureTower.instance(Arrays.copyOfRange(vCards, initialPosition, finalPosition), aSpaces.subList(12,15));
		
		MarketArea.instance(aSpaces.subList(15, aSpaces.size()-1)); //calcolare meglio fino a dove prenderli
		HarvestArea.instance();
		ProductionArea.instance();
		
		initialPosition = 4;
		finalPosition = 7;
	}
	
	public void changeTurn() {
		TerritoryTower.instance().resetTower(Arrays.copyOfRange(tCards, initialPosition, finalPosition));
		BuildingTower.instance().resetTower(Arrays.copyOfRange(bCards, initialPosition, finalPosition));
		VentureTower.instance().resetTower(Arrays.copyOfRange(tCards, initialPosition, finalPosition));
		CharacterTower.instance().resetTower(Arrays.copyOfRange(tCards, initialPosition, finalPosition));
	}
}
