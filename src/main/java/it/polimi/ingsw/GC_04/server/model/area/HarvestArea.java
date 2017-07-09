package it.polimi.ingsw.GC_04.server.model.area;

import java.util.ArrayList;
import java.util.List;

import it.polimi.ingsw.GC_04.server.model.ActionSpace;

public class HarvestArea extends ColorReastrictedArea {
	private static final long serialVersionUID = 8070328582738658717L;
	private ActionSpace actionSpaceDefault;
	
	public HarvestArea() {
		this.aSpaces = new ArrayList<>();
		this.actionSpaceDefault = new ActionSpace(1, null);
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
