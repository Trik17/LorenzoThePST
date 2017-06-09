package it.polimi.ingsw.GC_04.model.area;

import java.util.List;

import it.polimi.ingsw.GC_04.model.ActionSpace;
import it.polimi.ingsw.GC_04.model.card.CharacterCard;

public class CharacterTower extends Tower{

	private static CharacterTower instance;
	
	private CharacterTower(CharacterCard[] cards, List<ActionSpace> aSpaces) {
		this.cards = cards;
		this.aSpaces = aSpaces;
	}
	
	public static CharacterTower instance() {
		return instance;
		
	}
	public static CharacterTower instance(CharacterCard[] cards, List<ActionSpace> aSpaces){
		if (instance==null) instance = new CharacterTower(cards, aSpaces);
		return instance;
	}
	

}
