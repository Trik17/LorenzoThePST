package it.polimi.ingsw.GC_04.controller;

import it.polimi.ingsw.GC_04.model.ActionSpace;
import it.polimi.ingsw.GC_04.model.CardType;
import it.polimi.ingsw.GC_04.model.DevelopementCard;
import it.polimi.ingsw.GC_04.model.FamilyMember;
import it.polimi.ingsw.GC_04.model.Player;

public class TakeBuilding extends TakeACard{

	public TakeBuilding(Player player, DevelopementCard card, ActionSpace aSpace, FamilyMember fMember, int servants) {
		super(player, card, aSpace, fMember, servants);
		this.value = fMember.getDice().getValue() + servants + player.getExtraDice().getExtraBuilding();
	}


}
