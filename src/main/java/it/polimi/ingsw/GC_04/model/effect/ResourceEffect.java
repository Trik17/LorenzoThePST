package it.polimi.ingsw.GC_04.model.effect;

import java.util.List;

import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.resource.Resource;

public class ResourceEffect extends Effect {
	protected List<Resource> effect;

	@Override
	public void apply(Player player){
		Resource.addResource(effect,player.getResources());
	}

	
	
		
}
