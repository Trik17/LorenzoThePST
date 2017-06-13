package it.polimi.ingsw.GC_04.model.effect;

import it.polimi.ingsw.GC_04.model.Player;

public class ExtraDiceProductionEffect extends ExtraDiceEffect{

	public ExtraDiceProductionEffect(int extra) {
		super(extra);
	}

	@Override
	public void apply(Player player) {
		player.getExtraDice().setProductionExtra(extra);

	}

}
