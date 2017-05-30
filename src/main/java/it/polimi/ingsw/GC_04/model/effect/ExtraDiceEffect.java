package it.polimi.ingsw.GC_04.model.effect;

import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.card.DevelopmentCard;

public class ExtraDiceEffect extends Effect {

	private DevelopmentCard cardType;
	private int extra;
	
	public ExtraDiceEffect(DevelopmentCard cardType, int extra) {
		this.cardType = cardType;
		this.extra = extra;
	}

	@Override
	public void apply(Player player) {
		
		player.getExtraDice().setExtra(cardType, extra);
	
	}

}
