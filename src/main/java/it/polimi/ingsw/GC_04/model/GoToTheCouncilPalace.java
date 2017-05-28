package it.polimi.ingsw.GC_04.model;

//aggiunto setNext...
public class GoToTheCouncilPalace extends Action{

	public GoToTheCouncilPalace(Player player, FamilyMember fMember, int servants) {
		super(player, fMember, servants);
		this.area = CouncilPalaceArea.instance();
		
		
	}
	
	private void setNextTurnOrder() {
		CouncilPalaceArea.instance().setNextTurnOrder(player);
		
	}
	
	@Override
	public boolean isApplicable() {
		return isValueEnough();
	}

	@Override
	public void apply() {
		applyActionSpaceEffect();
		
	}

}
