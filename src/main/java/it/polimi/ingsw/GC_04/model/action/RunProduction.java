package it.polimi.ingsw.GC_04.model.action;

import java.util.List;

import it.polimi.ingsw.GC_04.model.FamilyMember;
import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.area.ProductionArea;
import it.polimi.ingsw.GC_04.model.card.BuildingCard;
import it.polimi.ingsw.GC_04.model.card.DevelopmentCard;
import it.polimi.ingsw.GC_04.model.effect.Effect;

public class RunProduction extends Action {
	
	private static final int PRODPENALITY = 3;
	private int prodValue;
	
	public RunProduction(Player player, FamilyMember fMember, int servants) {
		super(player, fMember, servants);
		this.area = ProductionArea.instance();
		
		if (ProductionArea.instance().getASpace().isEmpty()) prodValue = value;
		else prodValue = value - PRODPENALITY;
	}
	
	@Override
	public boolean isApplicable() {
		return isColorAvailable() &&
				isValueEnough() &&
				isAvailable();
	}
	

	@Override
	public void apply() {
		List<DevelopmentCard> myBCards = player.getCards(new BuildingCard());
		
		myBCards.forEach(card -> {//for all the cards which belong to the player
			for(Effect eff:((BuildingCard) card).getProduction().getEffects()){//it scroll through the production effects
				if(prodValue >= ((BuildingCard) card).getProduction().getDiceValue()) { 
					if (!eff.getRequestedAuthorization())
						eff.apply(player);
					else
						requestedAuthorizationEffects.add(eff);}}}); //it apply all the production effects whose dice value is <= than the value of the dice with which the action is performed 
				}
	
	//TODO: fai chiedere al controller cosa attivare
	
	
	

	
}

