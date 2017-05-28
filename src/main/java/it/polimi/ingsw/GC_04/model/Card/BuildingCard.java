package it.polimi.ingsw.GC_04.model.Card;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.polimi.ingsw.GC_04.model.ActionSpace;
import it.polimi.ingsw.GC_04.model.FamilyMember;
import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.Production;
import it.polimi.ingsw.GC_04.model.Action.TakeACard;
import it.polimi.ingsw.GC_04.model.Resource.Resource;

public class BuildingCard extends DevelopmentCard {
	private Production production;
	
	
	@JsonCreator
	public BuildingCard(@JsonProperty("period")int period,@JsonProperty("name") String name,@JsonProperty("cost") ArrayList<Resource> cost) {
		super(period, name, cost);
		// TODO Auto-generated constructor stub
	}
	//constructor needed for Json
	public BuildingCard() {
			// TODO Auto-generated constructor stub
	}

	@Override
	public void takeCard(Player player, ActionSpace aSpace, FamilyMember fMember, int servants) {
		TakeACard check = new TakeACard(player, this, aSpace, fMember,servants);
		if (check.isApplicable()){check.apply();}
		
	}

	public Production getProduction() {
		return production;
		
	}
}
