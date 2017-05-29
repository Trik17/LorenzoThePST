package it.polimi.ingsw.GC_04.model.Card;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.polimi.ingsw.GC_04.model.ActionSpace;
import it.polimi.ingsw.GC_04.model.FamilyMember;
import it.polimi.ingsw.GC_04.model.Harvest;
import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.Action.TakeTerritory;
import it.polimi.ingsw.GC_04.model.Resource.Resource;

public class TerritoryCard extends DevelopmentCard {
	
	private Harvest harvest;
	
	@JsonCreator
	public TerritoryCard(@JsonProperty("period")int period,@JsonProperty("name") String name,@JsonProperty("cost") ArrayList<Resource> cost) {
		super(period, name, cost);
		// TODO Auto-generated constructor stub
	}
	//constructor needed for Json
		public TerritoryCard() {
			// TODO Auto-generated constructor stub
		}

	@Override
	public void takeCard(Player player, ActionSpace aSpace, FamilyMember fMember, int servants) {
		TakeTerritory check = new TakeTerritory(player, this, aSpace, fMember,servants);
		if (check.isApplicable()){check.apply();}
		
	}

	public Harvest getHarvest() {
		return this.harvest;
	}

}
