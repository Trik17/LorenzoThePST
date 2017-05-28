package it.polimi.ingsw.GC_04.model.Resource;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MilitaryPoints extends Resource{
	@JsonCreator
	public MilitaryPoints(@JsonProperty("quantity")int quantity){
		super(quantity);
	}
	//constructor needed for Json
		public MilitaryPoints() {
			// TODO Auto-generated constructor stub
		}
}
