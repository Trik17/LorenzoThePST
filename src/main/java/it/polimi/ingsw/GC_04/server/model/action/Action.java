package it.polimi.ingsw.GC_04.server.model.action;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import it.polimi.ingsw.GC_04.server.controller.SupportFunctions;
import it.polimi.ingsw.GC_04.server.model.ActionSpace;
import it.polimi.ingsw.GC_04.server.model.FamilyMember;
import it.polimi.ingsw.GC_04.server.model.Model;
import it.polimi.ingsw.GC_04.server.model.Player;
import it.polimi.ingsw.GC_04.server.model.area.Area;
import it.polimi.ingsw.GC_04.server.model.area.ColorReastrictedArea;
import it.polimi.ingsw.GC_04.server.model.card.LeaderCard;
import it.polimi.ingsw.GC_04.server.model.effect.CouncilPrivilege;
import it.polimi.ingsw.GC_04.server.model.effect.Effect;
import it.polimi.ingsw.GC_04.server.model.resource.Resource;
import it.polimi.ingsw.GC_04.server.model.resource.Servants;

public abstract class Action implements Serializable{

	private static final long serialVersionUID = 4204746344145065227L;
	protected Model model;
	protected Player player;
	protected ActionSpace aSpace;
	protected FamilyMember fMember;
	protected int value; //value of the dice with which the action is performed plus servants
	protected List<Resource> actionCost;						// and any permanent effects
	protected Area area;
	protected List<Effect> requestedAuthorizationEffects;
	protected List<CouncilPrivilege> councilPrivileges;
	protected List<Resource> discount;
	protected int servants;
	
	public Action() {}
	
	public Action(Model model, Player player, FamilyMember fMember, int servants) {
		this.model = model;
		this.player = player;
		this.fMember = fMember;
		this.servants = servants;
		this.value = fMember.getDice().getValue() + servants;
		this.actionCost = new ArrayList<>();
		this.actionCost.add(new Servants(servants));
		this.requestedAuthorizationEffects = new ArrayList<>();
		this.councilPrivileges = new ArrayList<>();

	}

	public abstract boolean isApplicable();

	public abstract void apply();
	
	public void checkExtraordinaryEffect() {
		List<Effect> effects;
		if (model.getCurrentRow() == 1) {
			effects = player.getBonusAction();
			
			//it put in councilPrivileges all the council privilege in effects and in requestedAuthorizationEffects all the effects that have AuthorizationRequested=true 
			SupportFunctions.addExtraordinaryEffects(councilPrivileges, requestedAuthorizationEffects, effects);
		}
		
		effects = aSpace.getEffect();
		if (effects != null) {
			SupportFunctions.addExtraordinaryEffects(councilPrivileges, requestedAuthorizationEffects, effects);
		}
	}
	
	
	
	public void setRequestedAuthorizationEffects(List<Effect> effects) {
		requestedAuthorizationEffects = effects;	
		
	}
	public void setCouncilPrivilege(List<CouncilPrivilege> cp) {
		councilPrivileges = cp;
		
	}

	public boolean isValueEnough() {
		if (player.getResource(new Servants()).getQuantity() < servants)
			return false;
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
		if (model.getCurrentRow() == 1)
			player.applyBonus();
		aSpace.applyEffects(player);
		councilPrivileges.forEach(cp -> cp.apply(player));
		requestedAuthorizationEffects.forEach(rae -> rae.apply(player));
	}
	public void checkLeaderCards() {
		/*it checks if the player has enough resource to activate his leader card
		if he has them, that leader card is activated and never checked anymore
		moreover, leader card effect is activated*/
		List<LeaderCard> leaderCards = player.getLeaderCards();
		for (int i = 0; i < leaderCards.size(); i++) {
			if (!leaderCards.get(i).isActivated()) {
				leaderCards.get(i).checkActivationLeaderCard(player);
				
				/*in case of BonusTurnResourcesEffect
				 * it activates the effect when the leader card is activated for the first time
				 * the other times it is activate at the beginning of every period of the age
				*/
				leaderCards.get(i).applyEffectFirstTime(player);
			}
		}
		
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
