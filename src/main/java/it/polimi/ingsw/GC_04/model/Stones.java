package it.polimi.ingsw.GC_04.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Stones extends Resource{
	@JsonCreator
	public Stones(@JsonProperty("quantity")int quantity){
		super(quantity);
	}
	//constructor needed for Json
		public Stones() {
			// TODO Auto-generated constructor stub
		}
}
