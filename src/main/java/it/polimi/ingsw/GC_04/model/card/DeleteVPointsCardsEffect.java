package it.polimi.ingsw.GC_04.model.card;

import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.effect.Effect;

public class DeleteVPointsCardsEffect extends Effect{

	DevelopmentCard cardType;
	
	public DeleteVPointsCardsEffect(DevelopmentCard cardType) {
		this.cardType = cardType;
		
	}

	@Override
	public void apply(Player player) {
		player.setDeleteCardsEffectActive(cardType);
	}
}
