package it.polimi.ingsw.GC_04.server;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import com.fasterxml.jackson.databind.JsonMappingException;

import it.polimi.ingsw.GC_04.JsonMapper;
import it.polimi.ingsw.GC_04.client.rmi.ClientViewRemote;
import it.polimi.ingsw.GC_04.timer.TimerJson;
//bisogna controllare che sia ancora connesso ogni volta che si comunica con il client
public class ClientManager {
	private Map<String,ClientViewRemote> clients;
	private Map<String,ClientViewRemote> lastClients; //clients that are waiting for a match
	private Map<String,StartGame> games;
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
		this.clients=new HashMap<>();
		this.games=new HashMap<>();
		this.lastClients=new HashMap<>();
		JsonMapper.TimerFromJson();//inizialize the timer from json file		
	}

	public synchronized void addClient(ClientViewRemote clientStub, String username){
		if(clients.containsKey(username)){
			//chiedere un altro username
		}
		this.clients.put(username,clientStub);
		this.lastClients.put(username,clientStub);
		checkPlayers();
		//controlla giocatori
		//username devono essere diversi
	}
	
	public Map<String,ClientViewRemote> getClients(){
		return this.clients; 
	} 
	
	private synchronized void checkPlayers() {
		if(lastClients.size()<2)
			return;
		if(lastClients.size()==4){
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
	
	
	private synchronized void startGame(){
		System.out.println("Starting a new game:");	
		StartGame game=new StartGame(this.lastClients);//va dato in pasto ad un thread
		lastClients.forEach((username,stub) -> games.put(username, game));
		this.lastClients.clear();
	}
	
	
}
