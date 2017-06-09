package it.polimi.ingsw.GC_04.model.card;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import it.polimi.ingsw.GC_04.model.ActionSpace;
import it.polimi.ingsw.GC_04.model.FamilyMember;
import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.area.BuildingTower;
import it.polimi.ingsw.GC_04.model.area.CharacterTower;
import it.polimi.ingsw.GC_04.model.area.TerritoryTower;
import it.polimi.ingsw.GC_04.model.area.Tower;
import it.polimi.ingsw.GC_04.model.area.VentureTower;
import it.polimi.ingsw.GC_04.model.effect.Effect;
import it.polimi.ingsw.GC_04.model.resource.Resource;

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
	private List<Resource> cost1; 
	private List<Resource> cost2;
	private List<Effect> effects;
	@JsonCreator
	public DevelopmentCard(@JsonProperty("period")int period,@JsonProperty("name") String name,@JsonProperty("cost1") List<Resource> cost1,@JsonProperty("cost2") List<Resource> cost2,@JsonProperty("effects") List<Effect> effects){
		this.period=period;
		this.name=name;
		this.cost1=cost1;
		this.cost2=cost2;
		this.effects=effects;
	}
	//constructor needed for Json
	public DevelopmentCard() {}
	


	public abstract void takeCard(Player player,ActionSpace aSpace, FamilyMember fMember,int servants,List<Resource> cost);
	
	public List<Resource> getCost1(){
		return cost1;
	}
	public List<Resource> getCost2(){
		return cost2;
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


