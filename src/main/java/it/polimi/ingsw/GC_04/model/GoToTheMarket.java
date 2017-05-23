package it.polimi.ingsw.GC_04.model;

public class GoToTheMarket extends Action {
	
	public GoToTheMarket(Player player, FamilyMember fMember, int servants) {
		super(player, fMember, servants);
		this.area = Market.instance();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isApplicable() {
		// TODO Auto-generated method stub
		return false;
	}
	

}
