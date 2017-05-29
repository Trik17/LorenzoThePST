package it.polimi.ingsw.GC_04.model.Action;

import it.polimi.ingsw.GC_04.model.ActionSpace;
import it.polimi.ingsw.GC_04.model.FamilyMember;
import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.Area.MarketArea;

public class GoToTheMarket extends Action {
	
	public GoToTheMarket(Player player, FamilyMember fMember, int servants, ActionSpace aSpace) {
		super(player, fMember, servants);
		this.area = MarketArea.instance();
		this.aSpace = aSpace;
	}

	@Override
	public boolean isApplicable() {
		return isPlaceAvailable() &&
				isValueEnough();
	}

	@Override
	public void apply() {
		applyActionSpaceEffect();
	}
	

}
