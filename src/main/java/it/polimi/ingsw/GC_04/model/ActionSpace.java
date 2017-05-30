package it.polimi.ingsw.GC_04.model;

import it.polimi.ingsw.GC_04.model.effect.Effect;

public class ActionSpace {
	
	private int activationCost;//necessary dice's value
	private Effect effect;
	private FamilyMember fMember;
	
	
	public ActionSpace(int activationCost, Effect effect){
		
		this.activationCost = activationCost;
		this.effect = effect;
	}
	
	
	
	public int getActivationCost(){
		return activationCost;
	}
	
	public Effect getEffect() {
		return effect;
	}
	
	public FamilyColor getPresentColor(){
		if (fMember == null) return null;
		return this.fMember.getFamilyColor();
	}
	
	public boolean isAvailable(){
		if(fMember == null) return true;
		return false;
	}
}
