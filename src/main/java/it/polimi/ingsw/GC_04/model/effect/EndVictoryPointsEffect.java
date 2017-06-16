package it.polimi.ingsw.GC_04.model.effect;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.polimi.ingsw.GC_04.model.resource.Resource;
import it.polimi.ingsw.GC_04.model.resource.VictoryPoints;

public class EndVictoryPointsEffect extends ResourceEffect {
		
	@JsonCreator
	public EndVictoryPointsEffect(@JsonProperty("vPoints") VictoryPoints vPoints){// its method "apply()" is not called until the end of the game
		this.effect = new ArrayList<Resource>();
		this.effect.add(vPoints);
		
	}	
		
}
