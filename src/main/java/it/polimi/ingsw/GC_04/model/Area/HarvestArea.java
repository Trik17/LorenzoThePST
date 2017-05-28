package it.polimi.ingsw.GC_04.model.Area;

import java.util.ArrayList;

import it.polimi.ingsw.GC_04.model.ActionSpace;

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
