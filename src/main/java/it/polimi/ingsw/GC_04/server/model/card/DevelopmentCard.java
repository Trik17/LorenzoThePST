package it.polimi.ingsw.GC_04.server.model.card;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import it.polimi.ingsw.GC_04.server.model.ActionSpace;
import it.polimi.ingsw.GC_04.server.model.FamilyMember;
import it.polimi.ingsw.GC_04.server.model.Model;
import it.polimi.ingsw.GC_04.server.model.Player;
import it.polimi.ingsw.GC_04.server.model.action.TakeACard;
import it.polimi.ingsw.GC_04.server.model.area.Tower;
import it.polimi.ingsw.GC_04.server.model.effect.Effect;
import it.polimi.ingsw.GC_04.server.model.resource.Resource;

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
	private String image;
	private String imageResized;
	private List<Resource> cost1; 
	private List<Resource> cost2;
	private List<Effect> effects;
	@JsonCreator
	public DevelopmentCard(@JsonProperty("period")int period,@JsonProperty("name") String name, @JsonProperty("image") String image,@JsonProperty("imageResized") String imageResized, @JsonProperty("cost1") List<Resource> cost1,@JsonProperty("cost2") List<Resource> cost2,@JsonProperty("effects") List<Effect> effects){
		this.period=period;
		this.name=name;
		this.image=image;
		this.imageResized=imageResized;
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
	public String getImageResized() {
		return imageResized;
	}
	
	public static DevelopmentCard[] toArray(List<DevelopmentCard> list) {
		DevelopmentCard[] array = new DevelopmentCard[list.size()];
		for (int i = 0; i < list.size(); i++) {
			array[i] = list.get(i);
		}
		return array;
	}
	
	//it checks if the player has enough development cards to activate a leader card
	public static boolean isAffordable(Player player, List<DevelopmentCard> activationRequirementCard) {
		
		if (activationRequirementCard == null)
			return true;
		
		int tCards = 0;
		int cCards = 0;
		int bCards = 0;
		int vCards = 0;
		
		for (DevelopmentCard card : activationRequirementCard) {
			if (card instanceof TerritoryCard)
				tCards++;
			if (card instanceof CharacterCard)
				cCards++;
			if (card instanceof BuildingCard)
				bCards++;
			if (card instanceof VentureCard)
				vCards++;
		}
		
		if (player.getCards(new TerritoryCard()).size() < tCards)
			return false;
		if (player.getCards(new CharacterCard()).size() < cCards)
			return false;
		if (player.getCards(new BuildingCard()).size() < bCards)
			return false;
		if (player.getCards(new VentureCard()).size() < vCards)
			return false;
		
		return true;
	}	
	
	
}


