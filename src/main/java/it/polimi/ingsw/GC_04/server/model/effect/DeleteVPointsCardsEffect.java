package it.polimi.ingsw.GC_04.model.effect;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.card.DevelopmentCard;

public class DeleteVPointsCardsEffect extends Effect{
	private static final long serialVersionUID = 7462184367000902891L;
	DevelopmentCard cardType;
	@JsonCreator
	public DeleteVPointsCardsEffect(@JsonProperty("cardType") DevelopmentCard cardType) {
		this.cardType = cardType;
		
	}

	@Override
	public void apply(Player player) {
		player.setDeleteCardsEffectActive(cardType);
	}
}
