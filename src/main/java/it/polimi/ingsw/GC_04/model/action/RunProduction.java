package it.polimi.ingsw.GC_04.model.action;


import it.polimi.ingsw.GC_04.model.ActionSpace;
import it.polimi.ingsw.GC_04.model.FamilyMember;
import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.area.HarvestArea;
import it.polimi.ingsw.GC_04.model.area.ProductionArea;

public class RunProduction extends Action {
	
	public RunProduction(Player player, FamilyMember fMember, int servants) {
		super(player, fMember, servants);
		this.area = ProductionArea.instance();
	}
	
	@Override
	public boolean isApplicable() {
		return isColorAvailable() &&
				isValueEnough() &&
				isAvailable();
	}
	
	public void createNewASpace() {
		HarvestArea.instance().getASpaces().add(new ActionSpace(1, null));
	}

	@Override
	public void apply() {
		applyEffects();
		applyPlayerChanges();
		
	}
	//TODO: fai chiedere al controller cosa attivare
	
	
	

	
}

