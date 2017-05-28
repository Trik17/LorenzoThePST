package it.polimi.ingsw.GC_04.model.Resource;
import com.fasterxml.jackson.annotation.JsonCreator;
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
	@Type(value = Woods.class),
	@Type(value = Stones.class),
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
		
		this.quantity = quantity;
	}
	
	public void modifyQuantity(int nOfResources){
		this.quantity += nOfResources;
	}
	
	public int getQuantity(){
		return quantity;
	}
	
	
}
