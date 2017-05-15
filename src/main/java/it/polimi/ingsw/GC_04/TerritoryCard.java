package it.polimi.ingsw.GC_04;

public class TerritoryCard extends DevelopementCard {

	@Override
	public void takeCard(Player player, ActionSpace aSpace, FamilyMember fMember, int servants) {
		TakeTerritory check = new TakeTerritory(player, this, aSpace, fMember,servants);
		if (check.isApplicable()){/*applica effetti*/}
		
	}

	

}
