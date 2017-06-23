package it.polimi.ingsw.GC_04.model.area;

import java.util.ArrayList;

import it.polimi.ingsw.GC_04.model.ActionSpace;

public class HarvestArea extends ColorReastrictedArea {
	private static HarvestArea instance;
	
	private HarvestArea() {
		this.aSpaces = new ArrayList<>();
	}
	
	public static HarvestArea instance(){
		if (instance==null) 
			instance = new HarvestArea();
		return instance;
	}
	public void reset() {
		aSpaces = new ArrayList<>();
	}
}
