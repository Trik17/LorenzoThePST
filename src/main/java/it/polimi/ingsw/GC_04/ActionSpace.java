package it.polimi.ingsw.GC_04;

public class ActionSpace {
	
	private int activationCost;//valore necessario del dado
	private Effect effect;
	private FamilyMember fMember;
	
	
	public ActionSpace(int activationCost, Effect effect){
		
		this.activationCost = activationCost;
		this.effect = effect;
	}
}
