package it.polimi.ingsw.GC_04.server.model.resource;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MilitaryPoints extends Resource{
	private static final long serialVersionUID = -5760885375488786478L;
	private int malus;//necessary for the costs
	
	@JsonCreator
	public MilitaryPoints(@JsonProperty("quantity")int quantity,@JsonProperty("malus")int malus){
		super(quantity);
		if(malus<0)
			this.malus=0;
		else
			this.malus = malus;
	}
	
	public MilitaryPoints(int quantity){
		super(quantity);
		this.malus =0;
	}
	//constructor needed for Json
	public MilitaryPoints() {}
	
	public int getMalus() {
		return malus;	
	}
}
