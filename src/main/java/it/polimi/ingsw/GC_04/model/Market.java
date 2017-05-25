package it.polimi.ingsw.GC_04.model;

import java.util.ArrayList;

//è un Singleton
public class Market extends Area{
	private static Market market;

	public static void instance(ArrayList<ActionSpace> aSpaces){
		if (market == null) market = new Market(aSpaces);	
		
	}
	
	public Market(ArrayList<ActionSpace> aSpaces) {
		this.aSpaces = aSpaces;
	}
	
	public static Market getMarket() {
		return market;
	}
}
