package it.polimi.ingsw.GC_04.server.model.effect;

import it.polimi.ingsw.GC_04.server.model.FamilyMember;
import it.polimi.ingsw.GC_04.server.model.Player;

public class AllDicesValueEffect extends Effect {
	
	private int value;

	public AllDicesValueEffect(int value) {
		this.value = value;
	}

	@Override
	public void apply(Player player) {
		//it replaces every value of the family members with the value passed as parameter
		FamilyMember.changeValue(player.getFamily(),value);
	}

}
