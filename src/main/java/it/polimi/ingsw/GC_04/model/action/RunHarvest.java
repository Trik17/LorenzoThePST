package it.polimi.ingsw.GC_04.model.action;

import it.polimi.ingsw.GC_04.model.ActionSpace;
import it.polimi.ingsw.GC_04.model.FamilyMember;
import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.area.CouncilPalaceArea;
import it.polimi.ingsw.GC_04.model.area.HarvestArea;


public class RunHarvest extends Action{
	
	public RunHarvest(Player player, FamilyMember fMember, int servants) {
		super(player, fMember, servants);
		this.area = HarvestArea.instance();
		
	}
	
	@Override
	public boolean isApplicable() {
		return isColorAvailable() &&
				isValueEnough() &&
				isAvailable();
	}

	public void createNewASpace() {
		if(CouncilPalaceArea.instance().getTurnOrder().length < 3)
			HarvestArea.instance().getASpaces().add(new ActionSpace(1, null));
	}

	
	@Override
	public void apply() {
		applyEffects();
		applyPlayerChanges();
		createNewASpace();
	}
	

}
