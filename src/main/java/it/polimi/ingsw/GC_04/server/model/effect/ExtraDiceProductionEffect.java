package it.polimi.ingsw.GC_04.server.model.effect;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.polimi.ingsw.GC_04.server.model.Player;

public class ExtraDiceProductionEffect extends ExtraDiceEffect{

	/**
	 * 
	 */
	private static final long serialVersionUID = 972135001023270032L;

	@JsonCreator
	public ExtraDiceProductionEffect(@JsonProperty("extra") int extra) {
		super(extra);
	}

	@Override
	public void apply(Player player) {
		player.getExtraDice().setProductionExtra(extra);

	}

}
