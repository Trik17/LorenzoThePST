package it.polimi.ingsw.GC_04.model.area;

import java.util.List;

import it.polimi.ingsw.GC_04.model.ActionSpace;
import it.polimi.ingsw.GC_04.model.card.VentureCard;

public class VentureTower extends Tower{
	private static VentureTower instance;
	
	public VentureTower(List<VentureCard> cards, List<ActionSpace> aSpaces) {
		this.cards = cards;
		this.aSpaces = aSpaces;
	}
	
	public static VentureTower instance(List<VentureCard> cards, List<ActionSpace> aSpaces){
		if (instance==null) instance = new VentureTower(cards, aSpaces);
		return instance;
	}
	
	public static VentureTower instance() {
		return instance;
		
	}

	public List<ActionSpace> getASpaces() {
		return aSpaces;
	}
	

}
