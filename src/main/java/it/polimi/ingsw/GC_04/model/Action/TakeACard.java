package it.polimi.ingsw.GC_04.model.Action;

import java.awt.List;
import java.util.ArrayList;

import com.sun.org.apache.regexp.internal.recompile;

import it.polimi.ingsw.GC_04.model.ActionSpace;
import it.polimi.ingsw.GC_04.model.FamilyMember;
import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.Area.Tower;
import it.polimi.ingsw.GC_04.model.Card.BuildingCard;
import it.polimi.ingsw.GC_04.model.Card.CharacterCard;
import it.polimi.ingsw.GC_04.model.Card.DevelopmentCard;
import it.polimi.ingsw.GC_04.model.Card.TerritoryCard;
import it.polimi.ingsw.GC_04.model.Card.VentureCard;
import it.polimi.ingsw.GC_04.model.Resource.Coins;
import it.polimi.ingsw.GC_04.model.Resource.Resource;

//non è più abstract
//eliminata isColorAvailable() ELIMINATA DI NUOVO
public class TakeACard extends Action{

	protected DevelopmentCard card;
	protected boolean affordable = true;
	protected static final int towerPenality = 3;
	
	
	public boolean isAffordable(){
		ArrayList<Resource> cost = card.getCost(); //card's cost
		ArrayList<Resource> myRes = player.getResources(); //player's resources
		
		for(ActionSpace aSpace:area.getASpace()) {//if the tower is occupied it adds three coins to the card's cost
			if(aSpace.getPresentColor() != null) {
				for(Resource res:cost) {
					if (res instanceof Coins) res.modifyQuantity(towerPenality);
				}
			}
		}
		
		cost.forEach((c)->  //for all resource type in cost
		{myRes.forEach(mR -> {if(c.getClass().equals(mR.getClass()) && //it scrolls through all types of player's resources and if the type coincides
		mR.getQuantity() < c.getQuantity()) affordable = false;});});
		//it checks that the player's quantity of that resource is enough to buy the card. if it's not, set affordable = false.

		return affordable;
	
		}
				
	public TakeACard(Player player, DevelopmentCard card, ActionSpace aSpace, FamilyMember fMember,int servants){
		super(player, fMember, servants);
		this.value = fMember.getDice().getValue() + player.getExtraDice().getExtra(card) + servants; 
		this.card = card;
		this.area = Tower.getTower(card);
	}
	
	public boolean isPBoardNotFull(){
		final int maxSize = 6;
		int size = player.getCards(card).size();
	
		if(size < maxSize) return true;
		return false;
		
	}
	
	public void applyCost() {
		ArrayList<Resource> cost = card.getCost();
		
		cost.forEach(res -> {//it turns into negative numbers the quantities of the resources present in the card's cost
			int newQuantity = -2*res.getQuantity();
			res.modifyQuantity(newQuantity);});
		
		player.modifyResource(cost);
		
	}
	
	

	
	
	
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

	
