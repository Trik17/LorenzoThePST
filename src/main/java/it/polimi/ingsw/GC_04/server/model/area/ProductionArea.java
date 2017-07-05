package it.polimi.ingsw.GC_04.server.model.area;

import java.util.ArrayList;
import java.util.List;

import it.polimi.ingsw.GC_04.server.model.ActionSpace;

public class ProductionArea extends ColorReastrictedArea{
	private static final long serialVersionUID = 2343078907285078515L;
	private ActionSpace actionSpaceDefault;
	
	
	public ProductionArea(){
		this.aSpaces = new ArrayList<>();		
	}
	
	
	public List<ActionSpace> getASpace() {
		return aSpaces;
	}
	public void reset() {
		aSpaces = new ArrayList<ActionSpace>();
			}
	public ActionSpace getActionSpaceDefault() {
		return actionSpaceDefault;
	}
}
