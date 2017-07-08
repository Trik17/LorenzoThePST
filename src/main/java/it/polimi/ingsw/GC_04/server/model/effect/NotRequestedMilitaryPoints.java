package it.polimi.ingsw.GC_04.server.model.effect;

import it.polimi.ingsw.GC_04.server.model.Player;

public class NotRequestedMilitaryPoints extends Effect {
	/*
	 * effect of the leader card
	 * Cesare Borgia
	 */

	public NotRequestedMilitaryPoints() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void apply(Player player) {
		player.setNotRequestedMilitaryPoints();

	}

}
