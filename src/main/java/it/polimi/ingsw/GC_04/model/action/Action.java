package it.polimi.ingsw.GC_04.model.action;

import java.util.ArrayList;
import java.util.List;

import org.omg.PortableServer.Servant;

import it.polimi.ingsw.GC_04.model.ActionSpace;
import it.polimi.ingsw.GC_04.model.FamilyMember;
import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.area.Area;
import it.polimi.ingsw.GC_04.model.area.ColorReastrictedArea;
import it.polimi.ingsw.GC_04.model.effect.ActionSpacePenalityEffect;
import it.polimi.ingsw.GC_04.model.effect.CouncilPrivilege;
import it.polimi.ingsw.GC_04.model.effect.Effect;
import it.polimi.ingsw.GC_04.model.resource.Coins;
import it.polimi.ingsw.GC_04.model.resource.Resource;
import it.polimi.ingsw.GC_04.model.resource.Servants;

public abstract class Action {

	protected Player player;
	protected ActionSpace aSpace;
	protected FamilyMember fMember;
	protected int value; //value of the dice with which the action is performed plus servants
	protected List<Resource> actionCost;						// and any permanent effects
	protected Area area;
	protected List<Effect> requestedAuthorizationEffects;
	protected List<CouncilPrivilege> councilPrivileges;

	public Action(Player player, FamilyMember fMember, int servants) {
		this.player = player;
		this.fMember = fMember;
		this.value = fMember.getDice().getValue() + servants;
		this.actionCost = new ArrayList<Resource>();
		this.actionCost.add(new Servants(servants));
		this.requestedAuthorizationEffects = new ArrayList<Effect>();
		this.councilPrivileges = new ArrayList<CouncilPrivilege>();

	}

	public abstract boolean isApplicable();

	public abstract void apply();
	
	public void checkExtraordinaryEffect() {
		List<Effect> effects = aSpace.getEffect();
		for(Effect eff: effects) {
			if (eff.getClass().equals(CouncilPrivilege.class))
				councilPrivileges.add((CouncilPrivilege) eff);	
			if (eff.getRequestedAuthorization())
				requestedAuthorizationEffects.add(eff);
		}
	}
	
	public void setCouncilPrivilege(Resource resource) {
		int cont = councilPrivileges.size() -1;
		councilPrivileges.get(cont).setCouncilPrivilege(resource);
		councilPrivileges.remove(cont);
		
	}
	
	public void setRequestedAuthorizationEffects(List<Effect> effects) {
		requestedAuthorizationEffects = effects;	
		
	}

	public boolean isValueEnough() {

		if (value >= aSpace.getActivationCost())
			return true;
		return false;
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
	public List<Effect> getRequestedAuthorizationEffects() {
		return requestedAuthorizationEffects;
		
	}
	
	public List<CouncilPrivilege> getCouncilPrivileges() {
		return councilPrivileges;
		
	}
	public Player getPlayer() {
		return player;
	}
}
