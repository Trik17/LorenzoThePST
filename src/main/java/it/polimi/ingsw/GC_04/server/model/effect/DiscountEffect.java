package it.polimi.ingsw.GC_04.server.model.effect;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.polimi.ingsw.GC_04.server.model.Player;
import it.polimi.ingsw.GC_04.server.model.card.DevelopmentCard;
import it.polimi.ingsw.GC_04.server.model.resource.*;

public class DiscountEffect extends Effect {
	private DevelopmentCard cardType;
	private List<Resource> discount;
	
	@JsonCreator
	public DiscountEffect(@JsonProperty("cardType") DevelopmentCard cardType,@JsonProperty("discount") List<Resource> discount) {
		this.cardType = cardType;
		this.discount = discount;
	}
	
	public DiscountEffect(){
		//json
	}

	
	@Override
	public void apply(Player player) {
		player.getDiscount().setDiscount(cardType, discount);

	}

}
