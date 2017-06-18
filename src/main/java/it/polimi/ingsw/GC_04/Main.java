package it.polimi.ingsw.GC_04;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import it.polimi.ingsw.GC_04.controller.Controller;
import it.polimi.ingsw.GC_04.model.ActionSpace;
import it.polimi.ingsw.GC_04.model.FamilyColor;
import it.polimi.ingsw.GC_04.model.Model;
import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.card.BuildingCard;
import it.polimi.ingsw.GC_04.model.card.CharacterCard;

import it.polimi.ingsw.GC_04.model.card.VentureCard;
import it.polimi.ingsw.GC_04.view.View;
import it.polimi.ingsw.GC_04.view.ViewCLI;
import it.polimi.ingsw.GC_04.view.ViewGUI;
import it.polimi.ingsw.GC_04.model.card.TerritoryCard;



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
			Player player1 = new Player(name, FamilyColor.BLUE, turn, 1);
			players[turn] = player1;
			turn++;
		case 3:
			print("Player RED inserisci il tuo nome");
			name = in.nextLine();
			Player player2 = new Player(name, FamilyColor.RED, turn,2);
			players[turn] = player2;
			turn++;
		case 2:
			print("Player GREEN inserisci il tuo nome");
			name = in.nextLine();
			Player player3 = new Player(name, FamilyColor.GREEN, turn,3);
			players[turn] = player3;
			turn++;
			
			print("Player YELLOW inserisci il tuo nome");
			name = in.nextLine();
			Player player4 = new Player(name, FamilyColor.YELLOW, turn,4 );
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
				
		Inizializer inizializer = new Inizializer(players);
		Model model = new Model();
		model.setPlayers(players);
		View[] views =new View[num];
		for(int i=0; i<num; i++)
			if(graphic)
				views[i] = new ViewGUI();
			else
				views[i] = new ViewCLI();
		
		Controller controller=new Controller(model);
		controller.setViews(views);
		controller.startGame();
		
		
		
		
	
		
		}
	
	
}


