package it.polimi.ingsw.GC_04.server;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import com.fasterxml.jackson.databind.JsonMappingException;

import it.polimi.ingsw.GC_04.JsonMapper;
import it.polimi.ingsw.GC_04.client.rmi.ClientViewRemote;
import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.timer.TimerJson;
//bisogna controllare che sia ancora connesso ogni volta che si comunica con il client
public class ClientManager {
	private Set<ClientViewRemote> clients;
	//private boolean isStarted;
	private boolean timerStarted=false;
	private Timer timer;
	
	
	//this is the timer that starts the countdown (to start a match) when two players connect to the server 
	TimerTask task = new TimerTask(){
    	public void run(){
        	System.out.println( "Time out: starting the game" );
        	startGame();	
        }    
    };
	
	public ClientManager() throws JsonMappingException, IOException {
		this.clients=new HashSet<ClientViewRemote>();
		JsonMapper.TimerFromJson();//inizialize the timer from json file		
	}

	public synchronized void addClient(ClientViewRemote clientStub){
		this.clients.add(clientStub);
		checkPlayers();
		//controlla giocatori
		//username devono essere diversi
	}
	
	public Set<ClientViewRemote> getClients(){
		return this.clients; 
	} 
	
	private synchronized void checkPlayers() {
		if(clients.size()<2)
			return;
		if(clients.size()==4){
			timer.cancel();
			startGame();			
		}			
		if(timerStarted)
			return;
		else{
			timerStarted=true;
			timer=new Timer();
			timer.schedule(task, TimerJson.getStartTimer());
		}		
	}	
	
	
	private synchronized void newGame(){
		//TODO crea un nuovo gestore per le nuove connessioni
	}

	private synchronized void startGame(){
		newGame();
		System.out.println("Starting a new game:");	
		int nPlayers =clients.size();
		
		//va messo il codice che sta in Main ->il controller deve avere ClientManager per poter fare getClients
	}
	
	
	
}
