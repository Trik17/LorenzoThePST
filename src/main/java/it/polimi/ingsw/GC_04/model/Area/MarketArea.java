package it.polimi.ingsw.GC_04.model.Area;

import java.util.ArrayList;

import it.polimi.ingsw.GC_04.model.ActionSpace;

public class MarketArea extends Area{
	private static MarketArea instance;
	
	public MarketArea(ArrayList<ActionSpace> aSpaces) {
		this.aSpaces = aSpaces;
	}
	
	public static void instance(ArrayList<ActionSpace> aSpaces){
		if (instance == null) instance = new MarketArea(aSpaces);	
		
	}
	
	public static MarketArea instance() {
		return instance;
	}

}
