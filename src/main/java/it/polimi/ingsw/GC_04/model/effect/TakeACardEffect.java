package it.polimi.ingsw.GC_04.model.effect;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.polimi.ingsw.GC_04.model.ActionSpace;
import it.polimi.ingsw.GC_04.model.Dice;
import it.polimi.ingsw.GC_04.model.FamilyMember;
import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.action.TakeACard;
import it.polimi.ingsw.GC_04.model.card.DevelopmentCard;
import it.polimi.ingsw.GC_04.model.resource.Coins;
import it.polimi.ingsw.GC_04.model.resource.RawMaterial;
import it.polimi.ingsw.GC_04.model.resource.Resource;
import it.polimi.ingsw.GC_04.model.resource.Servants;
import it.polimi.ingsw.GC_04.model.resource.Stones;

public class TakeACardEffect extends ActionEffect {
	private DevelopmentCard cardType;
	private TakeACard takeACard;
	private List<Resource> discount;
	
	@JsonCreator
	public TakeACardEffect(@JsonProperty("cardType") DevelopmentCard cardType,@JsonProperty("dice") Dice dice,@JsonProperty("discount") List<Resource> discount) {
		this.cardType = cardType;
		this.dice = dice;
		this.discount = discount;
		this.requestedAuthorization = true;
		
		}

	public void setParameters(Player player,DevelopmentCard card, ActionSpace aSpace,int servants,List<Resource> cost) {
		FamilyMember fMember = new FamilyMember(dice);
		Resource.subtractResource(cost, discount);
		if(card.getClass().equals(cardType.getClass()) || cardType == null)
			takeACard = new TakeACard(player, card, aSpace, fMember, servants, cost);
		//altrimenti richiama il controller
	}
	
	@Override
	public void apply(Player player) {
		if (takeACard.isApplicable())
			takeACard.apply();
	}

	
}
