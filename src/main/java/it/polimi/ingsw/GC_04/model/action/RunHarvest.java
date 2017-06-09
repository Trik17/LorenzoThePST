package it.polimi.ingsw.GC_04.model.action;

import java.util.List;

import it.polimi.ingsw.GC_04.model.FamilyMember;
import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.area.HarvestArea;
import it.polimi.ingsw.GC_04.model.area.ProductionArea;
import it.polimi.ingsw.GC_04.model.card.DevelopmentCard;
import it.polimi.ingsw.GC_04.model.card.TerritoryCard;
import it.polimi.ingsw.GC_04.model.effect.Effect;
import it.polimi.ingsw.GC_04.model.effect.EndVictoryPointsEffect;


public class RunHarvest extends Action{
	private static final int HARVPENALITY = 3;
	private int harvValue;
	
	public RunHarvest(Player player, FamilyMember fMember, int servants) {
		super(player, fMember, servants);
		this.area = HarvestArea.instance();
		
		if (ProductionArea.instance().getASpace().isEmpty()) harvValue = value;
		else harvValue = value - HARVPENALITY;
	}
	
	@Override
	public boolean isApplicable() {
		return isColorAvailable() &&
				isValueEnough() &&
				isAvailable();
	}

	@Override
	public void apply() {
		List<DevelopmentCard> myTCards = player.getCards(new TerritoryCard());
		
		myTCards.forEach(card -> {//for all the cards which belong to the player
			for(Effect eff:((TerritoryCard) card).getHarvest().getEffects()){//it scroll through the production effects
				if(eff instanceof EndVictoryPointsEffect) continue;//it doesn't apply this effect because it will be applied only at the end of the game
				if(harvValue >= ((TerritoryCard) card).getHarvest().getDiceValue()) eff.apply(player);}}); //it apply all the production effects whose dice value is <= than the value of the dice with which the action is performed 
	}
	

}
