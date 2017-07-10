package it.polimi.ingsw.GC_04.server.controller;

import java.util.List;
import java.util.Map;

import it.polimi.ingsw.GC_04.server.model.Dice;
import it.polimi.ingsw.GC_04.server.model.DiceColor;
import it.polimi.ingsw.GC_04.server.model.FamilyMember;
import it.polimi.ingsw.GC_04.server.model.Model;
import it.polimi.ingsw.GC_04.server.model.Player;
import it.polimi.ingsw.GC_04.server.model.card.BuildingCard;
import it.polimi.ingsw.GC_04.server.model.card.CharacterCard;
import it.polimi.ingsw.GC_04.server.model.card.DevelopmentCard;
import it.polimi.ingsw.GC_04.server.model.card.TerritoryCard;
import it.polimi.ingsw.GC_04.server.model.card.VentureCard;
import it.polimi.ingsw.GC_04.server.model.resource.Resource;
import it.polimi.ingsw.GC_04.server.model.resource.VictoryPoints;
/*
 * this class expose the static methods used to create a string that represents the state of the game 
 * that will be printed by the viewCLI
 */
public class StateOfTheGameCLI {

	public StateOfTheGameCLI() {
	}
	
	public static String printLeaderCards(Player player) {
		String cards = "\n"+player.getName()+"'S LEADER CARDS:\n\n";
		int cont = 1;
		
		for (int i = 0; i< player.getLeaderCards().size(); i++) {
			cards += cont+")"+player.getLeaderCards().get(i).getDescription()+"\n\n";
			cont++;
		}
		
		cards += "\n\n";
		return cards;
	}
	
	public static String printRanking(Player[] players) {
		int position = 1;
		String ranking = "\n\nRANKING:\n";
		
		for (int i = 0; i < players.length; i++) {
			ranking += position+")"+players[i].getName()+" with "+players[i].getResource(new VictoryPoints()).getQuantity()+" Victory Points\n";
			position++;
		}
		return ranking;
	}
	
	public static String printStateOfTheGame(Model model,DevelopmentCard[] tCards,DevelopmentCard[] cCards,DevelopmentCard[] bCards,DevelopmentCard[] vCards,Map<DiceColor, Dice> dices) {
		String state = "BOARD:";
		state += printCards(tCards, cCards, bCards, vCards);
		state += printDices(dices);
		
		for(Player p:model.getPlayers())
			state += printLeaderCards(p);
		
		for (Player p:model.getPlayers())
			state += printPersonalBoard(p);
		
		return state;
	}
	

	
	public static String printCards(DevelopmentCard[] tCards,DevelopmentCard[] cCards,DevelopmentCard[] bCards,DevelopmentCard[] vCards) {
		int cont = 1;
		
		String cards = "\nTERRITORY CARDS:      CHARACTER CARDS:      BUILDING CARDS:       VENTURE CARDS:\n";
		
		int length = Integer.max(Integer.max(Integer.max(tCards.length, cCards.length),bCards.length),vCards.length);
		
		for(int i = 0; i < length; i++) {
			
			cards += cont+SupportFunctions.cardInArray(tCards, i);
			cards += cont+SupportFunctions.cardInArray(cCards, i);
			cards += cont+SupportFunctions.cardInArray(bCards, i);
			cards += cont+SupportFunctions.cardInArray(vCards, i)+"\n";
			
			cont++;
			
		}
		if (length == 0)
			cards += "**************        **************        **************        **************   \n";
		
		return cards;
	}
	
	public static String printPersonalBoard(Player player) {
		String pBoard = player.getName()+" has:\n";
		pBoard += printPersonalCards(player);
		pBoard += printResources(player);
		pBoard += printFamily(player);
		return pBoard;
	}
	
	public static String printResources(Player player) {
	
		List<Resource> resourcesList = player.getResources();
		String resources = player.getName()+" has:\n";
		for(Resource res:resourcesList)
			resources += res.getQuantity()+" "+res.getClass().getSimpleName()+"\n";
		return resources;
	}

	public static String printPersonalCards(Player player) {
		
		DevelopmentCard[] tCards = DevelopmentCard.toArray(player.getCards(new TerritoryCard()));
		DevelopmentCard[] cCards = DevelopmentCard.toArray(player.getCards(new CharacterCard()));
		DevelopmentCard[] bCards = DevelopmentCard.toArray(player.getCards(new BuildingCard()));
		DevelopmentCard[] vCards = DevelopmentCard.toArray(player.getCards(new VentureCard()));
		String cards = printCards(tCards, cCards, bCards, vCards);
		return cards;
	}
	
	public static String printDices(Map<DiceColor, Dice> dicesMap) {
		String dices = "BLACK DICE: "+ dicesMap.get(DiceColor.BLACK).getValue()+"\n";
		dices += "ORANGE DICE: "+ dicesMap.get(DiceColor.ORANGE).getValue()+"\n";
		dices += "WHITE DICE: "+ dicesMap.get(DiceColor.WHITE).getValue()+"\n";
		return dices;
		
	}
	
	public static String printFamily(Player player) {
		FamilyMember[] familyArray = player.getFamily();
		String family = "Family Member NEUTRAL: used = "+familyArray[0].isUsed()+"\n";
		family += "Family Member BLACK: used = "+familyArray[1].isUsed()+"\n";
		family +="Family Member ORANGE: used = "+familyArray[2].isUsed()+"\n";
		family +="Family Member WHITE: used = "+familyArray[3].isUsed()+"\n";
		return family;
	}
}
