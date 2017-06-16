package it.polimi.ingsw.GC_04.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.polimi.ingsw.GC_04.model.effect.Effect;

public class ActionSpace {//METTERE LIST<EFFECT> AL POSTO DI UN SINGOLO EFFETTO
	
	private int activationCost;//necessary dice's value
	private Effect effect;
	private FamilyMember fMember;
	
	@JsonCreator
	public ActionSpace(@JsonProperty("activationCost") int activationCost,@JsonProperty("effect") Effect effect){
		
		this.effect = effect;
		if(activationCost<0)
			this.activationCost=0;
		else
			this.activationCost = activationCost;
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
