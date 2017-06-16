package it.polimi.ingsw.GC_04.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.polimi.ingsw.GC_04.model.effect.Effect;

public class ActionSpace {
	
	private int activationCost;//necessary dice's value
	private Effect effect;
	private FamilyMember fMember;
	
	@JsonCreator
	public ActionSpace(@JsonProperty("activationCost") int activationCost,@JsonProperty("effect") Effect effect){
		
		this.activationCost = activationCost;
		this.effect = effect;
	}
	
	public void setFamilyMember(FamilyMember fMember) {
		this.fMember = fMember;
	}
	
	public void reset() {
		this.fMember = null;
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
