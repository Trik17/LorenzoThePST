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
import it.polimi.ingsw.GC_04.view.ViewHandler;

public class StartGame implements Runnable {//va messo il codice che sta in Main ->il controller deve avere ClientManager per poter fare getClients
	
	private Map<String,ClientViewRemote> clients;
	private ClientViewRemote[] viewClients;
	private Player[] players;
	private int turn=0; 
	private Model model;
	private Controller controller;
	//the real turn is (turn+1), 
	//the variable turn is also the index of players
	
	public StartGame(Map<String,ClientViewRemote> clients, Model model, Controller controller) {
		this.clients=new HashMap<>(clients);
		this.players=new Player[clients.size()];
		this.viewClients=new ClientViewRemote[clients.size()];
		this.model=model;
		this.controller=controller;
	}
	
	@Override
	public void run(){
		start();
	}
	
	private void start() {
		System.out.println("aaaaaaaaaaaa 1111111");// cancella
		clients.forEach((username,stub)-> {
			players[turn]=new Player(username,turn+1);
			turn++;
			viewClients[turn]=stub;
		});
		System.out.println("aaaaaaaaaa 2222222222");// cancella
		
		Model model = new Model();
		model.setPlayers(players);
		
		
		System.out.println("aaaaaaaaaaa  33333333");//cancella
		
		// le view devono essere ClientViewRemote
//		ViewClient[] views =new ViewClient[clients.size()];
		
		
		
		Controller controller=new Controller(model);
		controller.setViews(viewClients);
		controller.initialize(players);
		
		
	}
	
	

	
}
