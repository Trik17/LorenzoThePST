package it.polimi.ingsw.GC_04.model;

import java.util.ArrayList;
//aggiunti setter e getter
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
	
	public static void setASpace() {
		aSpaces.add(new ActionSpace(1, null));
		
	}
	public static ArrayList<ActionSpace> getASpace() {
		return aSpaces;
	}
}
