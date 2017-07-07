package it.polimi.ingsw.GC_04.server.model.effect;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonCreator;

import it.polimi.ingsw.GC_04.server.model.resource.RawMaterial;
import it.polimi.ingsw.GC_04.server.model.resource.Resource;
import it.polimi.ingsw.GC_04.server.model.resource.Stones;
import it.polimi.ingsw.GC_04.server.model.resource.Woods;

public class CouncilPrivilege extends ResourceEffect {
	
	private static final long serialVersionUID = 4648246690795498386L;

	@JsonCreator
	public CouncilPrivilege(){
		this.effect = new ArrayList<Resource>();
	}
	
	public void setCouncilPrivilege(Resource resources) {
		if (resources instanceof RawMaterial) {
			effect.add(new Stones(resources.getQuantity()));
			effect.add(new Woods(resources.getQuantity()));
		}else
			effect.add(resources);
		
	}


} 
