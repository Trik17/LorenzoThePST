package it.polimi.ingsw.GC_04.server;

import java.util.HashMap;
import java.util.Map;
import it.polimi.ingsw.GC_04.client.view.ClientRMIViewRemote;
import it.polimi.ingsw.GC_04.server.controller.Controller;
import it.polimi.ingsw.GC_04.server.model.Model;
import it.polimi.ingsw.GC_04.server.model.Player;
import it.polimi.ingsw.GC_04.server.view.ServerSocketView;

public class StartGame implements Runnable {
	
	private Map<String,ClientRMIViewRemote> clientsRMI;
	private Map<String, ServerSocketView> clientsSocket;
	private Player[] players;
	private int turn=0; 
	private Model model;
	private Controller controller;
	//the real turn is (turn+1), 
	//the variable turn is also the index of players
	
	public StartGame(Map<String,ClientRMIViewRemote> clientsRMI, Map<String, ServerSocketView> clientsSocket, Model model, Controller controller) {
		this.clientsRMI=new HashMap<>(clientsRMI);
		this.clientsSocket=new HashMap<>(clientsSocket);
		int numOfPlayers=clientsRMI.size()+clientsSocket.size();
		this.players=new Player[numOfPlayers];
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
		try {
			clientsRMI.forEach((username,stub)-> {
				players[turn]=new Player(username,turn+1);
				turn++;
			});
			
			clientsSocket.forEach((username,stub)-> {
				players[turn]=new Player(username,turn+1);
				turn++;
			});
		}catch(Exception e){
			e.printStackTrace();
		}
		model.setPlayers(players);
		controller.setViews(clientsRMI,clientsSocket); 
		controller.initialize(players);	
		
		
	}
	
}
