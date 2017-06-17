package it.polimi.ingsw.GC_04.controller;

import java.util.List;

import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.card.CharacterCard;
import it.polimi.ingsw.GC_04.model.resource.Coins;
import it.polimi.ingsw.GC_04.model.resource.Resource;
import it.polimi.ingsw.GC_04.model.resource.Servants;
import it.polimi.ingsw.GC_04.model.resource.Stones;
import it.polimi.ingsw.GC_04.model.resource.VictoryPoints;
import it.polimi.ingsw.GC_04.model.resource.Woods;

public class FinalScore {
	
	

	public static int calculateFinalScore(Player player) {
		List<Resource> playerRes = player.getResources();
		int finalScore = 0;
		
		VictoryPoints.sumEndVictoryPoints(player);
		calculateResourceScore(player);
		calcuateCharacterCardScore(player);
		
		for (Resource res:playerRes) 
			if (res instanceof VictoryPoints)
				finalScore = res.getQuantity();
		
		return finalScore;
		
	}
	
	public static void calculateResourceScore(Player player) {
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
	
	public static void calcuateCharacterCardScore(Player player) {
		int characterCards = player.getCards(new CharacterCard()).size();
		List<Resource> playerRes = player.getResources();
		int CharacterCardScore = 0;
		
		switch (characterCards) {
		
		case 1:
			CharacterCardScore = 1;
			break;
		case 2:
			CharacterCardScore = 3;
			break;
		case 3:
			CharacterCardScore = 6;
			break;
		case 4:
			CharacterCardScore = 10;
			break;
		case 5:
			CharacterCardScore = 15;
			break;
		case 6:
			CharacterCardScore = 21;
			break;
		default:
			break;
		}
		
		for (Resource res:playerRes) 
			if (res instanceof VictoryPoints)
				res.addQuantity(CharacterCardScore);
		
	}
}
