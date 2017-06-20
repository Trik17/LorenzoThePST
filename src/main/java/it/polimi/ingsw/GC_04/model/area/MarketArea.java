package it.polimi.ingsw.GC_04.model.area;

import java.util.List;

import it.polimi.ingsw.GC_04.model.ActionSpace;

public class MarketArea extends Area{
	private static MarketArea instance;
	
	private MarketArea(List<ActionSpace> aSpaces) {
		this.aSpaces = aSpaces;
	}
	
	public static MarketArea instance(List<ActionSpace> aSpaces){
		if (instance == null) instance = new MarketArea(aSpaces);	
		return instance;
	}
	
	public static MarketArea instance() {
		return instance;
	}

	public void reset() {
		for (ActionSpace aSpace:aSpaces)
			aSpace.reset();
		
	}
}
