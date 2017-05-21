package it.polimi.ingsw.GC_04.model;

import java.util.ArrayList;

//cambiato nome attributo e messo static
//aggiunto metodo
public abstract class Area {

	protected static ArrayList<ActionSpace> aSpaces;
	
	public boolean isColorAvailable(FamilyColor color){
		if (color == FamilyColor.NEUTRAL) return true;
		
		for(ActionSpace aSpace:aSpaces) {
				if(color == aSpace.getPresentColor())
					return false;}
		
		return true;
		
	}
}
