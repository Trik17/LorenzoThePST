package it.polimi.ingsw.GC_04.model.action;

import java.util.ArrayList;
import java.util.List;

import it.polimi.ingsw.GC_04.model.ActionSpace;
import it.polimi.ingsw.GC_04.model.FamilyMember;
import it.polimi.ingsw.GC_04.model.Model;
import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.area.Tower;
import it.polimi.ingsw.GC_04.model.card.DevelopmentCard;
import it.polimi.ingsw.GC_04.model.effect.CouncilPrivilege;
import it.polimi.ingsw.GC_04.model.effect.Effect;
import it.polimi.ingsw.GC_04.model.resource.Coins;
import it.polimi.ingsw.GC_04.model.resource.Resource;

public class TakeACard extends Action{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6026167798041850327L;


	protected DevelopmentCard card;
	
	
	protected static final int TOWERPENALITY = 3;
	
	
	public TakeACard(Model model, Player player, DevelopmentCard card, ActionSpace aSpace, FamilyMember fMember,int servants, List<Resource> cost){
		super(model, player, fMember, servants);
		this.aSpace = aSpace;
		this.card = card;
		this.area = card.getTower(model);
		this.value = fMember.getDice().getValue() + player.getExtraDice().getCardExtra(card) + servants; 
		if (cost != null)
			this.actionCost.addAll(cost);
	}
	
	
	
	public boolean isAffordable(){
		
		List<Resource> myRes = player.getResources(); //player's resources
		List<Resource> myDiscount = player.getDiscount().getDiscount(card);
		
		Resource.subtractResource(actionCost, myDiscount);
		
		for(ActionSpace aSpace:area.getASpaces()) {//if the tower is occupied it adds three coins to the card's cost
			if(aSpace.getPresentColor() != null) {
				List<Resource> penality = new ArrayList<>();
				penality.add(new Coins(TOWERPENALITY));
				Resource.addResource(actionCost, penality);
				
			}
		}
		
		return Resource.isAffordable(myRes, actionCost);
	
		}
	
	
	public boolean isPBoardNotFull(){
		final int maxSize = 6;
		int size = player.getCards(card).size();
	
		if(size < maxSize) 
			return true;
		return false;
		
	}
	
	public void applyCardChanges(){
		
		player.getCards(card).add(card);
		((Tower) area).deleteCard(model,card);
		
	}
	@Override
	public void applyEffects() {
		if(!player.getActionSpacePenality())
			aSpace.applyEffects(player);
		councilPrivileges.forEach(cp -> cp.apply(player));
		requestedAuthorizationEffects.forEach(rae -> rae.apply(player));
		
		if (card.getEffects() != null) {
			for(Effect eff : card.getEffects()){
				if (!eff.isAuthorizationRequested() && !eff.getClass().equals(CouncilPrivilege.class))
					eff.apply(player);
			}
		}
	}
	

	@Override
	public void checkExtraordinaryEffect(){
		super.checkExtraordinaryEffect();
		
		List<Effect> effects=card.getEffects();
		if (effects != null)
			for(Effect eff: effects) {
				if (eff.getClass().equals(CouncilPrivilege.class))
					councilPrivileges.add((CouncilPrivilege) eff);
				if (eff.isAuthorizationRequested())
					requestedAuthorizationEffects.add(eff);
				}
		
	
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

}	

	
