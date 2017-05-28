package it.polimi.ingsw.GC_04.model;

import java.util.ArrayList;

//è un Singleton
public class HarvestArea extends Area {
	private static HarvestArea instance;
	
	
	public static HarvestArea instance(){
		if (instance==null) instance = new HarvestArea();
		return instance;
	}
	
	private HarvestArea(){
		aSpaces = new ArrayList<ActionSpace>();
		
	}
	
}
