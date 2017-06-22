package it.polimi.ingsw.GC_04.model.action;

import it.polimi.ingsw.GC_04.model.FamilyMember;
import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.area.CouncilPalaceArea;

public class GoToTheCouncilPalace extends Action{

	public GoToTheCouncilPalace(Player player, FamilyMember fMember, int servants) {
		super(player, fMember, servants);
		this.area = CouncilPalaceArea.instance();	
		aSpace = area.getASpaces().get(area.getASpaces().size() -1);
	}
		
	
	@Override
	public boolean isApplicable() {
		return isValueEnough();
	}

	public void createNewASpace() {
		CouncilPalaceArea.instance().getASpaces().add(CouncilPalaceArea.instance().getActionSpaceDefault());
	}
	
	@Override
	public void apply() {
		applyPlayerChanges();
		applyEffects();
		createNewASpace();
	}

}
