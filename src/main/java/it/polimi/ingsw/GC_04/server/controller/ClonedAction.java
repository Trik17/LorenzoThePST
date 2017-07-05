package it.polimi.ingsw.GC_04.server.controller;

import java.util.ArrayList;
import java.util.List;

import it.polimi.ingsw.GC_04.server.model.Player;
import it.polimi.ingsw.GC_04.server.model.card.DevelopmentCard;
import it.polimi.ingsw.GC_04.server.model.effect.CouncilPrivilege;
import it.polimi.ingsw.GC_04.server.model.effect.Effect;
import it.polimi.ingsw.GC_04.server.model.effect.ExchangeResourcesEffect;
import it.polimi.ingsw.GC_04.server.model.effect.TakeACardEffect;
import it.polimi.ingsw.GC_04.server.model.resource.RawMaterial;
import it.polimi.ingsw.GC_04.server.model.resource.Resource;
import it.polimi.ingsw.GC_04.server.model.resource.Stones;
import it.polimi.ingsw.GC_04.server.model.resource.Woods;

public class ClonedAction {
	
	private List<CouncilPrivilege> councilPrivileges;
	private List<Effect> requestedAuthorizationEffects;
	private int[] furtherCheckNeeded;
	private int[] requestedEffects;
	private List<Resource> discount;
	private List<Resource> rawMaterials;

	public ClonedAction() {
		this.councilPrivileges = new ArrayList<>(); 
		this.requestedAuthorizationEffects = new ArrayList<>();
		this.furtherCheckNeeded = new int[0];
		this.requestedEffects = new int[0];
		this.discount = new ArrayList<>();
		this.rawMaterials = new ArrayList<>();
	}

	public List<CouncilPrivilege> getCouncilPrivileges() {
		return councilPrivileges;
	}
	public List<Effect> getRequestedAuthorizationEffects() {
		return requestedAuthorizationEffects;
	}

	public void setCouncilPrivileges(List<Effect> cP) {
		cP.forEach(privilege -> councilPrivileges.add((CouncilPrivilege) privilege));
	}
	
	public List<Resource> getRawMaterials() {
		return rawMaterials;
		
	}
	
	public int[] getFurtherCheckNeeded() {
		return furtherCheckNeeded;
	}

	public List<Resource> getDiscount() {
		return discount;
	}

	public void setDiscount(List<Resource> discount) {
		this.discount = discount;
	}
	
	public void setRequestedAuthorizationEffects(List<Effect> effects) {
		requestedAuthorizationEffects = organizeExchangeResourcesEffects(effects);
		furtherCheckNeeded = furtherCheckNeededIndices(requestedAuthorizationEffects);
		
	}
	public void setRequestedEffects(int[] requestedEffects) {
		this.requestedEffects = requestedEffects; 
		setPlayerChoices();
	}
	
	
	public List<Resource> setDiscount(Player player, DevelopmentCard card) {
		//this method uploads the action's discounts accumulated by the player 
		List<Resource> discounts;
		List<Resource> myDiscounts = SupportFunctions.cloneResources(player.getDiscount().getDiscount(card));
		if (myDiscounts.isEmpty())
			return new ArrayList<>();
		if (!myDiscounts.stream().anyMatch(res -> res.getClass().equals(RawMaterial.class)))
			discounts = myDiscounts;
		else {
			myDiscounts.forEach(res -> {if (res instanceof RawMaterial)
				rawMaterials.add(res);});
			discounts = myDiscounts;
		}
		return discounts;
			
			
	}
	
	
	public List<Effect> organizeExchangeResourcesEffects(List<Effect> requestedAuthorizationEffects) {
		//it finds ExchangeResourcesEffect that offer only one effect and sets it as chosen effect
		for (Effect eff:requestedAuthorizationEffects) {
			if (eff instanceof ExchangeResourcesEffect)
				if (((ExchangeResourcesEffect) eff).getCost2() == null) {
					((ExchangeResourcesEffect) eff).setEffect(((ExchangeResourcesEffect) eff).getEffect1(), ((ExchangeResourcesEffect) eff).getCost1());
				}
		}
		return requestedAuthorizationEffects;
		
	}
	
	
	private int[] furtherCheckNeededIndices(List<Effect> requestedAuthorizationEffects) {
		//it stores in an array the indices of the Resources that offer a choice
		int[] furtherCheckNeeded = new int[0];
		if (!requestedAuthorizationEffects.isEmpty()) {
			furtherCheckNeeded = new int[requestedAuthorizationEffects.size()-1];
			int cont = 0;
			for (int i = 0; i < requestedAuthorizationEffects.size(); i++) {
				if (requestedAuthorizationEffects.get(i) instanceof ExchangeResourcesEffect)
					if (!(((ExchangeResourcesEffect) requestedAuthorizationEffects.get(i)).getCost2() == null)) {
						furtherCheckNeeded[cont] = i;
						cont ++;
					}
			}
			for (int i = 0; i < requestedAuthorizationEffects.size(); i++) {
				if (requestedAuthorizationEffects.get(i) instanceof TakeACardEffect) {
					furtherCheckNeeded[cont] = i;
					cont ++;
					}
			}
			
		}
		return furtherCheckNeeded;
	}
	
	public void setPlayerChoices() {
		int[] incompleteChoices = new int[furtherCheckNeeded.length];
		int cont = 0;
		
		if (furtherCheckNeeded.length != 0 && requestedEffects.length != 0) {
			//it asks the player which choice he wants to make between those proposed
			for (int i:furtherCheckNeeded) {//indices of effects that offer a choice
				for (int j: requestedEffects) {//indices of effects chosen by the player
					if (i == j) {
						incompleteChoices[cont] = i;	
						cont++;
					}
				}
			}
		}
		
		furtherCheckNeeded = new int[cont];
		
		for (int i = 0; i < furtherCheckNeeded.length; i++) {
			furtherCheckNeeded[i] = incompleteChoices[i];
		}
		//now in furtherCheckNeeded there are only indices of the effects chosen by the player that offer a choice
	}

	public void setRawMaterialsDiscount(String input) {
		
		int[] choices = SupportFunctions.parseIntArray(input);
		
		for (int i = 0; i < choices.length; i++) {
			int quantity = rawMaterials.get(i).getQuantity();
			if (choices[i] == 1)
				rawMaterials.set(i, new Stones(quantity));
			else
				rawMaterials.set(i, new Woods(quantity));
		}
		
		discount.addAll(rawMaterials);
		
	}

	
}
