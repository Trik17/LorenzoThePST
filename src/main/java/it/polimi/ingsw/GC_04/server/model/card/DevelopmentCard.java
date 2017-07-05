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
import it.polimi.ingsw.GC_04.model.Model;
import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.action.TakeACard;
import it.polimi.ingsw.GC_04.model.area.Tower;
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
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7123702582290532625L;
	
	private int period;
	private String name;
	private String image;
	private List<Resource> cost1; 
	private List<Resource> cost2;
	private List<Effect> effects;
	@JsonCreator
	public DevelopmentCard(@JsonProperty("period")int period,@JsonProperty("name") String name, @JsonProperty("image") String image, @JsonProperty("cost1") List<Resource> cost1,@JsonProperty("cost2") List<Resource> cost2,@JsonProperty("effects") List<Effect> effects){
		this.period=period;
		this.name=name;
		this.image=image;
		this.cost1=cost1;
		this.cost2=cost2;
		this.effects=effects;
	}
	//constructor needed for Json
	public DevelopmentCard() {}
	


	public abstract TakeACard takeCard(Model model, Player player,ActionSpace aSpace, FamilyMember fMember,int servants,List<Resource> cost);
	
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
	
	
	public Tower getTower(Model model) {
		
		if (this instanceof TerritoryCard) 
			return model.getTower(new TerritoryCard());
		else if (this instanceof BuildingCard) 
			return model.getTower(new BuildingCard());
		else if (this instanceof VentureCard) 
			return model.getTower(new VentureCard());
		else
			return model.getTower(new CharacterCard());
			
		
	}
	public List<Effect> getEffects() {
		return effects;
	}
	
	
	public String getImage() {
		return image;
	}
	
	public static DevelopmentCard[] toArray(List<DevelopmentCard> list) {
		DevelopmentCard[] array = new DevelopmentCard[list.size()];
		for (int i = 0; i < list.size(); i++) {
			array[i] = list.get(i);
		}
		return array;
	}
	
}


