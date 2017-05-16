package it.polimi.ingsw.GC_04.model;

import java.util.HashMap;

public class ResourceEffect extends Effect {
	private HashMap<ResourceType,Resource> effect; //non abbiamo fatto la new
	
	public ResourceEffect(){
		//da file
	}
	
	@Override
	public void apply(Player player){
		player.modifyResource(effect);
	}


	
		
}
