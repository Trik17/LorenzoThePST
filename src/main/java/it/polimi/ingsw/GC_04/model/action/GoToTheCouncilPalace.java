package it.polimi.ingsw.GC_04.model.action;

import it.polimi.ingsw.GC_04.model.FamilyMember;
import it.polimi.ingsw.GC_04.model.Model;
import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.area.CouncilPalaceArea;

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
	}

}
