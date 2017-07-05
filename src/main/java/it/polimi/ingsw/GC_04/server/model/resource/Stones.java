package it.polimi.ingsw.GC_04.server.model.resource;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Stones extends RawMaterial{
	private static final long serialVersionUID = -5262283298519991506L;
	@JsonCreator
	public Stones(@JsonProperty("quantity")int quantity){
		super(quantity);
	}
	//constructor needed for Json
		public Stones() {
			// TODO Auto-generated constructor stub
		}
}
