package it.polimi.ingsw.GC_04.model.card;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.polimi.ingsw.GC_04.model.ActionSpace;
import it.polimi.ingsw.GC_04.model.FamilyMember;
import it.polimi.ingsw.GC_04.model.Harvest;
import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.action.TakeTerritory;
import it.polimi.ingsw.GC_04.model.effect.Effect;
import it.polimi.ingsw.GC_04.model.resource.Resource;

public class TerritoryCard extends DevelopmentCard {
	
	private Harvest harvest;
	
	@JsonCreator
	public TerritoryCard(@JsonProperty("period")int period,@JsonProperty("name") String name,@JsonProperty("cost1") List<Resource> cost1,@JsonProperty("cost2") List<Resource> cost2,@JsonProperty List<Effect> effects,@JsonProperty("harvest") Harvest harvest){
		super(period, name, cost1, cost2, effects);
		this.harvest = harvest;
	}
	//constructor needed for Json
		public TerritoryCard() {
			// TODO Auto-generated constructor stub
		}

	@Override
	public void takeCard(Player player,ActionSpace aSpace, FamilyMember fMember,int servants,List<Resource> cost){
		TakeTerritory check = new TakeTerritory(player, this, aSpace, fMember,servants, cost);
		if (check.isApplicable()){check.apply();}
		
	}

	public Harvest getHarvest() {
		return this.harvest;
	}

}
