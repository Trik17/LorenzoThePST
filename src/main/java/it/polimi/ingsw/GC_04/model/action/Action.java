package it.polimi.ingsw.GC_04.model.action;

import it.polimi.ingsw.GC_04.model.ActionSpace;
import it.polimi.ingsw.GC_04.model.FamilyMember;
import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.area.Area;
import it.polimi.ingsw.GC_04.model.area.ColorReastrictedArea;

public abstract class Action {

	protected Player player;
	protected ActionSpace aSpace;
	protected FamilyMember fMember;
	protected int value; // TODO: calcolarlo nel costruttore//value of the dice
							// with which the action is performed plus servants
							// and any permanent effects
	protected Area area;

	public Action(Player player, FamilyMember fMember, int servants) {
		this.player = player;
		this.fMember = fMember;
		this.value = fMember.getDice().getValue() + servants;

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

	public void applyActionSpaceChanges() {
		aSpace.getEffect().apply(player);
		aSpace.setFamilyMember(fMember);
	}

}
