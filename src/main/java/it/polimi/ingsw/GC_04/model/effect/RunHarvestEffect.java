package it.polimi.ingsw.GC_04.model.effect;

import it.polimi.ingsw.GC_04.model.Dice;
import it.polimi.ingsw.GC_04.model.FamilyMember;
import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.action.RunHarvest;

public class RunHarvestEffect extends ActionEffect {

	public RunHarvestEffect(Dice dice) {
		this.dice = dice;
	}

	@Override
	public void apply(Player player) {
		
		/*prima chiede al giocatore se vuole usare dei servants e quanti
		 * poi fa questo.. io inizializzo i servants così giusto per far compilare
		 */
		int servants = 0;
		
		FamilyMember fMember = new FamilyMember(dice);
		RunHarvest check = new RunHarvest(player, fMember, servants);
		check.apply();

	}

}

