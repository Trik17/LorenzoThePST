package it.polimi.ingsw.GC_04.server.model.area;

import java.util.List;

import it.polimi.ingsw.GC_04.server.model.ActionSpace;
import it.polimi.ingsw.GC_04.server.model.card.TerritoryCard;

public class TerritoryTower extends Tower{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 495920269992265409L;

	public TerritoryTower(TerritoryCard[] cards, List<ActionSpace> aSpaces) {
		this.cards = cards;
		this.aSpaces = aSpaces;
	}

}
