package it.polimi.ingsw.GC_04.server.model.effect;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.polimi.ingsw.GC_04.server.model.Player;
import it.polimi.ingsw.GC_04.server.model.resource.Resource;

public class ExchangeResourcesEffect extends Effect {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6182861287949497378L;
	private List<ResourceEffect> effect1;
	private List<Resource> cost1;
	private List<ResourceEffect> effect2;
	private List<Resource> cost2;
	private List<ResourceEffect> effect;
	private List<Resource> chosenCost;
	
	@JsonCreator
	public ExchangeResourcesEffect(@JsonProperty("effect1") List<ResourceEffect> effect1,@JsonProperty("cost1") List<Resource> cost1,@JsonProperty("effect2") List<ResourceEffect> effect2,@JsonProperty("cost2") List<Resource> cost2) {
		this.effect1 = effect1;
		this.cost1 = cost1; 
		this.effect2 = effect2;
		this.cost2 = cost2; 
		this.requestedAuthorization = true;
	}

	public void setEffect(List<ResourceEffect> effect,List<Resource> chosenCost) {
		this.effect = effect;
		this.chosenCost = chosenCost;
		
	}
	@Override
	public void apply(Player player) {
		if(isApplicable(player)) {
			Resource.subtractResource(player.getResources(),chosenCost);
			for(Effect effect:effect) 
				effect.apply(player);
		}
	}
	
	public boolean isApplicable(Player player) {
		List<Resource> myRes = player.getResources(); //player's resources
		
		return Resource.isAffordable(myRes, chosenCost);
		
	}

	public List<ResourceEffect> getEffect1() {
		return effect1;
	}
	public List<Resource> getCost1() {
		return cost1;
	}
	public List<ResourceEffect> getEffect2() {
		return effect2;
	}
	public List<Resource> getCost2() {
		return cost2;
	}
	public List<ResourceEffect> getEffect() {
		return effect;		
	}
	public List<Resource> getChosenCost() {
		return chosenCost;		
	}


}
