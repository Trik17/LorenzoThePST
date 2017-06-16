package it.polimi.ingsw.GC_04.model.effect;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;

import it.polimi.ingsw.GC_04.model.resource.Resource;

public class CouncilPrivilege extends ResourceEffect {
	
	@JsonCreator
	public CouncilPrivilege(){
		this.effect = new ArrayList<Resource>();
	}
	
	public void setCouncilPrivilege(List<Resource> resources) {
		effect.add((Resource) resources);
		
	}
	

} 
