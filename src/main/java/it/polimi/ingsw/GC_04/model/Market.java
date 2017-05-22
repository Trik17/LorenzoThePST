package it.polimi.ingsw.GC_04.model;

import java.util.ArrayList;
import java.util.List;

//è un Singleton
public class Market extends Area{
	private static Market instance;
	
	
	public static Market instance(){
		if (instance==null) instance = new Market();
		return instance;
	}
	
	private Market(){
		aSpaces = new ArrayList<ActionSpace>();
		
	}
	
}
