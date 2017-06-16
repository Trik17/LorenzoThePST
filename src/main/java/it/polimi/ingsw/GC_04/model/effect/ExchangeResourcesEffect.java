package it.polimi.ingsw.GC_04.model.effect;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.resource.Resource;

public class ExchangeResourcesEffect extends ResourceEffect {
	private List<Resource> cost;
	
	@JsonCreator
	public ExchangeResourcesEffect(@JsonProperty("effect") List<Resource> effect,@JsonProperty("cost") List<Resource> cost) {
		this.effect = effect;
		this.cost = cost; 
		this.requestedAuthorization = true;
	}

	@Override
	public void apply(Player player) {
		if(isApplicable(player)) {
			Resource.subtractResource(player.getResources(),cost);
			super.apply(player);
		}
	}
	
	public boolean isApplicable(Player player) {
		List<Resource> myRes = player.getResources(); //player's resources
		
		return Resource.isAffordable(myRes, cost);
		
	}
}
