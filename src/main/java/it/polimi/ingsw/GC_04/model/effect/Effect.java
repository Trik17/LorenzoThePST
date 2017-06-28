package it.polimi.ingsw.GC_04.model.effect;

import java.io.Serializable;

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

public abstract class Effect implements Cloneable, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5741007417003532404L;
	protected boolean requestedAuthorization;
	
	public boolean isAuthorizationRequested() {
		return requestedAuthorization;
		
	}
				
	public abstract void apply(Player player);
	
	public Effect(){//for json
	}
	
	public static Effect clone(Effect effect) {
		try {
			return (Effect) effect.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
		
	}
	
} 
