package it.polimi.ingsw.GC_04.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Coins extends Resource{
	@JsonCreator
	public Coins(@JsonProperty("quantity")int quantity){
		super(quantity);
	}
	//constructor needed for Json
		public Coins() {
			// TODO Auto-generated constructor stub
		}
}
