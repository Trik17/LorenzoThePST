package it.polimi.ingsw.GC_04.model.effect;

import java.util.List;

import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.card.DevelopmentCard;
import it.polimi.ingsw.GC_04.model.resource.*;

public class DiscountEffect extends Effect {
	private DevelopmentCard cardType;
	private List<Resource> discount;
	
	public DiscountEffect(DevelopmentCard cardType, List<Resource> discount) {
		this.cardType = cardType;
		this.discount = discount;
	}

	
	@Override
	public void apply(Player player) {
		player.getDiscount().setDiscount(cardType, discount);

	}

}
