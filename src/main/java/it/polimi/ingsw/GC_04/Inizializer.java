package it.polimi.ingsw.GC_04;

import java.util.Arrays;
import java.util.List;

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
	private final BuildingCard[] bCards;
	private final CharacterCard[] cCards;
	private final VentureCard[] vCards;

	
	public Inizializer(Player[] players,TerritoryCard[] tCards,BuildingCard[] bCards,CharacterCard[] cCards,VentureCard[] vCards, List<ActionSpace> aSpaces) {
		
		
		this.tCards = tCards;
		this.bCards = bCards;
		this.cCards = cCards;
		this.vCards = vCards;
		CouncilPalaceArea.instance(players);
		TerritoryTower.instance(Arrays.copyOfRange(tCards, initialPosition, finalPosition), aSpaces.subList(0, 3));
		BuildingTower.instance(Arrays.copyOfRange(bCards, initialPosition, finalPosition), aSpaces.subList(4, 7));
		VentureTower.instance(Arrays.copyOfRange(vCards, initialPosition, finalPosition), aSpaces.subList(8, 11));
		CharacterTower.instance(Arrays.copyOfRange(cCards, initialPosition, finalPosition), aSpaces.subList(12, 15));
		MarketArea.instance(aSpaces.subList(15, aSpaces.size()-1));
		HarvestArea.instance();
		ProductionArea.instance();
		
		initialPosition = 4;
		finalPosition = 7;
	
		// TODO: far prendere gli array da file
		
		//Model model = new Model(Player);
	}
	
	public void changeTurn() {
		TerritoryTower.instance().resetTower(Arrays.copyOfRange(tCards, initialPosition, finalPosition));
		BuildingTower.instance().resetTower(Arrays.copyOfRange(bCards, initialPosition, finalPosition));
		VentureTower.instance().resetTower(Arrays.copyOfRange(tCards, initialPosition, finalPosition));
		CharacterTower.instance().resetTower(Arrays.copyOfRange(tCards, initialPosition, finalPosition));
	}
}
