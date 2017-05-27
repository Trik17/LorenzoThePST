package it.polimi.ingsw.GC_04.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class VictoryPoints extends Resource{
	//private int endAccumulator; //victory points from venture's cards, for the end of the game
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
