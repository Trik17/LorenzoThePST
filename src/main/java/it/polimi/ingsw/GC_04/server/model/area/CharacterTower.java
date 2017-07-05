package it.polimi.ingsw.GC_04.server.model.area;

import java.util.List;

import it.polimi.ingsw.GC_04.server.model.ActionSpace;
import it.polimi.ingsw.GC_04.server.model.card.CharacterCard;

public class CharacterTower extends Tower{

	private static final long serialVersionUID = 7223429366887491979L;
	
		
	
	public CharacterTower(CharacterCard[] cards, List<ActionSpace> aSpaces) {
		this.cards = cards;
		this.aSpaces = aSpaces;
	}
	

}
