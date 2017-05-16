package it.polimi.ingsw.GC_04.controller;

import java.util.HashMap;
import java.util.Map;

import it.polimi.ingsw.GC_04.model.ActionSpace;
import it.polimi.ingsw.GC_04.model.CardType;
import it.polimi.ingsw.GC_04.model.DevelopementCard;
import it.polimi.ingsw.GC_04.model.FamilyMember;
import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.Resource;
import it.polimi.ingsw.GC_04.model.ResourceType;
import it.polimi.ingsw.GC_04.model.Tower;

public abstract class TakeACard extends Action{
	
	//ora questa classe è astratta ed estende Action, aggiunto l'attributo card, metodo isColorAvailable
	

	private DevelopementCard card;
	protected CardType cT;
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
		int size = 0;

		switch(cT){
		case TERRITORY: size = player.getCards(CardType.TERRITORY).size();
			break;
		case BUILDING: size = player.getCards(CardType.BUILDING).size();
			break;
		case VENTURE: size = player.getCards(CardType.VENTURE).size();
			break;
		case CHARACTER: size = player.getCards(CardType.CHARACTER).size();
			break;
		}
		
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

	
