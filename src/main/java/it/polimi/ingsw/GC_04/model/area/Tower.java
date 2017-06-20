package it.polimi.ingsw.GC_04.model.area;

import it.polimi.ingsw.GC_04.model.ActionSpace;
import it.polimi.ingsw.GC_04.model.card.DevelopmentCard;

public abstract class Tower extends ColorReastrictedArea {
	protected DevelopmentCard[] cards;
	
	public DevelopmentCard[] getCards() {
		return cards;
		
	}
	
	public void reset(DevelopmentCard[] cards) {
		this.cards = cards;

		for (ActionSpace aSpace:aSpaces)
			aSpace.reset();
			
		}

	
	public void deleteCard(DevelopmentCard devCard) {
		DevelopmentCard[] tower = devCard.getTower().getCards();
		int card = 0;
		while (card < this.cards.length -1) {
			if (devCard.equals(tower[card])) {
				tower[card] = null;
				return;
			}
			card++;
		}

	}


}
