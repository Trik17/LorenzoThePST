package it.polimi.ingsw.GC_04.model.Effect;

import it.polimi.ingsw.GC_04.model.ActionSpace;
import it.polimi.ingsw.GC_04.model.Dice;
import it.polimi.ingsw.GC_04.model.FamilyMember;
import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.Card.DevelopmentCard;
import it.polimi.ingsw.GC_04.model.Card.TerritoryCard;

public class TakeACardEffect extends ActionEffect {
	private DevelopmentCard cardType;
	private int diceValue;

	public TakeACardEffect(DevelopmentCard cardType, int diceValue) {
		this.cardType = cardType;
		this.diceValue = diceValue;
		}

	@Override
	public void apply(Player player) {
		/* TODO: se la carta è null il giocatore può prendere una carta di qualsiasi colore
		 * altrimenti solo dalla torre dello stesso colore della carta in ingresso
		 * dunque il giocatore cliccherà sulla carta che vuole e sui servants che vuole utilizzare
		 * ora inizializzo così servants,actionSpace e developmentCard
		 *  solo per fare compilare il codice, perè poi il resto è giusto*/
		int servants = 0; 
		ActionSpace aSpace = new ActionSpace(0, null);
		DevelopmentCard card = new TerritoryCard();
		
		//da qui è giusto
		FamilyMember fMember = new FamilyMember(new Dice(diceValue));
		player.takeACard(card, aSpace, fMember, servants);
		//aggiungere che se non va bene puoi provare con un'altra carta
	}

}
