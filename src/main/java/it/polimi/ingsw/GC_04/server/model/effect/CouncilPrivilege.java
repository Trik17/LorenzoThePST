package it.polimi.ingsw.GC_04.server.model.effect;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonCreator;

import it.polimi.ingsw.GC_04.server.model.resource.RawMaterial;
import it.polimi.ingsw.GC_04.server.model.resource.Resource;
import it.polimi.ingsw.GC_04.server.model.resource.Stones;
import it.polimi.ingsw.GC_04.server.model.resource.Woods;

public class CouncilPrivilege extends ResourceEffect {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4648246690795498386L;

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
	/*public static CouncilPrivilege clone(CouncilPrivilege cp) {
		try {
			return (CouncilPrivilege) cp.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println(222222);
			return null;
		}
		
	}*/

} 
