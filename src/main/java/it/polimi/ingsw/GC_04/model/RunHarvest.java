package it.polimi.ingsw.GC_04.model;

import java.util.ArrayList;


public class RunHarvest extends Action{
	private static final int harvPenality = 3;
	private int harvValue;
	
	public RunHarvest(Player player, FamilyMember fMember, int servants) {
		super(player, fMember, servants);
		this.area = HarvestArea.instance();
		
		if (ProductionArea.getASpace().size() < 1) harvValue = value;
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
		ArrayList<TerritoryCard> myBCards = (ArrayList<TerritoryCard>) player.getCards(new TerritoryCard());
		
		myBCards.forEach(card -> {//for all the cards which belong to the player
			for(Effect eff:card.getHarvest().effects){//it scroll through the production effects
				if(eff instanceof EndVictoryPointsEffect) continue;//it doesn't apply this effect because it will be applied only at the end of the game
				if(harvValue >= card.getHarvest().getDiceValue()) eff.apply(player);}}); //it apply all the production effects whose dice value is <= than the value of the dice with which the action is performed 
	}
	

}
