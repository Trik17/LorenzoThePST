package it.polimi.ingsw.GC_04.model.effect;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.card.DevelopmentCard;

public class ExtraDiceEffect extends Effect {

	private DevelopmentCard cardType;
	private int extra;
	
	@JsonCreator
	public ExtraDiceEffect(@JsonProperty("cardType")DevelopmentCard cardType,@JsonProperty("extra") int extra) {
		this.cardType = cardType;
		this.extra = extra;
	}

	@Override
	public void apply(Player player) {
		
		player.getExtraDice().setExtra(cardType, extra);
	
	}

}
