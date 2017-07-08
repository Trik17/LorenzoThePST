package it.polimi.ingsw.GC_04.server.model.effect;

import com.fasterxml.jackson.annotation.JsonCreator;

import it.polimi.ingsw.GC_04.server.model.Player;

public class NotRequestedMilitaryPoints extends Effect {
	/*
	 * effect of the leader card
	 * Cesare Borgia
	 */
	@JsonCreator
	public NotRequestedMilitaryPoints() {
	}

	@Override
	public void apply(Player player) {
		player.setNotRequestedMilitaryPoints();

	}

}
