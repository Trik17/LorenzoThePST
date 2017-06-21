package it.polimi.ingsw.GC_04.model.area;

import java.util.ArrayList;
import java.util.List;

import it.polimi.ingsw.GC_04.model.ActionSpace;

public class ProductionArea extends ColorReastrictedArea{
	private static ProductionArea instance;
	private ActionSpace actionSpaceDefault;
	
	private ProductionArea(){
		this.aSpaces = new ArrayList<>();
		
	}
	
	public static ProductionArea instance(){
		if (instance==null) 
			instance = new ProductionArea();
		return instance;
	}
	
	public List<ActionSpace> getASpace() {
		return aSpaces;
	}
	public void reset() {
		aSpaces = new ArrayList<ActionSpace>();
		//TODO: dire a tricki come fare per gli effetti
	}
	public ActionSpace getActionSpaceDefault() {
		return actionSpaceDefault;
	}
}
