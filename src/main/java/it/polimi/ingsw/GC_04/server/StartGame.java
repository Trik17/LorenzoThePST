package it.polimi.ingsw.GC_04.server;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.databind.JsonMappingException;

import it.polimi.ingsw.GC_04.Initializer;
import it.polimi.ingsw.GC_04.client.rmi.ClientRMIViewRemote;
import it.polimi.ingsw.GC_04.client.rmi.ViewCLI;
import it.polimi.ingsw.GC_04.client.rmi.ViewClient;
import it.polimi.ingsw.GC_04.controller.Controller;
import it.polimi.ingsw.GC_04.model.Model;
import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.resource.Coins;

public class StartGame implements Runnable {//va messo il codice che sta in Main ->il controller deve avere ClientManager per poter fare getClients
	
	private Map<String,ClientRMIViewRemote> clients;
	private ClientRMIViewRemote[] viewClients;
	private Player[] players;
	private int turn=0; 
	private Model model;
	private Controller controller;
	//the real turn is (turn+1), 
	//the variable turn is also the index of players
	
	public StartGame(Map<String,ClientRMIViewRemote> clients, Model model, Controller controller) {
		this.clients=new HashMap<>(clients);
		this.players=new Player[clients.size()];
		this.viewClients=new ClientRMIViewRemote[clients.size()];
		this.model=model;
		this.controller=controller;
	}
	
	@Override
	public void run(){
		start();
	}
	
	private void start() {
		try {clients.forEach((username,stub)-> {
			players[turn]=new Player(username,turn+1);
			viewClients[turn]=stub;
			turn++;
		});
		}catch(Exception e){
			e.printStackTrace();
		}
		/*
		try {
			clients.get("a").getServerStub().notifyObserversRremote(new Coins(99));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		model.setPlayers(players);
		controller.setViews(viewClients);
		controller.initialize(players);		
		
	}
	
}
