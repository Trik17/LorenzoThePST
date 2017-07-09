package it.polimi.ingsw.GC_04.server.model.effect;

import com.fasterxml.jackson.annotation.JsonCreator;

import it.polimi.ingsw.GC_04.server.model.Player;

public class ActionSpacePenalityEffect extends Effect {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5939944446035555899L;

	@Override
	public void apply(Player player) {
		player.setActionSpacePenality();

	}
	
	@JsonCreator
	public ActionSpacePenalityEffect(){
		
	}

}
