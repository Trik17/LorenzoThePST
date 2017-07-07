package it.polimi.ingsw.GC_04.server.model.effect;

import it.polimi.ingsw.GC_04.server.model.FamilyMember;
import it.polimi.ingsw.GC_04.server.model.Player;

public class AllDicesValueEffect extends Effect {
	
	private int value;
	private boolean valueAdded; //if it's false the value of the family member is replaced by this value, otherwise this value is added to the existing one

	public AllDicesValueEffect(int value) {
		this.value = value;
	}

	@Override
	public void apply(Player player) {
			
		//it replaces the value of each family members
		FamilyMember.changeValue(player.getFamily(),value,valueAdded);
	}

}
