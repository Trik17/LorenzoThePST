package it.polimi.ingsw.GC_04.model.resource;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class VictoryPoints extends Resource{
	
	@JsonCreator
	public VictoryPoints(@JsonProperty("quantity")int quantity){
		super(quantity);
	}
	//constructor needed for Json
		public VictoryPoints() {
			// TODO Auto-generated constructor stub
		}
	/* PER ORA COMMENTATI PERCHé NON HA SENSO CHE ANCHE COSE TIPO I COSTI ABBIANO GLI END VICTORY POINTS
	public void addEndPoints(int quantity){ 
		endAccumulator += quantity;
		
	}*/    
}
