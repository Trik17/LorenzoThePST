package it.polimi.ingsw.GC_04.model.effect;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.resource.Resource;


@JsonTypeInfo(use = Id.NAME,
include = JsonTypeInfo.As.PROPERTY,
property = "type")
@JsonSubTypes({
@Type(value = SimpleResourceEffect.class),
@Type(value = ResourcePerResourceEffect.class),
@Type(value = ResourcePerDevelopmentCardEffect.class),
@Type(value = CouncilPrivilege.class),
})
public abstract class ResourceEffect extends Effect {
	protected List<Resource> effect;
	
	public ResourceEffect() {
		// for Json
	}

	@Override
	public void apply(Player player){
		Resource.addResource(player.getResources(),effect);
	}
	
	public List<Resource> getEffect(){
		return effect;
	}
		
}
