package it.polimi.ingsw.GC_04.model.area;

import java.util.List;

import it.polimi.ingsw.GC_04.model.ActionSpace;
import it.polimi.ingsw.GC_04.model.card.TerritoryCard;

public class TerritoryTower extends Tower{
	private static TerritoryTower instance;
	
	
	private TerritoryTower(TerritoryCard[] cards, List<ActionSpace> aSpaces) {
		this.cards = cards;
		this.aSpaces = aSpaces;
	}
	
	public static TerritoryTower instance() {
		return instance;
		
	}
	public static TerritoryTower instance(TerritoryCard[] cards, List<ActionSpace> aSpaces){
		if (instance==null) instance = new TerritoryTower(cards, aSpaces);
		return instance;
	}

}
