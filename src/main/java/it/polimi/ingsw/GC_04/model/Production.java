package it.polimi.ingsw.GC_04.model;

import java.util.ArrayList;

//aggiunto attributo,ora estende area
public class Production extends Area {
	private static Production instance;
	
	public static Production instance(){
		if (instance==null) instance = new Production();
		return instance;
	}
	
	
	private Production(){
		aSpaces = new ArrayList<ActionSpace>();
		
	}
}
