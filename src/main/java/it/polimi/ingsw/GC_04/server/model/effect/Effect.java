package it.polimi.ingsw.GC_04.server.model.effect;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import it.polimi.ingsw.GC_04.server.model.Player;

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
@Type(value = MalusResourceEffect.class),
@Type(value = DeleteVPointsCardsEffect.class),
@Type(value = BonusTurnResourcesEffect.class),
@Type(value = NotRequestedMilitaryPoints.class),
@Type(value = DicesValueEffect.class),
})

public abstract class Effect implements Cloneable{
	
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
