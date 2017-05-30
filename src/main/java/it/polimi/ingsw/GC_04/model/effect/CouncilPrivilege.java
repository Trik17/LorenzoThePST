package it.polimi.ingsw.GC_04.model.effect;

import java.util.ArrayList;
import java.util.List;

import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.resource.Resource;

public class CouncilPrivilege extends ResourceEffect {
	
	
	public CouncilPrivilege(){
		this.effect = new ArrayList<Resource>();
	}
	
	public void setCouncilPrivilege(List<Resource> resources) {
		effect.add((Resource) resources);
		
	}
	
	@Override
	public void apply(Player player){
	}	
} 
