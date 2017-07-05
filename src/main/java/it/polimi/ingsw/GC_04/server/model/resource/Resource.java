package it.polimi.ingsw.GC_04.model.resource;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

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

public abstract class Resource implements Cloneable, Serializable{
	private static final long serialVersionUID = -7651579067817205629L;
	private int quantity;
	//constructor needed for Json
	public Resource() {
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
		boolean isResPresent = false;
		
		for(int i = 0; i < bonus.size(); i++) {
			for(int j = 0; j < resources.size(); j++) {
				if(resources.get(j).getClass().equals(bonus.get(i).getClass())) {
					resources.get(j).addQuantity(bonus.get(i).getQuantity());
					isResPresent = true;
					break;
				}
			}
			if (!isResPresent)
				resources.add(bonus.get(i));
			
			isResPresent = false;
		}
	}
	
	public static void subtractResource(List<Resource> resources, List<Resource> cost){
		//for each bonus resource in input it takes the correspondent resource in the parameter resources and subtracts to it the cost 
		for(int i = 0; i < cost.size(); i++) {
			for(int j = 0; j < resources.size(); j++) {
				if (resources.get(j).getClass().equals(cost.get(i).getClass())){ 
					if (resources.get(j).getClass().equals(MilitaryPoints.class))
						resources.get(j).addQuantity(-((MilitaryPoints) cost.get(i)).getMalus());
					else if (resources.get(j).getQuantity()-cost.get(i).getQuantity() < 0) 
						resources.get(j).quantity = 0;
					else 
						resources.get(j).addQuantity(-cost.get(i).getQuantity());
						break;
				}
			}
		}
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
