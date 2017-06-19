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
	
	TimerTask task = new TimerTask(){
    	public void run(){
        	System.out.println( "Time out: starting the game" );
        	//avviare startGame()
				
        }    
    };
	
	public ClientManager() throws JsonMappingException, IOException {
		this.clients=new HashSet<ClientViewRemote>();
		JsonMapper.TimerFromJson();//inizialize the timer from json file
		
		
	}

	public Set<ClientViewRemote> getClients(){
		return this.clients;
	}
	
	public synchronized void addClient(ClientViewRemote clientStub){
		this.clients.add(clientStub);
		checkPlayers();
		//controlla giocatori
		//username devono essere diversi
		//vedi se devi iniziare timer o avviare la partita
	}
	
	private synchronized void checkPlayers() {
		//TODO inserisci pure il timer
		if(clients.size()<2)
			return;
		if(clients.size()==4){
			startGame();
			timer.cancel();
		}			
		if(timerStarted)
			return;
		else{
			timer=new Timer();
			timer.schedule(task, TimerJson.getStartTimer());
		}
		
		//start timer e metti a true la variabile timerstarted
				
		
	}
	
	
	
	
	private void newGame(){
		//TODO crea un nuovo gestore per le nuove connessioni
	}

	private void startGame(){
		newGame();
		System.out.println("Starting a new game:");
		
		
	}
	
	
	
}
