package it.polimi.ingsw.GC_04.model.effect;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.polimi.ingsw.GC_04.model.Dice;
import it.polimi.ingsw.GC_04.model.FamilyMember;
import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.action.RunProduction;

public class RunProductionEffect extends ActionEffect {
	private RunProduction runProduction;

	@JsonCreator
	public RunProductionEffect(@JsonProperty("dice") Dice dice) {
		this.dice = dice;
	}

	public void setParameters(Player player,int servants) {
		FamilyMember fMember = new FamilyMember(dice);
		runProduction = new RunProduction(player, fMember, servants);
	}

	@Override
	public void apply(Player player) {
		
		runProduction.apply();

	}

}
