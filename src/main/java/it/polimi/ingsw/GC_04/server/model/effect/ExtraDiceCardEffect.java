package it.polimi.ingsw.GC_04.server.model.effect;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.polimi.ingsw.GC_04.server.model.Player;
import it.polimi.ingsw.GC_04.server.model.card.DevelopmentCard;

public class ExtraDiceCardEffect extends ExtraDiceEffect {
	private DevelopmentCard cardType;
	
	@JsonCreator
	public ExtraDiceCardEffect(@JsonProperty("cardType") DevelopmentCard cardType,@JsonProperty("extra") int extra) {
		super(extra);
		this.cardType = cardType;
	}
	public ExtraDiceCardEffect() {
		// json
	}

	@Override
	public void apply(Player player) {
		
		player.getExtraDice().setCardExtra(cardType, extra);
	
	}

}
