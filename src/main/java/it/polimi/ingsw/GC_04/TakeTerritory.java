package it.polimi.ingsw.GC_04;

import java.util.Map;

//prima estendeva Action, ora estende TakeACard

public class TakeTerritory extends TakeACard{
	
	
	//eliminato l'attributo tCard
	
	public TakeTerritory(Player player, DevelopementCard card, ActionSpace aSpace, FamilyMember fMember,int servants) {
		super(player, card, aSpace, fMember, servants);
		this.value = fMember.getDice().getValue() + servants + player.getExtraDice().getExtraTerritory();
	}

	
	
	public boolean checkRequestedMilitaryPoints(){
		if(player.getTCards().size() < 2) return true; //se ho meno di due carte va bene sempre
		
		int requestedMP;
		int nrOfCards = player.getTCards().size();
		int myMP = player.getResources().get(ResourceType.MILITARYP).getQuantity(); //numero di punti militari accumulati dal player
		
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
		
		return isValueEnough() && 
				checkRequestedMilitaryPoints() && 
				isColorAvailable(player.game.TerritoryTower, fMember.getFamilyColor()) &&
				aSpace.isAvailable();
		
		
		
	}
	
	


}
