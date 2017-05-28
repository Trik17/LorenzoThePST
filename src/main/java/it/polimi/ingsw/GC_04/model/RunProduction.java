package it.polimi.ingsw.GC_04.model;

import java.util.ArrayList;

public class RunProduction extends Action {
	
	private static final int prodPenality = 3;
	private int prodValue;
	
	public RunProduction(Player player, FamilyMember fMember, int servants) {
		super(player, fMember, servants);
		this.area = ProductionArea.instance();
		
		if (ProductionArea.getASpace().size() < 1) prodValue = value;
		else prodValue = value - prodPenality;
	}
	
	@Override
	public boolean isApplicable() {
		return isColorAvailable() &&
				isValueEnough() &&
				isPlaceAvailable();
	}
	

	@Override
	public void apply() {
		ArrayList<BuildingCard> myBCards = (ArrayList<BuildingCard>) player.getCards(new BuildingCard());
		
		myBCards.forEach(card -> {//for all the cards which belong to the player
			for(Effect eff:card.getProduction().effects){//it scroll through the production effects
				if(eff instanceof EndVictoryPointsEffect) continue;//it doesn't apply this effect because it will be applied only at the end of the game
				if(prodValue >= card.getProduction().getDiceValue()) eff.apply(player);}}); //it apply all the production effects whose dice value is <= than value of the dice with which the action is performed 
	}
	
	
	
	
	

	
}

