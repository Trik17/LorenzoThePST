package it.polimi.ingsw.GC_04.model.Action;

import it.polimi.ingsw.GC_04.model.FamilyMember;
import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.Area.CouncilPalaceArea;

//aggiunto setNext...
public class GoToTheCouncilPalace extends Action{

	public GoToTheCouncilPalace(Player player, FamilyMember fMember, int servants) {
		super(player, fMember, servants);
		this.area = CouncilPalaceArea.instance();
		
		
	}
	
	private void setNextTurnOrder() {
		CouncilPalaceArea.instance().setNextTurnOrder(player);
		
	}
	
	@Override
	public boolean isApplicable() {
		return isValueEnough();
	}

	@Override
	public void apply() {
		applyActionSpaceEffect();
		
	}

}
