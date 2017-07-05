package it.polimi.ingsw.GC_04.server.model.card;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.polimi.ingsw.GC_04.server.model.effect.Effect;

public class ExcommunicationTile extends Card{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3426398436330356455L;
	
	private int period;
	private Effect effect;
	private String image;
	private String description;
	@JsonCreator
	public ExcommunicationTile(@JsonProperty("period") int period,@JsonProperty("image") String image,@JsonProperty("description") String description,@JsonProperty("effect") Effect effect) {
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
