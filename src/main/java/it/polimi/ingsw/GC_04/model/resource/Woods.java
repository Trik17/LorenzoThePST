package it.polimi.ingsw.GC_04.model.resource;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Woods extends RawMaterial{
	@JsonCreator
	public Woods(@JsonProperty("quantity")int quantity){
		super(quantity);
	}
	//constructor needed for Json
		public Woods() {
			// TODO Auto-generated constructor stub
		}
}
