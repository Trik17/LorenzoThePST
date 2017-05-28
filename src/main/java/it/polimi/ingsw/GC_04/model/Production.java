package it.polimi.ingsw.GC_04.model;

import java.util.ArrayList;

import it.polimi.ingsw.GC_04.model.Effect.Effect;

public class Production {
	private int diceValue;
	private ArrayList<Effect> effects;

	public Production() {
		// TODO Auto-generated constructor stub
	}
	
	public int getDiceValue() {
		return diceValue;	
	}
	
	public ArrayList<Effect> getEffects() {
		return effects;
	}
}
