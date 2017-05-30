package it.polimi.ingsw.GC_04.model;

import java.util.List;

import it.polimi.ingsw.GC_04.model.effect.Effect;

public class Production {
	private int diceValue;
	private List<Effect> effects;

	public Production() {
		// TODO Auto-generated constructor stub
	}
	
	public int getDiceValue() {
		return diceValue;	
	}
	
	public List<Effect> getEffects() {
		return effects;
	}
}
