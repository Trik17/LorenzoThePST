package it.polimi.ingsw.GC_04.model;

import java.util.ArrayList;

public class ResourcePerResourceEffect extends ResourceEffect {
	private Resource playerResource;//player's resource type that must be counted
	private Resource bonusResource;
	

	public ResourcePerResourceEffect() {
		effect = new ArrayList<Resource>();
	}
	
	
	@Override
	public void apply(Player player) {
		
		int bonus = bonusResource.getQuantity();
		int myQuantity = 0;
		
		ArrayList<Resource> myResources = player.getResources();
		Class<? extends Resource> resourceType = playerResource.getClass();
		
		for(Resource res:myResources) {
			if (resourceType.equals(res.getClass())){ 
				myQuantity = res.getQuantity();
				break;
			}
		}
		
		bonus *= myQuantity;
		this.effect.add(bonusResource);
		
		super.apply(player);
	}
	
	
}
