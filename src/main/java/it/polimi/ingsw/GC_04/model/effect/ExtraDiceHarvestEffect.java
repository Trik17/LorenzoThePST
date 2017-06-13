package it.polimi.ingsw.GC_04.model.effect;

import it.polimi.ingsw.GC_04.model.Player;

public class ExtraDiceHarvestEffect extends ExtraDiceEffect {

	public ExtraDiceHarvestEffect(int extra) {
		super(extra);
	}

	@Override
	public void apply(Player player) {
		player.getExtraDice().setHarvestExtra(extra);
	}
	

	

}
