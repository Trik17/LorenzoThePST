package it.polimi.ingsw.GC_04.model;

import java.util.ArrayList;

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
