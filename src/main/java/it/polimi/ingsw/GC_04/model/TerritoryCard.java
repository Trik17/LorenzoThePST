package it.polimi.ingsw.GC_04.model;

public class TerritoryCard extends DevelopmentCard {

	@Override
	public void takeCard(Player player, ActionSpace aSpace, FamilyMember fMember, int servants) {
		TakeTerritory check = new TakeTerritory(player, this, aSpace, fMember,servants);
		if (check.isApplicable()){/*applica effetti*/}
		
	}

	

}
