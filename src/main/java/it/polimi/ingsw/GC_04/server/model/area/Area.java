package it.polimi.ingsw.GC_04.server.model.area;

import java.io.Serializable;
import java.util.List;

import it.polimi.ingsw.GC_04.server.model.ActionSpace;

public abstract class Area implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7071768685899257396L;
	protected List<ActionSpace> aSpaces;
	
	public List<ActionSpace> getASpaces() {
		return aSpaces;
		
	}

}
