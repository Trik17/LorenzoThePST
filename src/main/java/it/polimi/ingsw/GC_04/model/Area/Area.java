package it.polimi.ingsw.GC_04.model.Area;

import java.util.ArrayList;

import it.polimi.ingsw.GC_04.model.ActionSpace;
import it.polimi.ingsw.GC_04.model.FamilyColor;
//aggiunti setter e getter
//cambiato nome attributo e messo static
//aggiunto metodo
public abstract class Area {

	protected static ArrayList<ActionSpace> aSpaces;//inizializzo gli aSpaces a parte e poi li passo ai costruttori delle varie aree
	
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
