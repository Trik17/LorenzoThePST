package it.polimi.ingsw.GC_04.server.model.area;

import java.util.List;

import it.polimi.ingsw.GC_04.server.model.ActionSpace;

public class MarketArea extends Area{
	private static final long serialVersionUID = 869502343725350378L;
	
	
	public MarketArea(List<ActionSpace> aSpaces) {
		this.aSpaces = aSpaces;
	}
	
	public void reset() {
		for (ActionSpace aSpace:aSpaces)
			aSpace.reset();
		
	}
}
