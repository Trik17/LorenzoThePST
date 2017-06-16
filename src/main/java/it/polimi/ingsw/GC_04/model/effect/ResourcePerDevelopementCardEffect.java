package it.polimi.ingsw.GC_04.model.effect;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.card.DevelopmentCard;
import it.polimi.ingsw.GC_04.model.resource.Resource;

public class ResourcePerDevelopementCardEffect extends ResourceEffect {
	private DevelopmentCard cardType;
	private Resource bonusResource;
	
	@JsonCreator
	public ResourcePerDevelopementCardEffect(@JsonProperty("cardType") DevelopmentCard cardType,@JsonProperty("resource") Resource resource) {
		this.cardType = cardType;
		this.bonusResource = resource;
	}

	@Override
	public void apply(Player player) {
		int bonus = bonusResource.getQuantity();
		int myQuantity = player.getCards(cardType).size();
		if (!(myQuantity == 0)) {
			bonus = bonus*myQuantity-bonus;
			bonusResource.addQuantity(bonus);
			this.effect.add(bonusResource);
			super.apply(player);
		}
	}
	
}
