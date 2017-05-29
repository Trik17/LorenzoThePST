package it.polimi.ingsw.GC_04.model.Card;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import it.polimi.ingsw.GC_04.model.ActionSpace;
import it.polimi.ingsw.GC_04.model.FamilyMember;
import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.Area.BuildingTower;
import it.polimi.ingsw.GC_04.model.Area.CharacterTower;
import it.polimi.ingsw.GC_04.model.Area.TerritoryTower;
import it.polimi.ingsw.GC_04.model.Area.Tower;
import it.polimi.ingsw.GC_04.model.Area.VentureTower;
import it.polimi.ingsw.GC_04.model.Resource.Resource;

@JsonTypeInfo(use = Id.NAME,
include = JsonTypeInfo.As.PROPERTY,
property = "type")
@JsonSubTypes({
@Type(value = TerritoryCard.class),
@Type(value = CharacterCard.class),
@Type(value = BuildingCard.class),
@Type(value = VentureCard.class),
})

public abstract class DevelopmentCard extends Card{
	
	private int period;
	private String name;
	private ArrayList<Resource> cost; //possono avere più di un costo!
//	private ArrayList<Effect> immediateEffects;
//	private ArrayList<Effect> permanentEffects;
	public DevelopmentCard(@JsonProperty("period")int period,@JsonProperty("name") String name,@JsonProperty("cost") ArrayList<Resource> cost){
		this.period=period;
		this.name=name;
		this.cost=cost;
	}
	//constructor needed for Json
		public DevelopmentCard() {
			// TODO Auto-generated constructor stub
		}
	


	public abstract void takeCard(Player player,ActionSpace aSpace, FamilyMember fMember,int servants);
	
	//private void immediateEffect(ArrayList<Effect> effects){};
	//private void permanentEffect(ArrayList<Effect> effects){};
	
	public ArrayList<Resource> getCost(){
		return cost;
	}
	public int getPeriod(){
		return this.period;				
	}
	public String getName() {
		return this.name;
		
	}
	
	
	public Tower getTower() {
		
		if (this instanceof TerritoryCard) 
			return TerritoryTower.instance();
		if (this instanceof BuildingCard) 
			return BuildingTower.instance();
		if (this instanceof VentureCard) 
			return VentureTower.instance();
		else
			return CharacterTower.instance();
			
		
	}
	

	
//	public ArrayList<Effect> getImmediateE(){
//		return immediateEffects;
//	}
	
//	public ArrayList<Effect> getPermanentE(){
//		return permanentEffects;
//	}
	
	
}


