package it.polimi.ingsw.GC_04.model;

import it.polimi.ingsw.GC_04.model.effect.Effect;
import it.polimi.ingsw.GC_04.model.resource.Resource;

public class MalusResourceEffect extends Effect{
	
	Resource malus;

	public MalusResourceEffect(Resource malus) {
		this.malus = malus;
	}

	@Override
	public void apply(Player player) {
		player.getMalus().add(malus);
		
	}

	
}
