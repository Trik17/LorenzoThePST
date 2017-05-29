package it.polimi.ingsw.GC_04.model.Action;

import it.polimi.ingsw.GC_04.model.ActionSpace;
import it.polimi.ingsw.GC_04.model.FamilyMember;
import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.Area.Area;
import it.polimi.ingsw.GC_04.model.Area.ColorReastrictedArea;

public abstract class Action {
	
	protected Player player;
	protected ActionSpace aSpace;
	protected FamilyMember fMember;
	protected int value; //TODO: calcolarlo nel costruttore//value of the dice with which the action is performed plus servants and any permanent effects
	protected Area area;
	
	public Action(Player player, FamilyMember fMember, int servants) {
		this.player = player;
		this.fMember = fMember;
		this.value = fMember.getDice().getValue() + servants;
		
	}
	
	public abstract boolean isApplicable();
	public abstract void apply();
	
	
	public boolean isValueEnough(){
		
		if (value >= aSpace.getActivationCost())
			return true;
		return false;
	}
	
	public boolean isColorAvailable(){
		if (area instanceof ColorReastrictedArea)
			return ((ColorReastrictedArea) area).isColorAvailable(fMember.getFamilyColor());
		return true;
		
	}
	public boolean isPlaceAvailable() {
		return aSpace.isAvailable();
		
	}
	
	public void applyActionSpaceEffect() {
		aSpace.getEffect().apply(player);
	}
	
	
}
