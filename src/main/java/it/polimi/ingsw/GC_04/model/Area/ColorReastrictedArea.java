package it.polimi.ingsw.GC_04.model.Area;

import it.polimi.ingsw.GC_04.model.ActionSpace;
import it.polimi.ingsw.GC_04.model.FamilyColor;

public abstract class ColorReastrictedArea extends Area {
	
	public boolean isColorAvailable(FamilyColor color){
		if (color == FamilyColor.NEUTRAL) return true;
		
		for(ActionSpace aSpace:aSpaces) {
				if(color == aSpace.getPresentColor())
					return false;}
		
		return true;
	}
}
