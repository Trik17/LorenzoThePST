package it.polimi.ingsw.GC_04.model.effect;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.polimi.ingsw.GC_04.model.Player;

public class ExtraDiceProductionEffect extends ExtraDiceEffect{

	@JsonCreator
	public ExtraDiceProductionEffect(@JsonProperty("extra") int extra) {
		super(extra);
	}

	@Override
	public void apply(Player player) {
		player.getExtraDice().setProductionExtra(extra);

	}

}
