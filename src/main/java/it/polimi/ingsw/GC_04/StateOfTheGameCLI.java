package it.polimi.ingsw.GC_04;

import java.util.List;

import it.polimi.ingsw.GC_04.model.Dice;
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
	
	public static void printStateOfTheGame(Model model,DevelopmentCard[] tCards,DevelopmentCard[] cCards,DevelopmentCard[] bCards,DevelopmentCard[] vCards,Dice bDice,Dice oDice,Dice wDice) {
		print("BOARD:");
		printCards(tCards, cCards, bCards, vCards);
		printDices(bDice, oDice, wDice);
		
		for (Player player:model.getPlayers())
			printPersonalBoard(player);
		
	}
	
	public static String nameCard(DevelopmentCard card) {
		try {
			String name = ")"+card.getName();
			return name;
		}catch (NullPointerException e) {
			String name = ")EMPTY";
			return name;
		}
		
	}
	
	public static void printCards(DevelopmentCard[] tCards,DevelopmentCard[] cCards,DevelopmentCard[] bCards,DevelopmentCard[] vCards) {
		int cont = 1;
		print("");
		print("TERRITORY CARDS:      CHARACTER CARDS:      BUILDING CARDS:       VENTURE CARDS:");
		
		int length = Integer.max(Integer.max(Integer.max(tCards.length, cCards.length),bCards.length),vCards.length);
		
		for(int i = 0; i < length; i++) {
			
			System.out.printf("%d", cont);
			System.out.printf(nameCard(tCards[i]));
			System.out.printf("%d", cont);
			System.out.printf(nameCard(cCards[i]));			
			System.out.printf("%d", cont);
			System.out.printf(nameCard(bCards[i]));
			System.out.printf("%d", cont);
			System.out.printf("%s\n",nameCard(vCards[i]));
			
			cont++;
			
		}
		print("");
	}
	
	public static void printPersonalBoard(Player player) {
		print(player.getName()+" has:");
		print(" ");
		printPersonalCards(player);
		printResources(player);
	}
	
	public static void printResources(Player player) {
	
		List<Resource> resources = player.getResources();
		print(player.getName()+" has:");
		resources.forEach(res -> print(res.getQuantity()+" "+res.getClass().getSimpleName()));
		print(" ");
	}

	public static void printPersonalCards(Player player) {
		
		DevelopmentCard[] tCards = DevelopmentCard.toArray(player.getCards(new TerritoryCard()));
		DevelopmentCard[] cCards = DevelopmentCard.toArray(player.getCards(new CharacterCard()));
		DevelopmentCard[] bCards = DevelopmentCard.toArray(player.getCards(new BuildingCard()));
		DevelopmentCard[] vCards = DevelopmentCard.toArray(player.getCards(new VentureCard()));
		printCards(tCards, cCards, bCards, vCards);
		print(" ");
	}
	
	public static void printDices(Dice bDice,Dice oDice,Dice wDice) {
		print("BLACK DICE: "+ bDice.getValue());
		print("ORANGE DICE: "+ oDice.getValue());
		print("WHITE DICE: "+ wDice.getValue());
		print(" ");
	}
}
