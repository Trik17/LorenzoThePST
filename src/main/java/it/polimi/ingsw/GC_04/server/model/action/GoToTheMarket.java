package it.polimi.ingsw.GC_04.server.model.action;

import it.polimi.ingsw.GC_04.server.model.ActionSpace;
import it.polimi.ingsw.GC_04.server.model.FamilyMember;
import it.polimi.ingsw.GC_04.server.model.Model;
import it.polimi.ingsw.GC_04.server.model.Player;
import it.polimi.ingsw.GC_04.server.model.area.MarketArea;

public class GoToTheMarket extends Action {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 462723646738146111L;

	public GoToTheMarket(Model model, Player player, FamilyMember fMember, int servants, ActionSpace aSpace) {
		super(model, player, fMember, servants);
		this.area = model.getMarket();
		this.aSpace = aSpace;
	}

	@Override
	public boolean isApplicable() {
		return isAvailable() &&
				isValueEnough();
	}

	@Override
	public void apply() {
		applyPlayerChanges();
		applyEffects();
	}
	

}
