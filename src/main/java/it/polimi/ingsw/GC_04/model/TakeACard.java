package it.polimi.ingsw.GC_04.model;

import java.awt.List;
import java.util.ArrayList;

//non è più abstract
//eliminata isColorAvailable() ELIMINATA DI NUOVO
public class TakeACard extends Action{

	protected DevelopmentCard card;
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
				
	public TakeACard(Player player, DevelopmentCard card, ActionSpace aSpace, FamilyMember fMember,int servants){
		super(player, fMember, servants);
		this.value = fMember.getDice().getValue() + player.getExtraDice().getExtra(card) + servants; 
		this.card = card;
		if(card instanceof TerritoryCard) this.area = Tower.territoryTower();
		if(card instanceof BuildingCard) this.area = Tower.buildingTower();
		if(card instanceof VentureCard) this.area = Tower.ventureTower();
		if(card instanceof CharacterCard) this.area = Tower.characterTower();
		
	}
	
	public boolean isPBoardNotFull(){
		final int maxSize = 6;
		int size = player.getCards(card).size();
	
		if(size < maxSize) return true;
		return false;
		
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
		applyActionSpaceEffect();
	
	}
}	

	
