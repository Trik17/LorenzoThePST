package it.polimi.ingsw.GC_04.server.controller;

import java.util.List;

import it.polimi.ingsw.GC_04.server.model.Player;
import it.polimi.ingsw.GC_04.server.model.area.VaticanReport;
import it.polimi.ingsw.GC_04.server.model.card.BuildingCard;
import it.polimi.ingsw.GC_04.server.model.card.CharacterCard;
import it.polimi.ingsw.GC_04.server.model.card.DevelopmentCard;
import it.polimi.ingsw.GC_04.server.model.card.TerritoryCard;
import it.polimi.ingsw.GC_04.server.model.card.VentureCard;
import it.polimi.ingsw.GC_04.server.model.resource.Coins;
import it.polimi.ingsw.GC_04.server.model.resource.FaithPoints;
import it.polimi.ingsw.GC_04.server.model.resource.MilitaryPoints;
import it.polimi.ingsw.GC_04.server.model.resource.Resource;
import it.polimi.ingsw.GC_04.server.model.resource.Servants;
import it.polimi.ingsw.GC_04.server.model.resource.Stones;
import it.polimi.ingsw.GC_04.server.model.resource.VictoryPoints;
import it.polimi.ingsw.GC_04.server.model.resource.Woods;

public class FinalScore {
	
	private static void addVictoryPoints(Player player, int bonus) {
		player.getResource(new VictoryPoints()).addQuantity(bonus);
		
	}
	

	public static Player[] getRanking(Player[] players) {
		for (int i = 0; i < players.length; i++) 
			calculateFinalScore(players[i]);
		
		calculateMilitaryPointsScore(players);
		
		Player[] ranking = new Player[players.length];
		int position = 0;
		boolean empty = false;
	
		while(!empty) {
			empty = true;
			ranking[position] = SupportFunctions.maxVictoryPoints(players);
			position++;
			for (int i = 0; i < players.length; i++) {
				if (players[i] != null)
					empty = false;
			}
		}
		
		return ranking;	
	}
	
	private static void calculateMilitaryPointsScore(Player[] players) {
		
		Player firstPlayer = null;
		Player secondPlayer = null;
		int max1 = 0;
		int max2 = 0;
		
		for (Player player:players) {
			if (player.getResource(new MilitaryPoints()).getQuantity() > max1) {
				firstPlayer = player;
				max1 = firstPlayer.getResource(new MilitaryPoints()).getQuantity();
			}
			else if (player.getResource(new MilitaryPoints()).getQuantity() > max2) {
				secondPlayer = player;
				max2 = secondPlayer.getResource(new MilitaryPoints()).getQuantity();
			}
		}
		
		if (firstPlayer != null)
			addVictoryPoints(firstPlayer, 5);
		if (secondPlayer != null)
			addVictoryPoints(secondPlayer, 2);
	}
	
	public static int calculateFinalScore(Player player) {
		int finalScore = 0;
		
		if (!player.isDeleteCardsEffectActive(new VentureCard()))
			VictoryPoints.sumEndVictoryPoints(player);
		if (!player.isDeleteCardsEffectActive(new TerritoryCard()))
			calculateTerritoryCardScore(player);
		if (!player.isDeleteCardsEffectActive(new CharacterCard()))
			calculateCharacterCardScore(player);
		if (player.isDeleteCardsEffectActive(new BuildingCard()))
			calculateBuildingCardsMalus(player);
		
		calculateFaithPointsScore(player);
		calculateResourceScore(player);
		
		finalScore = player.getResource(new FaithPoints()).getQuantity();
		
		return finalScore;
		
	}
	
	private static void calculateFaithPointsScore(Player player) {
		VaticanReport.addFaithPointsScore(player);
		
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
	
	
	
	public static void calculateBuildingCardsMalus(Player player) {
		List<DevelopmentCard> buildingCards = player.getCards(new BuildingCard());
		
		int malus = 0;
		
		for(DevelopmentCard card:buildingCards) {
			List<Resource> cost = card.getCost1();
			
			Object[] resources = cost.stream().filter(res -> (res instanceof Woods)|| (res instanceof Coins)).toArray();
			
			for (Object res : resources) {
				malus += ((Resource) res).getQuantity();
			}
		}
		
		addVictoryPoints(player, -malus);
	}
	

}
