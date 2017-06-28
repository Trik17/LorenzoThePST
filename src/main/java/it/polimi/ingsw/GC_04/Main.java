package it.polimi.ingsw.GC_04;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import it.polimi.ingsw.GC_04.client.StateOfTheGameCLI;
import it.polimi.ingsw.GC_04.client.ViewCLI;
import it.polimi.ingsw.GC_04.client.ViewClient;
import it.polimi.ingsw.GC_04.controller.Controller;

import it.polimi.ingsw.GC_04.model.Model;
import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.area.BuildingTower;
import it.polimi.ingsw.GC_04.model.area.CharacterTower;
import it.polimi.ingsw.GC_04.model.area.TerritoryTower;
import it.polimi.ingsw.GC_04.model.area.VentureTower;
import it.polimi.ingsw.GC_04.model.resource.Coins;
import it.polimi.ingsw.GC_04.model.resource.MilitaryPoints;
import it.polimi.ingsw.GC_04.model.resource.Resource;
import it.polimi.ingsw.GC_04.model.resource.Servants;
import it.polimi.ingsw.GC_04.model.resource.Stones;
import it.polimi.ingsw.GC_04.model.resource.Woods;




public class Main {
	public static void print(String string) {
		System.out.println(string);
	}
	

	public static void main(String[] args) throws IOException {
		
		//prendiamo i giocatori dalla rete
		//per ora li mettiamo qua per fare prove:
		//i colori li da il server in ordine
		// turni: a partire da 1
		
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
		case 4://se giochiamo con meno di 4 player non funziona
			print("Player BLUE inserisci il tuo nome");
			name = in.nextLine();
			Player player1 = new Player(name, turn+1);
			players[turn] = player1;
			turn++;
		case 3:
			print("Player RED inserisci il tuo nome");
			name = in.nextLine();
			Player player2 = new Player(name, turn+1);
			players[turn] = player2;
			turn++;
		case 2:
			print("Player GREEN inserisci il tuo nome");
			name = in.nextLine();
			Player player3 = new Player(name, turn+1);
			players[turn] = player3;
			turn++;
			
			print("Player YELLOW inserisci il tuo nome");
			name = in.nextLine();
			Player player4 = new Player(name, turn+1);
			players[turn] = player4;
			turn = 0;
			break;
		default:
			throw new IOException();
		}
		
		//scelta cli->false o gui->true
		boolean graphic;
		graphic=false;//poi mettere scelta
		//fine da cancellare
				
		Initializer initializer = new Initializer(players);
		StateOfTheGameCLI.printCards(TerritoryTower.instance().getCards(), CharacterTower.instance().getCards(), BuildingTower.instance().getCards(), VentureTower.instance().getCards());
		Model model = new Model();
		model.setPlayers(players);
		ViewClient[] views =new ViewClient[num];
		/*for(int i=0; i<num; i++)
			//if(graphic)
				//views[i] = new ViewGUI();
			//else
				views[i] = new ViewCLI();
		*/
//		Controller controller=new Controller(model,initializer);
//		controller.setViews(views);
//		controller.startGame();
		
		
		
		
	
		
		}
	
	
}


