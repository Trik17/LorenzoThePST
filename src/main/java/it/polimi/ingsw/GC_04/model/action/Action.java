package it.polimi.ingsw.GC_04.model.action;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import it.polimi.ingsw.GC_04.model.ActionSpace;
import it.polimi.ingsw.GC_04.model.FamilyMember;
import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.area.Area;
import it.polimi.ingsw.GC_04.model.area.ColorReastrictedArea;
import it.polimi.ingsw.GC_04.model.effect.CouncilPrivilege;
import it.polimi.ingsw.GC_04.model.effect.Effect;
import it.polimi.ingsw.GC_04.model.resource.Resource;
import it.polimi.ingsw.GC_04.model.resource.Servants;

public abstract class Action implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4204746344145065227L;
	protected Player player;
	protected ActionSpace aSpace;
	protected FamilyMember fMember;
	protected int value; //value of the dice with which the action is performed plus servants
	protected List<Resource> actionCost;						// and any permanent effects
	protected Area area;
	protected List<Effect> requestedAuthorizationEffects;
	protected List<CouncilPrivilege> councilPrivileges;
	protected List<Resource> discount;
	
	public Action() {}
	
	public Action(Player player, FamilyMember fMember, int servants) {
		this.player = player;
		this.fMember = fMember;
		this.value = fMember.getDice().getValue() + servants;
		this.actionCost = new ArrayList<>();
		this.actionCost.add(new Servants(servants));
		this.requestedAuthorizationEffects = new ArrayList<>();
		this.councilPrivileges = new ArrayList<>();

	}

	public abstract boolean isApplicable();

	public abstract void apply();
	
	public void checkExtraordinaryEffect() {
		List<Effect> effects = aSpace.getEffect();
		if (effects != null) {
			for(Effect eff: effects) {
				if (eff.getClass().equals(CouncilPrivilege.class))
					councilPrivileges.add((CouncilPrivilege) eff);	
				if (eff.isAuthorizationRequested())
					requestedAuthorizationEffects.add(eff);
			}
		}
	}
	
	
	
	public void setRequestedAuthorizationEffects(List<Effect> effects) {
		requestedAuthorizationEffects = effects;	
		
	}
	public void setCouncilPrivilege(List<CouncilPrivilege> cp) {
		councilPrivileges = cp;
		
	}

	public boolean isValueEnough() {
		
		if (value < aSpace.getActivationCost())
			return false;
		return true;
	}

	public boolean isColorAvailable() {
		if (area instanceof ColorReastrictedArea)
			return ((ColorReastrictedArea) area).isColorAvailable(fMember.getFamilyColor());
		return true;

	}

	public boolean isAvailable() {
		return 	aSpace.isAvailable() &&
				!fMember.isUsed();

	}

	public void applyPlayerChanges() {
		aSpace.setFamilyMember(fMember);
		fMember.switchUsed();
		List<Resource> playerRes = player.getResources();
		Resource.subtractResource(playerRes, actionCost);
		
		
	}
	public void applyEffects() {
		aSpace.applyEffects(player);
		councilPrivileges.forEach(cp -> cp.apply(player));
		requestedAuthorizationEffects.forEach(rae -> rae.apply(player));
	}
	
	public List<Effect> getRequestedAuthorizationEffects() {
		return requestedAuthorizationEffects;
		
	}
	
	public List<CouncilPrivilege> getCouncilPrivileges() {
		return councilPrivileges;
		
	}
	public Player getPlayer() {
		return player;
	}
	public void setDiscount(List<Resource> discount) {
		this.discount = discount;
		
	}
}
