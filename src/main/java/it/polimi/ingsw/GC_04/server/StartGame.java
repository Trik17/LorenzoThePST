package it.polimi.ingsw.GC_04.server;

import java.util.HashMap;
import java.util.Map;
import it.polimi.ingsw.GC_04.client.view.ClientRMIViewRemote;
import it.polimi.ingsw.GC_04.server.controller.Controller;
import it.polimi.ingsw.GC_04.server.model.Model;
import it.polimi.ingsw.GC_04.server.model.Player;

public class StartGame implements Runnable {
	
	private Map<String,ClientRMIViewRemote> clients;
	private Player[] players;
	private int turn=0; 
	private Model model;
	private Controller controller;
	//the real turn is (turn+1), 
	//the variable turn is also the index of players
	
	public StartGame(Map<String,ClientRMIViewRemote> clients, Model model, Controller controller) {
		this.clients=new HashMap<>(clients);
		this.players=new Player[clients.size()];
		this.model=model;
		this.controller=controller;
	}
	
	@Override
	public void run(){
		start();
	}
	
	public void reconnectPlayer(String username){
		this.controller.reconnect(username);
	}
	
	private void start() {
		try {clients.forEach((username,stub)-> {
			players[turn]=new Player(username,turn+1);
			turn++;
		});
		}catch(Exception e){
			e.printStackTrace();
		}
		model.setPlayers(players);
		controller.setViews(clients);
		controller.initialize(players);	
		
		
	}
	
}
