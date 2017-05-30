package it.polimi.ingsw.GC_04.model.area;

import java.util.List;

import it.polimi.ingsw.GC_04.model.ActionSpace;
import it.polimi.ingsw.GC_04.model.card.BuildingCard;


public class BuildingTower extends Tower{
	private static BuildingTower instance;
	
	public BuildingTower(List<BuildingCard> cards, List<ActionSpace> aSpaces) {
		this.cards = cards;
		this.aSpaces = aSpaces;
	}
	
	public static BuildingTower instance() {
		return instance;
		
	}
	public static BuildingTower instance(List<BuildingCard> cards, List<ActionSpace> aSpaces){
		if (instance==null) instance = new BuildingTower(cards, aSpaces);
		return instance;
	}
	
	public List<ActionSpace> getASpaces() {
		return aSpaces;
	}
	
}
