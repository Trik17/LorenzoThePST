package it.polimi.ingsw.GC_04.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.polimi.ingsw.GC_04.model.effect.Effect;

public class Production {
	private int diceValue;
	private List<Effect> effects;

	@JsonCreator
	public Production(@JsonProperty("diceValue") int diceValue,@JsonProperty("effects") List<Effect> effects) {
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
