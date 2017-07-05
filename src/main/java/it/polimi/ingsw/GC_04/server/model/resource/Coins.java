package it.polimi.ingsw.GC_04.server.model.resource;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Coins extends Resource{
	private static final long serialVersionUID = -8378648965909241301L;
	@JsonCreator
	public Coins(@JsonProperty("quantity")int quantity){
		super(quantity);
	}
	//constructor needed for Json
		public Coins() {
			// TODO Auto-generated constructor stub
		}
}
