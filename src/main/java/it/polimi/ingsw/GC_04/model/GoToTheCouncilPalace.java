package it.polimi.ingsw.GC_04.model;

//aggiunto setNext...
public class GoToTheCouncilPalace extends Action{

	public GoToTheCouncilPalace(Player player, FamilyMember fMember, int servants) {
		super(player, fMember, servants);
		this.area = CouncilPalace.instance();
		
		
	}
	
	private void setNextTurnOrder() {
		CouncilPalace.instance().setNextTurnOrder(player);
		
	}
	
	@Override
	public boolean isApplicable() {
		return isValueEnough();
	}

}
