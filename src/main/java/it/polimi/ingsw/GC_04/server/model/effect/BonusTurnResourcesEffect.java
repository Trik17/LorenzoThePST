package it.polimi.ingsw.GC_04.server.model.effect;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.polimi.ingsw.GC_04.server.model.Player;

public class BonusTurnResourcesEffect extends Effect{
	/*BonusTurnResourcesEffect
	 * effect of the leader cards:
	 * Sandro Botticelli
	 * Girolamo Savonarola
	 * Ludovico III di Gonzaga
	 * ecc
	 *
	 */
	
	private Effect effect;
	
	@JsonCreator
	public BonusTurnResourcesEffect(@JsonProperty("effect") Effect effect) {
		this.effect = effect;
	}

	@Override
	public void apply(Player player) {
		player.setBonusAction(effect);
		
	}

	/*it activates the effect when the leader card is activated for the first time
	 * the other times it is activate at the beginning of every period of the age
	*/
	public void applyFirstTime(Player player) {
		effect.apply(player);
	}
}
