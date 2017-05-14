package it.polimi.ingsw.GC_04;

public class TerritoryCard extends DevelopementCard {

	@Override
	public void takeCard(Player player) {
		TakeTerritory check = new TakeTerritory(player, this);
		if (check.isApplicable()){/*applica effetti*/}
	}

}
