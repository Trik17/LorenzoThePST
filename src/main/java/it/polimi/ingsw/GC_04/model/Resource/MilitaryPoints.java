package it.polimi.ingsw.GC_04.model.Resource;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MilitaryPoints extends Resource{
	private int malus;//it serves for the costs
	
	@JsonCreator
	public MilitaryPoints(@JsonProperty("quantity")int quantity,@JsonProperty("malus")int malus){
		super(quantity);
		this.malus = malus;
	}
	//constructor needed for Json
	public MilitaryPoints() {}
	
	public int getMalus() {
		return malus;
		
	}
}
