package it.polimi.ingsw.GC_04.model;

//aggiunto setNext...
public class GoToTheCouncilPalace extends Action{

	public GoToTheCouncilPalace(Player player, FamilyMember fMember, int servants) {
		this.player = player;
		this.fMember = fMember;
		
		
	}
	
	private void setNextTurnOrder() {
		CouncilPalace.instance().setNextTurnOrder(player);
		
	}
	
	@Override
	public boolean isApplicable() {
		return isValueEnough();
	}

}
