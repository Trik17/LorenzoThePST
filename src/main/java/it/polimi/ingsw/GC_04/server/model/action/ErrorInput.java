package it.polimi.ingsw.GC_04.server.model.action;

import it.polimi.ingsw.GC_04.server.model.FamilyMember;
import it.polimi.ingsw.GC_04.server.model.Model;
import it.polimi.ingsw.GC_04.server.model.Player;

public class ErrorInput extends Action {

	public ErrorInput() {
		// TODO Auto-generated constructor stub
	}

	public ErrorInput(Model model, Player player, FamilyMember fMember, int servants) {
		super(model, player, fMember, servants);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isApplicable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void apply() {
		// TODO Auto-generated method stub

	}

}
