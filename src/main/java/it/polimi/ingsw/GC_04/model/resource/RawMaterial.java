package it.polimi.ingsw.GC_04.model.resource;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@JsonTypeInfo(use = Id.NAME,
include = JsonTypeInfo.As.PROPERTY,
property = "type")
@JsonSubTypes({
	@Type(value = Woods.class),
	@Type(value = Stones.class),
})
public class RawMaterial extends Resource {

	public RawMaterial() {
	}
	
	@JsonCreator
	public RawMaterial(@JsonProperty("quantity") int quantity) {
		super(quantity);
	}
	

}
