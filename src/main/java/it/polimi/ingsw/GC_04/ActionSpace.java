package it.polimi.ingsw.GC_04;

public class ActionSpace {
	
	private int activationCost;//necessary dice's value
	private Effect effect;
	private FamilyMember fMember;
	
	
	public ActionSpace(int activationCost, Effect effect){
		
		this.activationCost = activationCost;
		this.effect = effect;
	}
	
	public boolean checkDiceValue(FamilyMember fMember){
		
		if (fMember.getValue() >= getActivationCost())
			return true;
		return false;
	}
	
	public int getActivationCost(){
		return activationCost;
	}
	
	public FamilyColor getPresentColor(){
		if (fMember == null) return null;
		return this.fMember.getFamilyColor();
	}
	
	public boolean isFree(){
		if(familyMember == null) return true;
		return false;
	}
}
