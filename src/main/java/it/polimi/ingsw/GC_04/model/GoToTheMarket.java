package it.polimi.ingsw.GC_04.model;

public class GoToTheMarket extends Action {
	
	public GoToTheMarket(Player player, FamilyMember fMember, int servants, ActionSpace aSpace) {
		super(player, fMember, servants);
		this.area = Market.getMarket();
		this.aSpace = aSpace;
	}

	@Override
	public boolean isApplicable() {
		return isPlaceAvailable() &&
				isValueEnough();
	}

	@Override
	public void apply() {
		applyActionSpaceEffect();
	}
	

}
