package it.polimi.ingsw.GC_04.model.Effect;

import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.Card.DevelopmentCard;
import it.polimi.ingsw.GC_04.model.Resource.Resource;

public class ResourcePerDevelopementCardEffect extends ResourceEffect {
	private DevelopmentCard card;
	private Resource bonusResource;
	
	public ResourcePerDevelopementCardEffect(DevelopmentCard card, Resource resource) {
		this.card = card;
		this.bonusResource = resource;
	}

	@Override
	public void apply(Player player) {
		int bonus = bonusResource.getQuantity();
		int myQuantity = player.getCards(card).size();
		
		bonus = bonus*myQuantity-bonus;
		bonusResource.addQuantity(bonus);
		this.effect.add(bonusResource);
		
		super.apply(player);
	}
	
}