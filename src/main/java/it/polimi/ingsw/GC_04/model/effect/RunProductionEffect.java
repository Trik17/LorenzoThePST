package it.polimi.ingsw.GC_04.model.effect;

import it.polimi.ingsw.GC_04.model.Dice;
import it.polimi.ingsw.GC_04.model.FamilyMember;
import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.action.RunProduction;

public class RunProductionEffect extends ActionEffect {
	private int diceValue;
	

	@Override
	public void apply(Player player) {
		
		/*prima chiede al giocatore se vuole usare dei servants e quanti
		 * poifa questo.. io inizializzo i servants così giusto per far compilare
		 */
		int servants = 0;
		
		FamilyMember fMember = new FamilyMember(new Dice(diceValue));
		RunProduction check = new RunProduction(player, fMember, servants);
		check.apply();

	}

}
