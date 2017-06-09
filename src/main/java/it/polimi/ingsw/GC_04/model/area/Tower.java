package it.polimi.ingsw.GC_04.model.area;

import it.polimi.ingsw.GC_04.model.card.DevelopmentCard;

public abstract class Tower extends ColorReastrictedArea {
	protected DevelopmentCard[] cards;
	
	public DevelopmentCard[] getCards() {
		return cards;
		
	}
	
	public void resetTower(DevelopmentCard[] cards) {
		this.cards = cards;
		aSpaces.forEach(aSpaces -> aSpaces.reset());
		
		
	}


}
