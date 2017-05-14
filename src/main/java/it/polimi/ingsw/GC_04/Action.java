package it.polimi.ingsw.GC_04;

public abstract class Action {
	
	protected Player player;
	protected abstract boolean isApplicable();
	
	public boolean checkDiceValue(FamilyMember fMember, ActionSpace aSpace){
		
		if (fMember.getValue() >= aSpace.getActivationCost())
			return true;
		return false;
	}
	
	public boolean checkColorInTower(Tower tower){
		return tower.colorIsntThere(color)
	}
}
