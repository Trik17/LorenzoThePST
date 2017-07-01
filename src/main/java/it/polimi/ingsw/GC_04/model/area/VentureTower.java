package it.polimi.ingsw.GC_04.model.area;

import java.util.List;

import it.polimi.ingsw.GC_04.model.ActionSpace;
import it.polimi.ingsw.GC_04.model.card.VentureCard;

public class VentureTower extends Tower{
	private static final long serialVersionUID = 2006143910875010021L;
	
	public VentureTower(VentureCard[] cards, List<ActionSpace> aSpaces) {
		this.cards = cards;
		this.aSpaces = aSpaces;
	}
	
}
