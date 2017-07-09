package it.polimi.ingsw.GC_04.server.model.effect;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import it.polimi.ingsw.GC_04.server.model.Dice;

@JsonTypeInfo(use = Id.NAME,
include = JsonTypeInfo.As.PROPERTY,
property = "type")
@JsonSubTypes({
@Type(value = RunHarvestEffect.class),
@Type(value = RunProductionEffect.class),
@Type(value = TakeACardEffect.class),
})
public abstract class ActionEffect extends Effect {
	
	private static final long serialVersionUID = 4511208045756916722L;
	protected Dice dice;
	
	public ActionEffect() {
		// for Json
	}
	
	public Dice getDice(){
		return dice;
	}
}
