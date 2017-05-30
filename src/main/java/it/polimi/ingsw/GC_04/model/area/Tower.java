package it.polimi.ingsw.GC_04.model.area;

import java.util.List;

import it.polimi.ingsw.GC_04.model.card.DevelopmentCard;

public abstract class Tower extends ColorReastrictedArea {
	protected List<? extends DevelopmentCard> cards;
	
	public List<? extends DevelopmentCard> getCards() {
		return cards;
		
	}


}
