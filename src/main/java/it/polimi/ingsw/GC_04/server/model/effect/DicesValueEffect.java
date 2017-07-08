package it.polimi.ingsw.GC_04.server.model.effect;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.polimi.ingsw.GC_04.server.model.FamilyMember;
import it.polimi.ingsw.GC_04.server.model.Player;

public class DicesValueEffect extends Effect {
	/*
	 * effect of leader cards
	 * Lucrezia di Borgia
	 * Ludovico il Moro
	 * Sigismondo Malatesta
	 */
	
	private int value;
	private boolean valueAdded; //if it's false the value of the family member is replaced by this value, otherwise this value is added to the existing one
	private boolean onlyNeutralMember; //if it's false the value of the family member is replaced by this value, otherwise this value is added to the existing one
	
	@JsonCreator
	public DicesValueEffect(@JsonProperty("value") int value) {
		this.value = value;
	}

	@Override
	public void apply(Player player) {
			
		//it replaces the value of each family members
		FamilyMember.changeValue(player.getFamily(),value,valueAdded,onlyNeutralMember);
	}

	
}
