package it.polimi.ingsw.GC_04.model.card;

import it.polimi.ingsw.GC_04.model.effect.Effect;

public class ExcommunicationTile extends Card{
	
	private int period;
	private Effect effect;
	private String image;
	
	public ExcommunicationTile(int period, Effect effect) {
		this.period = period;
		this.effect = effect;
		
	}
	
	public int getPeriod() {
		return period;
	}
	
	public Effect getEffect() {
		return effect;
	}
}
