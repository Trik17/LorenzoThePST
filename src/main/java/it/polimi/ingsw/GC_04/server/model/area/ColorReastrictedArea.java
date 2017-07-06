package it.polimi.ingsw.GC_04.server.model.area;

import it.polimi.ingsw.GC_04.server.model.ActionSpace;
import it.polimi.ingsw.GC_04.server.model.FamilyColor;

public abstract class ColorReastrictedArea extends Area {
	private static final long serialVersionUID = -8615088704456333745L;

	public boolean isColorAvailable(FamilyColor color){
		if (color.equals(FamilyColor.NEUTRAL)) 
			return true;
		
		for(ActionSpace aSpace:aSpaces) {
			if(color.equals(aSpace.getPresentColor()))
				return false;
		}
		
		return true;
	}
}
