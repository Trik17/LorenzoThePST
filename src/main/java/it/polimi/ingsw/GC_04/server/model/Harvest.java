package it.polimi.ingsw.GC_04.server.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.polimi.ingsw.GC_04.server.model.effect.Effect;

public class Harvest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5870977217666406473L;
	private int diceValue;
	private List<Effect> effects;

	@JsonCreator
	public Harvest(@JsonProperty("diceValue") int diceValue,@JsonProperty("effects") List<Effect> effects) {
		this.effects = effects;
		this.diceValue = diceValue;
	}
	
	public int getDiceValue() {
		return diceValue;	
	}
	
	public List<Effect> getEffects() {
		return effects;
	}

}
