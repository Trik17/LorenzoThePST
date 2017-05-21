package it.polimi.ingsw.GC_04.model;

import java.awt.List;
import java.util.ArrayList;


public abstract class TakeACard extends Action{

	protected DevelopementCard card;
	protected boolean affordable = true;
	
	
	public boolean isAffordable(){
		ArrayList<Resource> cost = card.getCost(); //card's cost
		ArrayList<Resource> myRes = player.getResources(); //player's resources
		
		cost.forEach((c)->  //for all resource type in cost
		{myRes.forEach(mR -> {if(c.getClass().equals(mR.getClass()) && //it scrolls through all types of player's resources and if the type coincides
		mR.getQuantity() < c.getQuantity()) affordable = false;});});
		//it checks that the player's quantity of that resource is enough to buy the card. if it's not, set affordable = false.

return affordable;
	
		
	}
				
	public TakeACard(Player player, DevelopementCard card, ActionSpace aSpace, FamilyMember fMember,int servants){
		this.player = player;
		this.card = card;
		this.aSpace = aSpace;
		this.fMember = fMember;
		
	}
	
	public boolean isPBoardNotFull(){
		final int maxSize = 6;
		int size = player.getCards(card).size();
	
		if(size < maxSize) return true;
		return false;
		
	}

	public boolean isColorAvailable(Tower tower,FamilyMember fMember){
		return tower.isColorAvailable(fMember.getFamilyColor());
		
	}
	
	public boolean isApplicable(){
		
		return isPBoardNotFull() &&
				isValueEnough() && 
				isAffordable() && 
				isColorAvailable(player.game.TerritoryTower, fMember.getFamilyColor()) &&
				aSpace.isAvailable();
	}
}	

	
