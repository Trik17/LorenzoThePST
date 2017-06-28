package it.polimi.ingsw.GC_04.model.card;

import it.polimi.ingsw.GC_04.model.effect.Effect;

public class ExcommunicationTile extends Card{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3426398436330356455L;
	
	private int period;
	private Effect effect;
	private String image;
	private String description;
	
	public ExcommunicationTile(int period, Effect effect, String description, String image) {
		this.period = period;
		this.effect = effect;
		this.description = description;
		this.image = image;
		
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
