package it.polimi.ingsw.GC_04.model.resource;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import it.polimi.ingsw.GC_04.model.effect.Effect;

@JsonTypeInfo(use = Id.NAME,
	include = JsonTypeInfo.As.PROPERTY,
	property = "type")
@JsonSubTypes({
	@Type(value = Coins.class),
	@Type(value = RawMaterial.class),
	@Type(value = Servants.class),
	@Type(value = FaithPoints.class),
	@Type(value = MilitaryPoints.class),
	@Type(value = VictoryPoints.class),
})

public abstract class Resource {

	private int quantity;
	//constructor needed for Json
	public Resource() {
		// TODO Auto-generated constructor stub
	}
	
	public Resource(@JsonProperty("quantity")int quantity){
		if(quantity>0)
			this.quantity = quantity;
		
	}
	
	public void addQuantity(int nOfResources){
		this.quantity += nOfResources;
	}
	
	public int getQuantity(){
		return quantity;
	}
	
	public static void addResource(List<Resource> resources, List<Resource> bonus){
		//for each bonus resource in input it takes the correspondent resource in the parameter resources and adds to it the bonus 
		for(Resource b:bonus) {
			for(Resource r:resources) {
				if(r.getClass().equals(b.getClass())) {
					r.addQuantity(b.getQuantity());
					break;
				}
				resources.add(b);
			}
			
		}
	}
	
	public static void subtractResource(List<Resource> resources, List<Resource> cost){
		//for each bonus resource in input it takes the correspondent resource in the parameter resources and subtracts to it the cost 
		cost.forEach(b->
		resources.forEach(r-> {
			if(r.getClass().equals(b.getClass())) {
				if (r.getClass().equals(MilitaryPoints.class))
					r.addQuantity(-((MilitaryPoints) b).getMalus());
				else if (r.getQuantity()-b.getQuantity() < 0)
					r.quantity = 0;
				else
					r.addQuantity(-b.getQuantity());}}));
	}
	
	public static boolean isAffordable(List<Resource> myRes,List<Resource> cost) {
		for(Resource c:cost){  //for all resource type in cost
			for(Resource mR:myRes){
				//it scrolls through all types of player's resources and if the type coincides
				//it checks that the player's quantity of that resource is enough to buy the card. if it's not, set affordable = false.
				if(c.getClass().equals(mR.getClass()) && mR.getQuantity() < c.getQuantity()) 
					return false;
				}
			}
		return true;
	}
	
	public static Resource clone(Resource resource) {
		try {
			return (Resource) resource.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
		
	}
	
}
