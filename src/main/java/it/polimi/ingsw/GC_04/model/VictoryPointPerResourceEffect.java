package it.polimi.ingsw.GC_04.model;

import java.util.ArrayList;

import com.sun.jndi.url.iiopname.iiopnameURLContextFactory;

public class VictoryPointPerResourceEffect extends ResourceEffect {
	private Resource resource;
	private int bonusVPoints;
	

	public VictoryPointPerResourceEffect() {
		effect = new ArrayList<Resource>();
	}
	
	
	@Override
	public void apply(Player player) {
		
		int addedVPoints;
		int myQuantity = 0;
		
		ArrayList<Resource> myResources = player.getResources();
		Class<? extends Resource> resourceType = resource.getClass();
		
		for(Resource res:myResources) {
			if (resourceType.equals(res.getClass())){ 
				myQuantity = res.getQuantity();
				break;
			}
		}
		
		addedVPoints = myQuantity*bonusVPoints;
		this.effect.add(new VictoryPoints(addedVPoints));
		
		super.apply(player);
	}
	
	
}
