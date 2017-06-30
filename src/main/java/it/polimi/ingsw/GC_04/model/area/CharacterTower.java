package it.polimi.ingsw.GC_04.model.area;

import java.util.List;

import it.polimi.ingsw.GC_04.model.ActionSpace;
import it.polimi.ingsw.GC_04.model.card.CharacterCard;

public class CharacterTower extends Tower{

	private static final long serialVersionUID = 7223429366887491979L;
	private static final ThreadLocal<CharacterTower> instance=new ThreadLocal<CharacterTower>(){ 
	    @Override 
	    protected CharacterTower initialValue() { 
	        //initialize YourObject 
	      return new CharacterTower(); 
	      } 
	};
	public static CharacterTower instance() {
		return instance.get();		
	}
	public static CharacterTower instance(CharacterCard[] cards, List<ActionSpace> aSpaces){
		instance.set(new CharacterTower(cards, aSpaces));
		return instance.get();
	}
		
	
	private CharacterTower(CharacterCard[] cards, List<ActionSpace> aSpaces) {
		this.cards = cards;
		this.aSpaces = aSpaces;
	}
	private CharacterTower() {
	}
	
	

}
