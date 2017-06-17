package it.polimi.ingsw.GC_04.model.action;

import java.util.ArrayList;
import java.util.List;

import it.polimi.ingsw.GC_04.model.ActionSpace;
import it.polimi.ingsw.GC_04.model.FamilyMember;
import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.area.Tower;
import it.polimi.ingsw.GC_04.model.card.DevelopmentCard;
import it.polimi.ingsw.GC_04.model.effect.CouncilPrivilege;
import it.polimi.ingsw.GC_04.model.effect.Effect;
import it.polimi.ingsw.GC_04.model.effect.EndVictoryPointsEffect;
import it.polimi.ingsw.GC_04.model.resource.Coins;
import it.polimi.ingsw.GC_04.model.resource.RawMaterial;
import it.polimi.ingsw.GC_04.model.resource.Resource;

public class TakeACard extends Action{

	protected DevelopmentCard card;
	protected List<Resource> discount;
	
	protected static final int TOWERPENALITY = 3;
	
	
	public TakeACard(Player player, DevelopmentCard card, ActionSpace aSpace, FamilyMember fMember,int servants, List<Resource> cost){
		super(player, fMember, servants);
		this.aSpace = aSpace;
		this.card = card;
		this.area = card.getTower();
		this.value = fMember.getDice().getValue() + player.getExtraDice().getCardExtra(card) + servants; 
		this.actionCost.addAll(cost);
	}
	
	public void chooseDiscount() {
		//TODO: mi serve il controller
		if (!player.getDiscount().getDiscount(card).stream().anyMatch(res -> res.getClass().equals(RawMaterial.class)))
			this.discount = player.getDiscount().getDiscount(card);
	}
	
	public boolean isAffordable(){
		chooseDiscount();
		
		List<Resource> myRes = player.getResources(); //player's resources
		List<Resource> myDiscount = player.getDiscount().getDiscount(card);
		
		Resource.subtractResource(actionCost, myDiscount);
		
		for(ActionSpace aSpace:area.getASpaces()) {//if the tower is occupied it adds three coins to the card's cost
			if(aSpace.getPresentColor() != null) {
				List<Resource> penality = new ArrayList<Resource>();
				penality.add(new Coins(TOWERPENALITY));
				Resource.addResource(actionCost, penality);
				
			}
		}
		
		return Resource.isAffordable(myRes, actionCost);
	
		}
	
	
	public boolean isPBoardNotFull(){
		final int maxSize = 6;
		int size = player.getCards(card).size();
	
		if(size < maxSize) return true;
		return false;
		
	}
	
	public void applyCardChanges(){
		
		player.getCards(card).add(card);
		((Tower) area).deleteCard(card);
		
	}
	
	public void applyEffects() {
		aSpace.applyEffects(player);
		
		for(Effect eff : card.getEffects()){
			if (!eff.getRequestedAuthorization())
				eff.apply(player);
			else
				requestedAuthorizationEffects.add(eff);
		}
		
				
		//TODO: fai chiedere al controller cosa attivare
	}
	
	
	@Override
	public boolean isApplicable(){
		
		return isPBoardNotFull() &&
				isValueEnough() && 
				isAffordable() && 
				isColorAvailable() &&
				isAvailable();
	}

	@Override
	public void apply() {
		applyCardChanges();
		applyPlayerChanges();
		applyEffects();
	
	}

	public DevelopmentCard getCard() {
		return this.card;
	}

	public boolean isCouncilPrivilegePresent(){
		List<Effect> effects=card.getEffects();
		for(Effect eff: effects) {
			if (eff.getClass().equals(CouncilPrivilege.class))
				return true;
			}
		return false;			
	}
}	

	
