package it.polimi.ingsw.GC_04.server.model.action;

import it.polimi.ingsw.GC_04.server.model.FamilyMember;
import it.polimi.ingsw.GC_04.server.model.Model;
import it.polimi.ingsw.GC_04.server.model.Player;
import it.polimi.ingsw.GC_04.server.model.area.CouncilPalaceArea;

public class GoToTheCouncilPalace extends Action{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3757433623773347938L;

	public GoToTheCouncilPalace(Model model, Player player, FamilyMember fMember, int servants) {
		super(model, player, fMember, servants);
		this.area = model.getCouncilPalace();
		aSpace = area.getASpaces().get(area.getASpaces().size() -1);
	}
		
	
	@Override
	public boolean isApplicable() {
		return isValueEnough();
	}

	public void createNewASpace() {
		area.getASpaces().add(((CouncilPalaceArea) area).getActionSpaceDefault());
	}
	
	@Override
	public void apply() {
		applyPlayerChanges();
		applyEffects();
		createNewASpace();
		checkLeaderCards();
	}

}
