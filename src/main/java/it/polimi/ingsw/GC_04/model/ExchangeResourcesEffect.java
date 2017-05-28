package it.polimi.ingsw.GC_04.model;

import java.util.ArrayList;

//aggiungere l'OR
public class ExchangeResourcesEffect extends ResourceEffect {
	private ArrayList<Resource> cost;
	private boolean affordable = true;
	
	

	public ExchangeResourcesEffect(ArrayList<Resource> effect, ArrayList<Resource> cost) {
		this.effect = effect;
		this.cost = cost;
	}

	@Override
	public void apply(Player player) {
		if(isApplicable(player)) {
			player.modifyResource(cost);
			super.apply(player);
		}
	}
	
	public boolean isApplicable(Player player) {
		ArrayList<Resource> myRes = player.getResources(); //player's resources
		
		cost.forEach((c)->  //for all resource type in cost
			{myRes.forEach(mR -> {if(c.getClass().equals(mR.getClass()) && //it scrolls through all types of player's resources and if the type coincides
				mR.getQuantity() < c.getQuantity()) affordable = false;});});
		//it checks that the player's quantity of that resource is enough to buy the card. if it's not, set affordable = false.

		return affordable;
		
	}
}
