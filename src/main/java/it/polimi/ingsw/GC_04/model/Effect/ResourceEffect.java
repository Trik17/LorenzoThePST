package it.polimi.ingsw.GC_04.model.Effect;

import java.util.ArrayList;

import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.Resource.Resource;

public class ResourceEffect extends Effect {
	protected ArrayList<Resource> effect;
	
	public ResourceEffect(){
		//da file e dovrà prendere la carta in ingresso?
	}
	
	@Override
	public void apply(Player player){
		player.modifyResource(effect);
	}

	
	
		
}
