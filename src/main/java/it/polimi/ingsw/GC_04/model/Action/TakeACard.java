package it.polimi.ingsw.GC_04.model.Action;

import java.util.ArrayList;
import java.util.List;

import it.polimi.ingsw.GC_04.model.ActionSpace;
import it.polimi.ingsw.GC_04.model.FamilyMember;
import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.Card.DevelopmentCard;
import it.polimi.ingsw.GC_04.model.Resource.Coins;
import it.polimi.ingsw.GC_04.model.Resource.Resource;

//non è più abstract
//eliminata isColorAvailable() ELIMINATA DI NUOVO
public class TakeACard extends Action{

	protected DevelopmentCard card;
	protected boolean affordable = true;
	protected static final int TOWERPENALITY = 3;
	
	
	public TakeACard(Player player, DevelopmentCard card, ActionSpace aSpace, FamilyMember fMember,int servants){
		super(player, fMember, servants);
		this.aSpace = aSpace;
		this.value = fMember.getDice().getValue() + player.getExtraDice().getExtra(card) + servants; 
		this.card = card;
		this.area = card.getTower();
	}
	
	
	public boolean isAffordable(){
		List<Resource> cost = card.getCost(); //card's cost
		List<Resource> myRes = player.getResources(); //player's resources
		
		for(ActionSpace aSpace:area.getASpaces()) {//if the tower is occupied it adds three coins to the card's cost
			if(aSpace.getPresentColor() != null) {
				List<Resource> penality = new ArrayList<Resource>();
				penality.add(new Coins(TOWERPENALITY));
				Resource.modifyResource(cost, penality);
				
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
		List<Resource> cost = card.getCost();
		
		cost.forEach(res -> {//it turns into negative numbers the quantities of the resources present in the card's cost
			int newQuantity = -2*res.getQuantity();
			res.addQuantity(newQuantity);});
		
		Resource.modifyResource(player.getResources(),cost);
		
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

	
