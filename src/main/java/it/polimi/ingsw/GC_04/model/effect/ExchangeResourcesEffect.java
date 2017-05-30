package it.polimi.ingsw.GC_04.model.effect;

import java.util.List;

import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.resource.Resource;

//aggiungere l'OR
public class ExchangeResourcesEffect extends ResourceEffect {
	private List<Resource> cost;
	
	public ExchangeResourcesEffect(List<Resource> effect, List<Resource> cost) {
		this.effect = effect;
		this.cost = cost; 
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
