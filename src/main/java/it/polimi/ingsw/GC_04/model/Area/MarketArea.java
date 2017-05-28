package it.polimi.ingsw.GC_04.model.Area;

import java.util.ArrayList;

import it.polimi.ingsw.GC_04.model.ActionSpace;

//è un Singleton
public class MarketArea extends Area{
	private static MarketArea market;

	public static void instance(ArrayList<ActionSpace> aSpaces){
		if (market == null) market = new MarketArea(aSpaces);	
		
	}
	
	public MarketArea(ArrayList<ActionSpace> aSpaces) {
		this.aSpaces = aSpaces;
	}
	
	public static MarketArea getMarket() {
		return market;
	}
}
