package it.polimi.ingsw.GC_04.server.model.area;

import it.polimi.ingsw.GC_04.server.model.ActionSpace;
import it.polimi.ingsw.GC_04.server.model.Model;
import it.polimi.ingsw.GC_04.server.model.card.DevelopmentCard;

public abstract class Tower extends ColorReastrictedArea {
	private static final long serialVersionUID = -7474104011804860543L;
	protected DevelopmentCard[] cards;
	
	public DevelopmentCard[] getCards() {
		return cards;
		
	}
	
	public void reset(DevelopmentCard[] cards) {
		this.cards = cards;

		for (ActionSpace aSpace:aSpaces)
			aSpace.reset();
			
		}

	
	public void deleteCard(Model model,DevelopmentCard devCard) {
		DevelopmentCard[] tower = model.getTower(devCard).getCards();
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
