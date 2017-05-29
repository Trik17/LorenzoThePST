package it.polimi.ingsw.GC_04.model.Area;

import java.util.List;

import it.polimi.ingsw.GC_04.model.ActionSpace;
import it.polimi.ingsw.GC_04.model.Card.CharacterCard;

public class CharacterTower extends Tower{

	private static CharacterTower instance;
	
	private CharacterTower(List<CharacterCard> cards, List<ActionSpace> aSpaces) {
		this.cards = cards;
		this.aSpaces = aSpaces;
	}
	
	public static CharacterTower instance() {
		return instance;
		
	}
	public static CharacterTower instance(List<CharacterCard> cards, List<ActionSpace> aSpaces){
		if (instance==null) instance = new CharacterTower(cards, aSpaces);
		return instance;
	}

	public List<ActionSpace> getASpaces() {
		return aSpaces;
	}
	

}
