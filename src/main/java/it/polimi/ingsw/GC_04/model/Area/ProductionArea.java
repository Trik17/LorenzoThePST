package it.polimi.ingsw.GC_04.model.Area;

import java.util.ArrayList;
import java.util.List;

import it.polimi.ingsw.GC_04.model.ActionSpace;

public class ProductionArea extends ColorReastrictedArea{
	private static ProductionArea instance;
	
	private ProductionArea(){
		this.aSpaces = new ArrayList<ActionSpace>();
		
	}
	
	public static ProductionArea instance(){
		if (instance==null) instance = new ProductionArea();
		return instance;
	}
	
	public List<ActionSpace> getASpace() {
		return aSpaces;
	}
}
