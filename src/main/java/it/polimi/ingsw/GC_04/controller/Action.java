package it.polimi.ingsw.GC_04.controller;

import it.polimi.ingsw.GC_04.model.ActionSpace;
import it.polimi.ingsw.GC_04.model.FamilyMember;
import it.polimi.ingsw.GC_04.model.Player;

public abstract class Action {
	
	protected Player player;
	protected ActionSpace aSpace;
	protected FamilyMember fMember;
	protected int value;
	
	
	public abstract boolean isApplicable();
	
	public boolean isValueEnough(){
		
		if (value >= aSpace.getActivationCost())
			return true;
		return false;
	}
	
	
}
