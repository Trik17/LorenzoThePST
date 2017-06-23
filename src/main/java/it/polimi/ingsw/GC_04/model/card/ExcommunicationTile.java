package it.polimi.ingsw.GC_04.model.card;

import it.polimi.ingsw.GC_04.model.effect.Effect;

public class ExcommunicationTile extends Card{
	
	private int period;
	private Effect effect;
	private String image;
	private String description;
	
	public ExcommunicationTile(int period, Effect effect, String description) {
		this.period = period;
		this.effect = effect;
		this.description = description;
		
	}
	
	public int getPeriod() {
		return period;
	}
	
	public Effect getEffect() {
		return effect;
	}
	
	public String getDescription() {
		return description;
	}
}
