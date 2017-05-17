package it.polimi.ingsw.GC_04.model;

import java.awt.List;
import java.util.ArrayList;


public abstract class TakeACard extends Action{
	
	//ora questa classe è astratta ed estende Action, aggiunto l'attributo card, metodo isColorAvailable
	

	protected DevelopementCard card;
	protected boolean affordable = true;
	
	
	public boolean isAffordable(){
		ArrayList<Resource> cost = card.getCost();
		ArrayList<Resource> myRes = player.getResources();
		
		cost.forEach((c)-> 
		{myRes.forEach(mR -> {if(c.getClass().equals(mR.getClass()) && 
		mR.getQuantity() < c.getQuantity()) affordable = false;}));

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

	
