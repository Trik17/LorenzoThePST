package it.polimi.ingsw.GC_04.model.effect;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import it.polimi.ingsw.GC_04.model.Player;

@JsonTypeInfo(use = Id.NAME,
include = JsonTypeInfo.As.PROPERTY,
property = "type")
@JsonSubTypes({
@Type(value = ActionEffect.class),
@Type(value = ExtraDiceEffect.class),
@Type(value = ResourceEffect.class), 
@Type(value = EndVictoryPointsEffect.class), 
@Type(value = DiscountEffect.class), 
@Type(value = ActionSpacePenalityEffect.class), 
@Type(value = ExchangeResourcesEffect.class),
})

public abstract class Effect {
	protected boolean requestedAuthorization;
	
	public boolean getRequestedAuthorization() {
		return requestedAuthorization;
		
	}
				
	public abstract void apply(Player player);
	
	public Effect(){//for json
	}
	
} 
