package it.polimi.ingsw.GC_04.server.model.effect;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.polimi.ingsw.GC_04.server.model.ActionSpace;
import it.polimi.ingsw.GC_04.server.model.Dice;
import it.polimi.ingsw.GC_04.server.model.FamilyMember;
import it.polimi.ingsw.GC_04.server.model.Model;
import it.polimi.ingsw.GC_04.server.model.Player;
import it.polimi.ingsw.GC_04.server.model.action.TakeACard;
import it.polimi.ingsw.GC_04.server.model.card.DevelopmentCard;
import it.polimi.ingsw.GC_04.server.model.resource.Resource;

public class TakeACardEffect extends ActionEffect {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8953133432924803293L;
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

	public void setParameters(Model model,Player player,DevelopmentCard card, ActionSpace aSpace,int servants,List<Resource> cost) {
		FamilyMember fMember = new FamilyMember(dice);
		Resource.subtractResource(cost, discount);
		try{
			if(card.getClass().equals(cardType.getClass()))
				takeACard = new TakeACard(model, player, card, aSpace, fMember, servants, cost);
		
		}catch (NullPointerException e) {
			/* 
			 * 
			 */
			takeACard = new TakeACard(model, player, card, aSpace, fMember, servants, cost);
			
		}
	}
	
	public DevelopmentCard getCardType() {
		return cardType;
		
	}
	
	@Override
	public void apply(Player player) {
		if (takeACard.isApplicable())
			takeACard.apply();
	}

	
}
