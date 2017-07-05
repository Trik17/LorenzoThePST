package it.polimi.ingsw.GC_04.server.model.effect;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.polimi.ingsw.GC_04.server.model.Player;
import it.polimi.ingsw.GC_04.server.model.resource.VictoryPoints;

public class EndVictoryPointsEffect extends Effect{
	private VictoryPoints effect;
		
	@JsonCreator
	public EndVictoryPointsEffect(@JsonProperty("vPoints") VictoryPoints vPoints){// its method "apply()" is not called until the end of the game
		this.effect = vPoints;
		
	}	
	@Override
	public void apply(Player player) {
		effect.addEndVictoryPoints(player);
	}

}
