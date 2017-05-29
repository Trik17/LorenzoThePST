package it.polimi.ingsw.GC_04.model.Area;

import java.util.List;

import it.polimi.ingsw.GC_04.model.Card.DevelopmentCard;

public abstract class Tower extends ColorReastrictedArea {
	protected List<? extends DevelopmentCard> cards;
	
	public List<? extends DevelopmentCard> getCards() {
		return cards;
		
	}


}
