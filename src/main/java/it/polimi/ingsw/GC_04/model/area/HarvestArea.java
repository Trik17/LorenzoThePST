package it.polimi.ingsw.GC_04.model.area;

import java.util.ArrayList;


public class HarvestArea extends ColorReastrictedArea {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8070328582738658717L;
	
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
