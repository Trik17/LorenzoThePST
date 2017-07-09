package it.polimi.ingsw.GC_04.server.model.effect;

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
@Type(value = ExtraDiceCardEffect.class),
@Type(value = ExtraDiceHarvestEffect.class),
@Type(value = ExtraDiceProductionEffect.class),
})
public abstract class ExtraDiceEffect extends Effect {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4804934685343770134L;
	protected int extra;
	
	public ExtraDiceEffect(){
		//json
	}

	@JsonCreator
	public ExtraDiceEffect(@JsonProperty("extra") int extra) {
		this.extra = extra;
	}
}
