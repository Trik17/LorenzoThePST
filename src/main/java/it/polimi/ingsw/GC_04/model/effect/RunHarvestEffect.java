package it.polimi.ingsw.GC_04.model.effect;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.polimi.ingsw.GC_04.model.Dice;
import it.polimi.ingsw.GC_04.model.FamilyMember;
import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.action.RunHarvest;

public class RunHarvestEffect extends ActionEffect {
	private RunHarvest runHarvest;

	@JsonCreator
	public RunHarvestEffect(@JsonProperty("dice")Dice dice) {
		this.dice = dice;
	}

	public void setParameters(Player player,int servants) {
		FamilyMember fMember = new FamilyMember(dice);
		runHarvest = new RunHarvest(player, fMember, servants);
	}
	
	@Override
	public void apply(Player player) {
		
		runHarvest.apply();

	}

}

