package it.polimi.ingsw.GC_04.server;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.databind.JsonMappingException;

import it.polimi.ingsw.GC_04.Initializer;
import it.polimi.ingsw.GC_04.client.rmi.ClientViewRemote;
import it.polimi.ingsw.GC_04.client.rmi.ViewCLI;
import it.polimi.ingsw.GC_04.client.rmi.ViewClient;
import it.polimi.ingsw.GC_04.controller.Controller;
import it.polimi.ingsw.GC_04.model.Model;
import it.polimi.ingsw.GC_04.model.Player;

public class StartGame {//va messo il codice che sta in Main ->il controller deve avere ClientManager per poter fare getClients
	
	private Map<String,ClientViewRemote> clients;
	private Player[] players;
	private int turn=0; 
	//the real turn is (turn+1), 
	//the variable turn is also the index of players
	
	public StartGame(Map<String,ClientViewRemote> clients) {
		this.clients=new HashMap<>(clients);
		this.players=new Player[clients.size()];
		start();
	}

	private void start() {
		
		clients.forEach((username,stub)-> {
			players[turn]=new Player(username,turn+1);
			turn++;
		});
		
		Initializer initializer = new Initializer(players);
		Model model = new Model();
		model.setPlayers(players);
		
		
		//cancella
		System.out.println("siiiii ahahahha siiiiii");
		
		// le view devono essere ClientViewRemote
		ViewClient[] views =new ViewClient[clients.size()];
		//ClientViewRemote[] views=new ClientViewRemote[clients.size()];
		//for(int i=0; i<clients.size(); i++)
			//if(graphic)
				//views[i] = new ViewGUI();
			//else
				//views[i] = new ViewCLI();
		
		
		Controller controller=new Controller(model,initializer);
		controller.setViews(views);
		controller.startGame();
		
		
	}
	
	

	
}
