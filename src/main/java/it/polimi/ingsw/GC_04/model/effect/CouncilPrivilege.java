package it.polimi.ingsw.GC_04.model.effect;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;

import it.polimi.ingsw.GC_04.model.resource.RawMaterial;
import it.polimi.ingsw.GC_04.model.resource.Resource;
import it.polimi.ingsw.GC_04.model.resource.Stones;
import it.polimi.ingsw.GC_04.model.resource.Woods;

public class CouncilPrivilege extends ResourceEffect {
	
	@JsonCreator
	public CouncilPrivilege(){
		this.effect = new ArrayList<Resource>();
	}
	
	public void setCouncilPrivilege(Resource resources) {
		if (resources instanceof RawMaterial) {
			effect.add(new Stones(1));
			effect.add(new Woods(1));
		}else
			effect.add(resources);
		
	}
	

} 
