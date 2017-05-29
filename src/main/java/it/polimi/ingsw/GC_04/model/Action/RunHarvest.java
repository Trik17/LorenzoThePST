package it.polimi.ingsw.GC_04.model.Action;

import java.util.ArrayList;

import it.polimi.ingsw.GC_04.model.FamilyMember;
import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.Area.HarvestArea;
import it.polimi.ingsw.GC_04.model.Area.ProductionArea;
import it.polimi.ingsw.GC_04.model.Card.TerritoryCard;
import it.polimi.ingsw.GC_04.model.Effect.Effect;
import it.polimi.ingsw.GC_04.model.Effect.EndVictoryPointsEffect;


public class RunHarvest extends Action{
	private static final int harvPenality = 3;
	private int harvValue;
	
	public RunHarvest(Player player, FamilyMember fMember, int servants) {
		super(player, fMember, servants);
		this.area = HarvestArea.instance();
		
		if (ProductionArea.instance().getASpace().size() < 1) harvValue = value;
		else harvValue = value - harvPenality;
	}
	
	@Override
	public boolean isApplicable() {
		return isColorAvailable() &&
				isValueEnough() &&
				isPlaceAvailable();
	}

	@Override
	public void apply() {
		@SuppressWarnings("unchecked")
		ArrayList<TerritoryCard> myTCards = (ArrayList<TerritoryCard>) player.getCards(new TerritoryCard());
		
		myTCards.forEach(card -> {//for all the cards which belong to the player
			for(Effect eff:card.getHarvest().getEffects()){//it scroll through the production effects
				if(eff instanceof EndVictoryPointsEffect) continue;//it doesn't apply this effect because it will be applied only at the end of the game
				if(harvValue >= card.getHarvest().getDiceValue()) eff.apply(player);}}); //it apply all the production effects whose dice value is <= than the value of the dice with which the action is performed 
	}
	

}
