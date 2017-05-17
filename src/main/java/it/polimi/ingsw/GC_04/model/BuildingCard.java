package it.polimi.ingsw.GC_04.model;

public class BuildingCard extends DevelopementCard {
	
	

	@Override
	public void takeCard(Player player, ActionSpace aSpace, FamilyMember fMember, int servants) {
		TakeBuilding check = new TakeBuilding(player, this, aSpace, fMember,servants);
		if (check.isApplicable()){/*applica effetti*/}
		
	}

}
