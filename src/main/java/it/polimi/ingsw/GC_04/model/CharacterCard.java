package it.polimi.ingsw.GC_04.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CharacterCard extends DevelopmentCard {

	public CharacterCard(@JsonProperty("period")int period,@JsonProperty("name") String name,@JsonProperty("cost") ArrayList<Resource> cost) {
		super(period, name, cost);
		// TODO Auto-generated constructor stub
	}
	//constructor needed for Json
		public CharacterCard() {
			// TODO Auto-generated constructor stub
		}

	@Override
	public void takeCard(Player player, ActionSpace aSpace, FamilyMember fMember, int servants) {
		TakeACard check = new TakeACard(player, this, aSpace, fMember,servants);
		
		if (check.isApplicable()){check.apply();}
		
	}
		
	

}
