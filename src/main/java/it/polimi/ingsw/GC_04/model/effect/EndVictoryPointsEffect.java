package it.polimi.ingsw.GC_04.model.effect;

import java.util.ArrayList;

import it.polimi.ingsw.GC_04.model.resource.Resource;
import it.polimi.ingsw.GC_04.model.resource.VictoryPoints;

public class EndVictoryPointsEffect extends ResourceEffect {
		
	public EndVictoryPointsEffect(VictoryPoints vPoints){// its method "apply()" is not called until the end of the game
		this.effect = new ArrayList<Resource>();
		this.effect.add(vPoints);
		
	}	
		
}
