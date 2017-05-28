package it.polimi.ingsw.GC_04.model.Effect;

import com.fasterxml.jackson.annotation.JsonFormat.Value;

import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.Card.DevelopmentCard;

public class TakeACardEffect extends ActionEffect {
	private DevelopmentCard cardType;
	private int diceValue;

	public TakeACardEffect() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void apply(Player player) {
		// TODO Auto-generated method stub

	}

}
