package it.polimi.ingsw.GC_04.model;

import java.util.ArrayList;

//è un Singleton
public class Harvest extends Area {
	private static Harvest instance;
	
	
	public static Harvest instance(){
		if (instance==null) instance = new Harvest();
		return instance;
	}
	
	private Harvest(){
		aSpaces = new ArrayList<ActionSpace>();
		
	}
	
}
