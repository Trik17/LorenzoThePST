package it.polimi.ingsw.GC_04.model;

import java.util.ArrayList;

//aggiunto attributo, setter e getter e ora estende area
public class Production extends Area {
	private static Production instance;
	
	
	
	
	public static Production instance(){
		if (instance==null) instance = new Production();
		return instance;
	}
	
	public static void setASpace() {
		aSpaces.add(new ActionSpace(1, null));
		
	}
	public static ArrayList<ActionSpace> getASpace() {
		return aSpaces;
	}
	
	private Production(){
		aSpaces = new ArrayList<ActionSpace>();
		
	}
}
