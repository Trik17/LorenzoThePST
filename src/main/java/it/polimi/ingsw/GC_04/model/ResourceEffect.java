package it.polimi.ingsw.GC_04.model;

import java.util.ArrayList;
import java.util.HashMap;

public class ResourceEffect extends Effect {
	private ArrayList<Resource> effect;
	
	public ResourceEffect(){
		//da file e dovrà prendere la carta in ingresso?
	}
	
	@Override
	public void apply(Player player){
		player.modifyResource(effect);
	}


	
		
}
