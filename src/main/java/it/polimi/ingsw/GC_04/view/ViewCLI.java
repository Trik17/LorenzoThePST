package it.polimi.ingsw.GC_04.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import it.polimi.ingsw.GC_04.Inizializer;
import it.polimi.ingsw.GC_04.controller.Controller;
import it.polimi.ingsw.GC_04.model.ActionSpace;
import it.polimi.ingsw.GC_04.model.FamilyColor;
import it.polimi.ingsw.GC_04.model.Model;
import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.card.BuildingCard;
import it.polimi.ingsw.GC_04.model.card.CharacterCard;

import it.polimi.ingsw.GC_04.model.card.VentureCard;
import it.polimi.ingsw.GC_04.model.card.TerritoryCard;



public class ViewCLI {
	
	public static void print(String string) {
		System.out.println(string);
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int num = 4;
		int turn = 0;
		String name;
		print("Inserisci numero di giocatori");
		String nrOfPlayers = in.nextLine();
		
		try {
			num = Integer.parseInt(nrOfPlayers);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Player[] players = new Player[num];
		
		switch (num) {
		case 4:
			print("Player BLUE inserisci il tuo nome");
			name = in.nextLine();
			Player player1 = new Player(name, FamilyColor.BLUE, turn);
			players[turn] = player1;
			turn++;
		case 3:
			print("Player RED inserisci il tuo nome");
			name = in.nextLine();
			Player player2 = new Player(name, FamilyColor.RED, turn);
			players[turn] = player2;
			turn++;
		case 2:
			print("Player GREEN inserisci il tuo nome");
			name = in.nextLine();
			Player player3 = new Player(name, FamilyColor.GREEN, turn);
			players[turn] = player3;
			turn++;
			
			print("Player YELLOW inserisci il tuo nome");
			name = in.nextLine();
			Player player4 = new Player(name, FamilyColor.YELLOW, turn);
			players[turn] = player4;
			turn = 0;
			break;
		default:
			throw new IOException();
		}
		
		//queste inizializzazioni sono solo per far compilare
		TerritoryCard[] tCards = new TerritoryCard[16];
		BuildingCard[] bCards = new BuildingCard[16];
		CharacterCard[] cCards = new CharacterCard[16];
		VentureCard[] vCards = new VentureCard[16];
		List<ActionSpace> aSpaces = new ArrayList<ActionSpace>();
		
		Inizializer inizializer = new Inizializer(players, tCards, bCards, cCards, vCards, aSpaces);
		Model game = new Model(players);
		Input view =new Input(game);
		Controller controller=new Controller(game, view);
		
		while(true){
			print(players[turn].getName()+" scegli un'area tra TOWER, PRODUCTION, HARVEST, MARKET, COUNCIL PALACE");
			String area = in.nextLine();
			if (area.equalsIgnoreCase("TOWER")) {
				print("Scegli la torre tra TERRITORY, BUILDING, VENTURE, CHARACTER");
				String tower = in.nextLine();
				print("Scegli la carta tra 1, 2, 3, 4");
				String nrOfCard = in.nextLine();
				print("Scegli il dado che vuoi usare tra BLACK, ORANGE, WHITE, NEUTRAL");
				String diceColor = in.nextLine();
				print("Quanti servants vuoi usare per questa mossa?");
				String nrOfServants = in.nextLine();
				print("Scegli, se previsto, quale costo vuoi pagare per questa carta tra 1, 2");
				print("Se non è prevista una scelta premi 1");
				String cost = in.nextLine();
				view.input(tower, nrOfCard, diceColor, nrOfServants, cost);
			}
			if (area.equalsIgnoreCase("MARKET")) {
				print("Scegli il dado che vuoi usare tra BLACK, ORANGE, WHITE, NEUTRAL");
				String diceColor = in.nextLine();
				print("Scegli lo shop tra 1, 2, 3, 4"); //in realtà di pende dal numero di giocatori
				String actSpace = in.nextLine();
				print("Quanti servants vuoi usare per questa mossa?");
				String nrOfServants = in.nextLine();
				view.input(area, diceColor, actSpace, nrOfServants);
			}else {
				print("Scegli il dado che vuoi usare tra BLACK, ORANGE, WHITE, NEUTRAL");
				String diceColor = in.nextLine();
				print("Quanti servants vuoi usare per questa mossa?");
				String nrOfServants = in.nextLine();
				view.input(area, diceColor, nrOfServants);	
			}
		
		}
	}
	
}


