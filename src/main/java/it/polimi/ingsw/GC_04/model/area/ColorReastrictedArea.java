package it.polimi.ingsw.GC_04.model.area;

import it.polimi.ingsw.GC_04.model.ActionSpace;
import it.polimi.ingsw.GC_04.model.FamilyColor;

public abstract class ColorReastrictedArea extends Area {
	private static final long serialVersionUID = -8615088704456333745L;

	public boolean isColorAvailable(FamilyColor color){
		if (color == FamilyColor.NEUTRAL) return true;
		
		for(ActionSpace aSpace:aSpaces) {
			if(color == aSpace.getPresentColor())
				return false;
		}
		
		return true;
	}
}
