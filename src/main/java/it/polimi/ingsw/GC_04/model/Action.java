package it.polimi.ingsw.GC_04.model;

//aggiunto metodo isPlaceAvailable
//aggiunto metodo isColorAvailable
public abstract class Action {
	
	protected Player player;
	protected ActionSpace aSpace;
	protected FamilyMember fMember;
	protected int value; //value of the dice with which the action is performed plus servants and any permanent effects
	protected Area area;
	
	public Action(Player player, FamilyMember fMember, int servants) {
		this.player = player;
		this.fMember = fMember;
		// TODO Auto-generated constructor stub
	}
	
	public abstract boolean isApplicable();
	
	public boolean isValueEnough(){
		
		if (value >= aSpace.getActivationCost())
			return true;
		return false;
	}
	
	public boolean isColorAvailable(){
		return area.isColorAvailable(fMember.getFamilyColor());
		
	}
	public boolean isPlaceAvailable() {
		return aSpace.isAvailable();
		
	}
}
