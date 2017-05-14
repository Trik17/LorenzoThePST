package it.polimi.ingsw.GC_04;

public abstract class Action {
	
	protected Player player;
	protected ActionSpace aSpace;
	protected FamilyMember fMember;

	protected abstract boolean isApplicable();
	
	public boolean checkColorInTower(Tower tower,FamilyMember fMember){
		return tower.colorIsntThere(fMember.getFamilyColor());
	}
}
