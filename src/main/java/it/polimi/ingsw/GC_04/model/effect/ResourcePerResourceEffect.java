package it.polimi.ingsw.GC_04.model.effect;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.resource.Resource;

public class ResourcePerResourceEffect extends ResourceEffect {
	private Resource playerResource;//player's resource type that must be counted
	private Resource bonusResource;
	
	@JsonCreator
	public ResourcePerResourceEffect(@JsonProperty("playerResource") Resource playerResource, @JsonProperty("bonusResource") Resource bonusResource) {
		effect = new ArrayList<Resource>();
		this.bonusResource=bonusResource;
		this.playerResource=playerResource;
	}
	
	
	@Override
	public void apply(Player player) {
		
		int bonus = bonusResource.getQuantity();
		int myQuantity = 0;
		
		List<Resource> myResources = player.getResources();
		Class<? extends Resource> resourceType = playerResource.getClass();
		
		for(Resource res:myResources) {
			if (resourceType.equals(res.getClass())){ 
				myQuantity = res.getQuantity();
				break;
			}
		}
		if (!(myQuantity==0)) {		
			bonus = bonus*(myQuantity/playerResource.getQuantity())-bonus;
			bonusResource.addQuantity(bonus);
			this.effect.add(bonusResource);
			super.apply(player);
		}
	}
	
	
}
