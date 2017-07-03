package it.polimi.ingsw.GC_04.controller;

import java.util.ArrayList;
import java.util.List;

import it.polimi.ingsw.GC_04.model.effect.CouncilPrivilege;
import it.polimi.ingsw.GC_04.model.effect.Effect;
import it.polimi.ingsw.GC_04.model.effect.ExchangeResourcesEffect;
import it.polimi.ingsw.GC_04.model.effect.TakeACardEffect;

public class ClonedAction {
	
	private List<CouncilPrivilege> councilPrivileges;
	private List<Effect> requestedAuthorizationEffects;
	private int[] furtherCheckNeeded;
	private int[] requestedEffects;

	public ClonedAction() {
		this.councilPrivileges = new ArrayList<>(); 
		this.requestedAuthorizationEffects = new ArrayList<>();
		this.furtherCheckNeeded = new int[0];
		this.requestedEffects = new int[0];
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
	
	public int[] getFurtherCheckNeeded() {
		return furtherCheckNeeded;
	}

	
	public void setRequestedAuthorizationEffects(List<Effect> effects) {
		requestedAuthorizationEffects = organizeExchangeResourcesEffects(effects);
		furtherCheckNeeded = furtherCheckNeededIndices(requestedAuthorizationEffects);
		
	}
	public void setRequestedEffects(int[] requestedEffects) {
		this.requestedEffects = requestedEffects; 
		setPlayerChoices();
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
}
