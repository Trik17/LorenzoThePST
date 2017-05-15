package it.polimi.ingsw.GC_04;

public abstract class Action {
	
	//aggiunto metodo isValueEnough(), attributo int servants 
	
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
