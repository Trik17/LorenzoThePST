package it.polimi.ingsw.GC_04.model.action;

import java.util.ArrayList;
import java.util.List;

import it.polimi.ingsw.GC_04.model.ActionSpace;
import it.polimi.ingsw.GC_04.model.FamilyMember;
import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.card.DevelopmentCard;
import it.polimi.ingsw.GC_04.model.resource.Coins;
import it.polimi.ingsw.GC_04.model.resource.Resource;

//non è più abstract
//eliminata isColorAvailable() ELIMINATA DI NUOVO
public class TakeACard extends Action{

	protected DevelopmentCard card;
	protected List<Resource> cost;
	protected boolean affordable = true;
	protected static final int TOWERPENALITY = 3;
	
	
	public TakeACard(Player player, DevelopmentCard card, ActionSpace aSpace, FamilyMember fMember,int servants,List<Resource> cost){
		super(player, fMember, servants);
		this.aSpace = aSpace;
		this.card = card;
		this.cost = cost;
		this.area = card.getTower();
		this.value = fMember.getDice().getValue() + player.getExtraDice().getExtra(card) + servants; 
	}
	
	
	public boolean isAffordable(){
		
		List<Resource> myRes = player.getResources(); //player's resources
		
		for(ActionSpace aSpace:area.getASpaces()) {//if the tower is occupied it adds three coins to the card's cost
			if(aSpace.getPresentColor() != null) {
				List<Resource> penality = new ArrayList<Resource>();
				penality.add(new Coins(TOWERPENALITY));
				Resource.addResource(cost, penality);
				
			}
		}
		
		cost.forEach((c)->  //for all resource type in cost
			myRes.forEach(mR -> {if(c.getClass().equals(mR.getClass()) && //it scrolls through all types of player's resources and if the type coincides
			mR.getQuantity() < c.getQuantity()) affordable = false;}));
		//it checks that the player's quantity of that resource is enough to buy the card. if it's not, set affordable = false.

		return affordable;
	
		}
	
	
	public boolean isPBoardNotFull(){
		final int maxSize = 6;
		int size = player.getCards(card).size();
	
		if(size < maxSize) return true;
		return false;
		
	}
	
	public void applyCost() {
		
		Resource.subtractResource(player.getResources(),cost);
		
	}
	
	

	
	
	@Override
	public boolean isApplicable(){
		
		return isPBoardNotFull() &&
				isValueEnough() && 
				isAffordable() && 
				isColorAvailable() &&
				isPlaceAvailable();
	}

	@Override
	public void apply() {
		applyCost();
		applyActionSpaceEffect();
	
	}
}	

	
