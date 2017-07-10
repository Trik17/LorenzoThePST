package it.polimi.ingsw.GC_04.server.model.resource;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FaithPoints extends Resource {
	private static final long serialVersionUID = -1936282194198544735L;
	@JsonCreator
	public FaithPoints(@JsonProperty("quantity")int quantity){
		super(quantity);
	}
	//constructor needed for Json
		public FaithPoints() {
		}
	
}
