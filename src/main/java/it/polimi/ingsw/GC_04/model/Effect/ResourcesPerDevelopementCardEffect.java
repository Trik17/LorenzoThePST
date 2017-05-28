package it.polimi.ingsw.GC_04.model.Effect;

import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.Card.DevelopmentCard;
import it.polimi.ingsw.GC_04.model.Resource.Resource;

public class ResourcesPerDevelopementCardEffect extends ResourceEffect {
	private DevelopmentCard card;
	private Resource resource;
	
	public ResourcesPerDevelopementCardEffect(DevelopmentCard card, Resource resource) {
		this.card = card;
		this.resource = resource;
	}

	@Override
	public void apply(Player player) {
		int bonus = resource.getQuantity();
		int myQuantity = player.getCards(card).size();
		
		bonus *= myQuantity;
		this.effect.add(resource);
		
		super.apply(player);
	}
	
}
