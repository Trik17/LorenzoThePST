package it.polimi.ingsw.GC_04.model.Resource;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Servants extends Resource{
	@JsonCreator
	public Servants(@JsonProperty("quantity")int quantity){
		super(quantity);
	}
	//constructor needed for Json
		public Servants() {
			// TODO Auto-generated constructor stub
		}

}
