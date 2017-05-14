package it.polimi.ingsw.GC_04;

import java.util.Map;

public class TakeTerritory extends Action{
	
	private TerritoryCard tCard;
	
	public TakeTerritory(Player player, TerritoryCard tCard){
		this.player = player;
		this.tCard = tCard;
	}
	
	public boolean checkRequestedMilitaryPoints(){
		if(player.getTCards().size() < 2) return true;
		
		int requestedMP;
		int nrOfCards = player.getTCards().size();
		int myMP = player.getResources().get(ResourceType.MILITARYP).getQuantity();
		
		switch(nrOfCards){
			case 2: requestedMP = 3;
				break;
			case 3: requestedMP = 7;
				break;
			case 4: requestedMP = 12;
				break;
			default: requestedMP = 18;
		}
		
		if (requestedMP > myMP) return false;
		
		return true;
	}
	
	public boolean isApplicable(){
		
		return checkDiceValue(null, null) && checkRequestedMilitaryPoints(null) && checkColorInTower(null);
		
		
		
	}
	
	


}
