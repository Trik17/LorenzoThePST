package it.polimi.ingsw.GC_04.model.effect;

import it.polimi.ingsw.GC_04.model.Player;

public class ActionSpacePenalityEffect extends Effect {

	@Override
	public void apply(Player player) {
		player.setActionSpacePenality();

	}

}
