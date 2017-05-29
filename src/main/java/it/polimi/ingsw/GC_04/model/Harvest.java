package it.polimi.ingsw.GC_04.model;

import java.util.List;

import it.polimi.ingsw.GC_04.model.Effect.Effect;

public class Harvest {
	private int diceValue;
	private List<Effect> effects;

	public Harvest(List<Effect> effects) {
		this.effects = effects;
	}
	
	public int getDiceValue() {
		return diceValue;	
	}
	
	public List<Effect> getEffects() {
		return effects;
	}

}
