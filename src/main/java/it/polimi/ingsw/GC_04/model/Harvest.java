package it.polimi.ingsw.GC_04.model;

import java.util.List;

import it.polimi.ingsw.GC_04.model.effect.Effect;

public class Harvest {
	private int diceValue;
	private List<Effect> effects;

	public Harvest(int diceValue, List<Effect> effects) {
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
