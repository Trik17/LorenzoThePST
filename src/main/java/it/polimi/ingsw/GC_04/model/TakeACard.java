package it.polimi.ingsw.GC_04.model;

import java.util.HashMap;
import java.util.Map;

import it.polimi.ingsw.GC_04.model.CardType;

public abstract class TakeACard extends Action{
	
	//ora questa classe è astratta ed estende Action, aggiunto l'attributo card, metodo isColorAvailable
	

	protected DevelopementCard card;
	protected boolean affordable = true;
	
	
	public boolean isAffordable(){
		Map<ResourceType,Resource> cost = card.getCost();
		Map<ResourceType,Resource> myResources = player.getResources();
		
		cost.forEach((resType,res)-> {if(myResources.get(resType).getQuantity() < cost.get(resType).getQuantity()) affordable = false;} );
	
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

	
