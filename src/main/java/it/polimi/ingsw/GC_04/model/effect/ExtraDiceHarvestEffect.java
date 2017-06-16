package it.polimi.ingsw.GC_04.model.effect;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.polimi.ingsw.GC_04.model.Player;

public class ExtraDiceHarvestEffect extends ExtraDiceEffect {

	@JsonCreator
	public ExtraDiceHarvestEffect(@JsonProperty("extra") int extra) {
		super(extra);
	}

	@Override
	public void apply(Player player) {
		player.getExtraDice().setHarvestExtra(extra);
	}
	

	

}
