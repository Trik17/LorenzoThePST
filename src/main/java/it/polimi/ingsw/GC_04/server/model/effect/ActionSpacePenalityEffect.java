package it.polimi.ingsw.GC_04.server.model.effect;

import com.fasterxml.jackson.annotation.JsonCreator;

import it.polimi.ingsw.GC_04.server.model.Player;

public class ActionSpacePenalityEffect extends Effect {

	@Override
	public void apply(Player player) {
		player.setActionSpacePenality();

	}
	
	@JsonCreator
	public ActionSpacePenalityEffect(){
		
	}

}
