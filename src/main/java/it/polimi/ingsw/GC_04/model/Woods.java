package it.polimi.ingsw.GC_04.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Woods extends Resource{
	@JsonCreator
	public Woods(@JsonProperty("quantity")int quantity){
		super(quantity);
	}
	//constructor needed for Json
		public Woods() {
			// TODO Auto-generated constructor stub
		}
}
