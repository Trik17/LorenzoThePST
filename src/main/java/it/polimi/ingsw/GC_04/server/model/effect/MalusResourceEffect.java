package it.polimi.ingsw.GC_04.server.model.effect;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.polimi.ingsw.GC_04.server.model.Player;
import it.polimi.ingsw.GC_04.server.model.resource.Resource;

public class MalusResourceEffect extends Effect{
	private static final long serialVersionUID = -7502493851111105648L;
	private Resource malus;
	@JsonCreator
	public MalusResourceEffect(@JsonProperty("malus") Resource malus) {
		this.malus = malus;
	}

	@Override
	public void apply(Player player) {
		player.getMalus().add(malus);
		
	}

	
}
