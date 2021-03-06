package it.polimi.ingsw.GC_04.server.model.effect;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.polimi.ingsw.GC_04.server.model.Player;

public class ExtraDiceHarvestEffect extends ExtraDiceEffect {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1681214667232185091L;

	@JsonCreator
	public ExtraDiceHarvestEffect(@JsonProperty("extra") int extra) {
		super(extra);
	}

	@Override
	public void apply(Player player) {
		player.getExtraDice().setHarvestExtra(extra);
	}
	

	

}
