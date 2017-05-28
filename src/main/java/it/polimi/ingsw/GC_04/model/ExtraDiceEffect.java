package it.polimi.ingsw.GC_04.model;

public class ExtraDiceEffect extends Effect {

	public DevelopmentCard cardType;
	public int extra;
	
	public ExtraDiceEffect(DevelopmentCard cardType, int extra) {
		this.cardType = cardType;
		this.extra = extra;
	}

	@Override
	public void apply(Player player) {
		
		player.getExtraDice().setExtra(cardType, extra);
	
	}

}
