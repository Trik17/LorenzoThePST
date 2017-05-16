package it.polimi.ingsw.GC_04;

import java.util.Map;


public class TakeTerritory extends TakeACard{
	
	public TakeTerritory(Player player, DevelopementCard card, ActionSpace aSpace, FamilyMember fMember,int servants) {
		super(player, card, aSpace, fMember, servants);
		this.value = fMember.getDice().getValue() + servants + player.getExtraDice().getExtraTerritory();
		this.cT = CardType.TERRITORY;
	}

	
	
	public boolean checkRequestedMilitaryPoints(){
		if(player.getCards(CardType.TERRITORY).size() < 2) return true; //se ho meno di due carte va bene sempre
		
		int requestedMP;
		int nrOfCards = player.getCards(CardType.TERRITORY).size();
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
	
	
	@Override	
	public boolean isApplicable(){
		
		return isPBoardNotFull() &&
				isValueEnough() && 
				checkRequestedMilitaryPoints() && 
				isColorAvailable(player.game.TerritoryTower, fMember.getFamilyColor()) &&
				aSpace.isAvailable();
				
		
		
	
	


}



