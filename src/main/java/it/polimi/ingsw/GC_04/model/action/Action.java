package it.polimi.ingsw.GC_04.model.action;

import java.util.ArrayList;
import java.util.List;

import org.omg.PortableServer.Servant;

import it.polimi.ingsw.GC_04.model.ActionSpace;
import it.polimi.ingsw.GC_04.model.FamilyMember;
import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.area.Area;
import it.polimi.ingsw.GC_04.model.area.ColorReastrictedArea;
import it.polimi.ingsw.GC_04.model.effect.Effect;
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

	public Action(Player player, FamilyMember fMember, int servants) {
		this.player = player;
		this.fMember = fMember;
		this.value = fMember.getDice().getValue() + servants;
		this.actionCost = new ArrayList<Resource>();
		this.actionCost.add(new Servants(servants));
		this.requestedAuthorizationEffects = new ArrayList<Effect>();

	}

	public abstract boolean isApplicable();

	public abstract void apply();

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

}
