package it.polimi.ingsw.GC_04.model;

import java.util.ArrayList;

public class VentureCard extends DevelopmentCard {

	public VentureCard(int period, String name, ArrayList<Resource> cost) {
		super(period, name, cost);
		// TODO Auto-generated constructor stub
	}
	//constructor needed for Json
		public VentureCard() {
			// TODO Auto-generated constructor stub
		}

	@Override
	public void takeCard(Player player, ActionSpace aSpace, FamilyMember fMember, int servants) {
		TakeACard check = new TakeACard(player, this, aSpace, fMember,servants);
		if (check.isApplicable()){check.apply();}
		
		
	}

}
