package it.polimi.ingsw.GC_04.model.resource;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Woods extends RawMaterial{
	private static final long serialVersionUID = -1231488793979672813L;
	@JsonCreator
	public Woods(@JsonProperty("quantity")int quantity){
		super(quantity);
	}
	//constructor needed for Json
		public Woods() {
			// TODO Auto-generated constructor stub
		}
}
