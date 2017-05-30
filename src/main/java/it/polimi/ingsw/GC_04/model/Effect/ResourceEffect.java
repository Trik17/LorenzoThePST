package it.polimi.ingsw.GC_04.model.Effect;

import java.util.List;

import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.Resource.Resource;

public class ResourceEffect extends Effect {
	protected List<Resource> effect;

	@Override
	public void apply(Player player){
		Resource.addResource(effect,player.getResources());
	}

	
	
		
}