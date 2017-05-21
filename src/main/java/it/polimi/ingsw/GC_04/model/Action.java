package it.polimi.ingsw.GC_04.model;


//aggiunto metodo isColorAvailable
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
	
	public boolean isColorAvailable(Area area,FamilyMember fMember){
		return area.isColorAvailable(fMember.getFamilyColor());
		
	}
	
}
