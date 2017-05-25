package it.polimi.ingsw.GC_04.model;

public class BuildingCard extends DevelopmentCard {
	
	

	@Override
	public void takeCard(Player player, ActionSpace aSpace, FamilyMember fMember, int servants) {
		TakeACard check = new TakeACard(player, this, aSpace, fMember,servants);
		
		if (check.isApplicable()){/*applica effetti*/}
		
	}

}
