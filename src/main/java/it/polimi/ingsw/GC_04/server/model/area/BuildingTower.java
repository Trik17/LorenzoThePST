package it.polimi.ingsw.GC_04.server.model.area;

import java.util.List;

import it.polimi.ingsw.GC_04.server.model.ActionSpace;
import it.polimi.ingsw.GC_04.server.model.card.BuildingCard;

public class BuildingTower extends Tower{

	private static final long serialVersionUID = -1484399818590572658L;
	
	
	public BuildingTower(BuildingCard[] cards, List<ActionSpace> aSpaces) {
		this.cards = cards;
		this.aSpaces = aSpaces;
	}
	

}
