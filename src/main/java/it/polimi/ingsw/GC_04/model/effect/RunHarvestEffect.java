package it.polimi.ingsw.GC_04.model.effect;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.polimi.ingsw.GC_04.model.Dice;
import it.polimi.ingsw.GC_04.model.FamilyMember;
import it.polimi.ingsw.GC_04.model.Model;
import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.action.RunHarvest;

public class RunHarvestEffect extends ActionEffect {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2105717565683787915L;
	private RunHarvest runHarvest;

	@JsonCreator
	public RunHarvestEffect(@JsonProperty("dice")Dice dice) {
		this.dice = dice;
	}

	public void setParameters(Model model,Player player,int servants) {
		FamilyMember fMember = new FamilyMember(dice);
		runHarvest = new RunHarvest(model, player, fMember, servants);
	}
	
	@Override
	public void apply(Player player) {
		
		runHarvest.apply();

	}

}

