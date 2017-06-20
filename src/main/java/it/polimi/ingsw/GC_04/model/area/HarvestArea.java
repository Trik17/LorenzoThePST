package it.polimi.ingsw.GC_04.model.area;

import java.util.ArrayList;

import it.polimi.ingsw.GC_04.model.ActionSpace;

public class HarvestArea extends ColorReastrictedArea {
	private static HarvestArea instance;
	
	private HarvestArea() {
		this.aSpaces = new ArrayList<ActionSpace>();
	}
	
	public static HarvestArea instance(){
		if (instance==null) instance = new HarvestArea();
		return instance;
	}
	public void reset() {
		aSpaces = new ArrayList<ActionSpace>();
		//TODO: dire a tricki come fare per gli effetti
	}
}
