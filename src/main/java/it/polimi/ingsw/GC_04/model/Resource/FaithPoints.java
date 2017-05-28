package it.polimi.ingsw.GC_04.model.Resource;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FaithPoints extends Resource {
	@JsonCreator
	public FaithPoints(@JsonProperty("quantity")int quantity){
		super(quantity);
	}
	//constructor needed for Json
		public FaithPoints() {
			// TODO Auto-generated constructor stub
		}
}
