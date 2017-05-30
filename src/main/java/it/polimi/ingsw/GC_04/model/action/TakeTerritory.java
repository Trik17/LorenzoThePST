package it.polimi.ingsw.GC_04.model.action;

import java.util.List;

import it.polimi.ingsw.GC_04.model.ActionSpace;
import it.polimi.ingsw.GC_04.model.FamilyMember;
import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.card.DevelopmentCard;
import it.polimi.ingsw.GC_04.model.resource.MilitaryPoints;
import it.polimi.ingsw.GC_04.model.resource.Resource;

public class TakeTerritory extends TakeACard{
	
	int accumulatedMP;
	
	public TakeTerritory(Player player, DevelopmentCard card, ActionSpace aSpace, FamilyMember fMember,int servants,List<Resource> cost) {
		super(player, card, aSpace, fMember, servants, cost);
	}

	
	
	public boolean checkRequestedMilitaryPoints(){
		if(player.getCards(card).size() < 2) return true; //if player has less than two territory cards return true
		
		int requestedMP;
		int nrOfCards = player.getCards(card).size();
		List<Resource> myRes = player.getResources(); //player's Resources
		// scroll through player's resources and store in the variable accumulatedMP the quantity of military points accumulated by the player
		myRes.forEach(res -> {if(res.getClass() == MilitaryPoints.class) accumulatedMP = res.getQuantity();});
		
		switch(nrOfCards){
			case 2: requestedMP = 3;
				break;
			case 3: requestedMP = 7;
				break;
			case 4: requestedMP = 12;
				break;
			default: requestedMP = 18;
		}
		
		if (requestedMP > accumulatedMP) return false;
		
		return true;
	}
	
	
	@Override	
	public boolean isApplicable(){
		
		return isPBoardNotFull() &&
				isAffordable() &&
				isValueEnough() && 
				checkRequestedMilitaryPoints() && 
				isColorAvailable() &&
				aSpace.isAvailable();
				
	}
		
	
	


}



