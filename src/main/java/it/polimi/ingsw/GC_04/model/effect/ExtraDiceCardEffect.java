package it.polimi.ingsw.GC_04.model.effect;

import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.card.DevelopmentCard;

public class ExtraDiceCardEffect extends ExtraDiceEffect {
	private DevelopmentCard cardType;
	
	public ExtraDiceCardEffect(DevelopmentCard cardType, int extra) {
		super(extra);
		this.cardType = cardType;
	}

	@Override
	public void apply(Player player) {
		
		player.getExtraDice().setCardExtra(cardType, extra);
	
	}

}
