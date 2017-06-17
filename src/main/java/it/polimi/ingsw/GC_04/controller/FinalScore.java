package it.polimi.ingsw.GC_04.controller;

import java.util.List;

import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.card.CharacterCard;
import it.polimi.ingsw.GC_04.model.card.TerritoryCard;
import it.polimi.ingsw.GC_04.model.resource.Coins;
import it.polimi.ingsw.GC_04.model.resource.FaithPoints;
import it.polimi.ingsw.GC_04.model.resource.Resource;
import it.polimi.ingsw.GC_04.model.resource.Servants;
import it.polimi.ingsw.GC_04.model.resource.Stones;
import it.polimi.ingsw.GC_04.model.resource.VictoryPoints;
import it.polimi.ingsw.GC_04.model.resource.Woods;

public class FinalScore {
	
	private static void addVictoryPoints(Player player, int bonus) {
		List<Resource> playerRes = player.getResources();
		
		for (Resource res:playerRes) 
			if (res instanceof VictoryPoints)
				res.addQuantity(bonus);
	}
	

	public static int calculateFinalScore(Player player) {
		List<Resource> playerRes = player.getResources();
		int finalScore = 0;
		
		VictoryPoints.sumEndVictoryPoints(player);
		calculateResourceScore(player);
		calculateCharacterCardScore(player);
		calculateFaithPointsScore(player);
		calculateTerritoryCardScore(player);
		
		for (Resource res:playerRes) 
			if (res instanceof VictoryPoints)
				finalScore = res.getQuantity();
		
		return finalScore;
		
	}
	
	private static void calculateResourceScore(Player player) {
		List<Resource> playerRes = player.getResources();
		int resourceScore = 0;
		
		for (Resource res:playerRes) {
			if (res instanceof Woods ||
				res instanceof Stones ||
				res instanceof Coins ||
				res instanceof Servants)
			resourceScore += res.getQuantity();
		}
		
		addVictoryPoints(player,resourceScore);
	}
	
	private static void calculateCharacterCardScore(Player player) {
		int characterCards = player.getCards(new CharacterCard()).size();
		int characterCardScore = 0;
		int bonusScore = 0;
		
		for(int cont=0; cont<=characterCards; cont++) {
			characterCardScore += bonusScore;
			bonusScore++;
		}
		
		addVictoryPoints(player, characterCardScore);
		
	}
	
	private static void calculateTerritoryCardScore(Player player) {
		int territoryCards = player.getCards(new TerritoryCard()).size();
		int territoryCardScore = 0;
		int addingScore = 2;
		int bonusScore = 1;
		
		for (int cont=3; cont<=territoryCards; cont++) {
			territoryCardScore += bonusScore;
			bonusScore += addingScore;
			addingScore++;
		}
		
		addVictoryPoints(player, territoryCardScore);
		
	}
	
	private static void calculateFaithPointsScore(Player player) {
		List<Resource> playerRes = player.getResources();
		int faithPointsScore = 0;
		int faithPoints = 0;
		
		for (Resource res:playerRes) 
			if (res instanceof FaithPoints)
				faithPoints = res.getQuantity();
		
		for (int cont=1; cont<=faithPoints; cont++) {
			if (cont < 6)
				faithPointsScore++;
			if (cont >= 6 && cont < 13)
				faithPointsScore += 2;
			if (cont >= 13 && cont < 15)
				faithPointsScore += 3;
			else
				faithPointsScore += 5;
		}
		
		addVictoryPoints(player, faithPointsScore);			
	}
	

}
