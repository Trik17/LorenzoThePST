package it.polimi.ingsw.GC_04.controller;

import java.util.ArrayList;
import java.util.List;

import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.card.CharacterCard;
import it.polimi.ingsw.GC_04.model.card.DevelopmentCard;
import it.polimi.ingsw.GC_04.model.resource.Coins;
import it.polimi.ingsw.GC_04.model.resource.Resource;
import it.polimi.ingsw.GC_04.model.resource.Servants;
import it.polimi.ingsw.GC_04.model.resource.Stones;
import it.polimi.ingsw.GC_04.model.resource.VictoryPoints;
import it.polimi.ingsw.GC_04.model.resource.Woods;

public class FinalScore {
	
	

	public static int calculateFinalScore(Player player) {
		VictoryPoints.sumEndVictoryPoints(player);
		calculateFinalScore(player);
		
		return 0;
		
	}
	
	public void calculateResourceScore(Player player) {
		List<Resource> playerRes = player.getResources();
		int resourceScore = 0;
		
		for (Resource res:playerRes) {
			if (res instanceof Woods ||
				res instanceof Stones ||
				res instanceof Coins ||
				res instanceof Servants)
			resourceScore += res.getQuantity();
		}
		
		for (Resource res:playerRes) 
			if (res instanceof VictoryPoints)
				res.addQuantity(resourceScore);
	}
	
	/*public void calcuateCharacterCardScore(Player player) {
		int characterCards = player.getCards(new CharacterCard()).size();
		int CharacterCardScore = 
		
		
	}*/
}
