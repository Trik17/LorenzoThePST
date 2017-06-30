package it.polimi.ingsw.GC_04.controller;

import java.util.List;

import it.polimi.ingsw.GC_04.model.Dice;
import it.polimi.ingsw.GC_04.model.FamilyMember;
import it.polimi.ingsw.GC_04.model.Model;
import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.card.BuildingCard;
import it.polimi.ingsw.GC_04.model.card.CharacterCard;
import it.polimi.ingsw.GC_04.model.card.DevelopmentCard;
import it.polimi.ingsw.GC_04.model.card.TerritoryCard;
import it.polimi.ingsw.GC_04.model.card.VentureCard;
import it.polimi.ingsw.GC_04.model.resource.Resource;

public class StateOfTheGameCLI {

	public StateOfTheGameCLI() {
	}
	
	public static void print(String string) {
		System.out.println(string);
	}
	
	public static String printStateOfTheGame(Model model,DevelopmentCard[] tCards,DevelopmentCard[] cCards,DevelopmentCard[] bCards,DevelopmentCard[] vCards,Dice bDice,Dice oDice,Dice wDice) {
		String state = "BOARD:";
		state += printCards(tCards, cCards, bCards, vCards);
		state += printDices(bDice, oDice, wDice);
		
		
		for (Player p:model.getPlayers())
			state += printPersonalBoard(p);
		
		return state;
	}
	

	
	public static String printCards(DevelopmentCard[] tCards,DevelopmentCard[] cCards,DevelopmentCard[] bCards,DevelopmentCard[] vCards) {
		int cont = 1;
		
		String cards = "\nTERRITORY CARDS:      CHARACTER CARDS:      BUILDING CARDS:       VENTURE CARDS:";
		
		int length = Integer.max(Integer.max(Integer.max(tCards.length, cCards.length),bCards.length),vCards.length);
		
		for(int i = 0; i < length; i++) {
			
			cards += cont+SupportFunctions.cardInArray(tCards, i);
			cards += cont+SupportFunctions.cardInArray(cCards, i);
			cards += cont+SupportFunctions.cardInArray(bCards, i);
			cards += cont+SupportFunctions.cardInArray(vCards, i)+"\n";
			
			cont++;
				/*System.out.printf("%d", cont);
				System.out.printf(SupportFunctions.cardInArray(tCards, i));
				System.out.printf("%d", cont);
				System.out.printf(SupportFunctions.cardInArray(cCards, i));			
				System.out.printf("%d", cont);
				System.out.printf(SupportFunctions.cardInArray(bCards, i));
				System.out.printf("%d", cont);
				System.out.printf("%s\n",SupportFunctions.cardInArray(vCards, i));*/
			
			
			
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
	
	public static String printDices(Dice bDice,Dice oDice,Dice wDice) {
		String dices = "BLACK DICE: "+ bDice.getValue()+"\n";
		dices += "ORANGE DICE: "+ oDice.getValue()+"\n";
		dices += "WHITE DICE: "+ wDice.getValue()+"\n";
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