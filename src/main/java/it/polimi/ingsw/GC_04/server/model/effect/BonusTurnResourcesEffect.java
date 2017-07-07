package it.polimi.ingsw.GC_04.server.model.effect;

import it.polimi.ingsw.GC_04.server.model.Player;

public class BonusTurnResourcesEffect extends Effect{
	
	private Effect effect;

	public BonusTurnResourcesEffect(Effect effect) {
		this.effect = effect;
	}

	@Override
	public void apply(Player player) {
		player.setBonusAction(effect);
		
	}

}
