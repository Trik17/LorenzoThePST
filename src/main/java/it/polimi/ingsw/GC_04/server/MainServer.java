package it.polimi.ingsw.GC_04.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import it.polimi.ingsw.GC_04.client.view.ClientRMIViewRemote;
import it.polimi.ingsw.GC_04.server.controller.Controller;
import it.polimi.ingsw.GC_04.server.controller.JsonMapper;
import it.polimi.ingsw.GC_04.server.model.Model;
import it.polimi.ingsw.GC_04.server.timer.TimerJson;
import it.polimi.ingsw.GC_04.server.view.ServerRMIView;
import it.polimi.ingsw.GC_04.server.view.ServerRMIViewRemote;
import it.polimi.ingsw.GC_04.server.view.ServerSocketView;

public class MainServer implements Runnable{
	private Map<String,ClientRMIViewRemote> clientsRMI;
	private Map<String, ServerSocketView> clientsSocket;
	private Map<String,ClientRMIViewRemote> lastClientsRMI; //clients that are waiting for a match
	private Map<String, ServerSocketView> lastClientsSocket;
	private List<String> disconnectedPlayers;
	private Map<String,StartGame> games; //associations beetween games and players
	private boolean timerStarted=false;
	public static final int SOCKET_PORT = 17000;
	public static final int RMI_PORT = 12008;
	public static final String NAME = "lorenzo";
	private ExecutorService executor;
	private Model currentModel;
	private Controller currentController;
	private Timer timer;
	private TimerTask task; 
	private static MainServer instance;
	private ServerSocket serverSocket;	
	
	
	
	/*
	 * this is the timer that starts the countdown (to start a match) 
	 * when two players connect to the server 
	 */
	private void newTimer(){
		this.timer=new Timer();
		this.task= new TimerTask(){
	    	public void run(){
	        	System.out.println( "Time out: starting the game" );
	        	timerStarted=false;
	        	startGame();
	        	timer.cancel();
	        }    
	    };
	}
	/*
	 * the MainServer is implemented using the Singleton design pattern
	 */
	public static MainServer instance() {
		if (instance == null) {
			instance = new MainServer();
		}
		return instance;
	}
	

	
	public synchronized Map<String,ClientRMIViewRemote> getClients(){
		return this.clients; 
	} 
	
	private MainServer() {
		this.disconnectedPlayers=new ArrayList<>();
		this.clientsRMI=new HashMap<>();
		this.games=new HashMap<>();
		this.lastClientsRMI=new HashMap<>();
		this.clientsSocket=new HashMap<>();
		this.lastClientsSocket=new HashMap<>();
		this.currentModel=new Model();
		this.currentController=new Controller(currentModel,this);
		this.executor = Executors.newCachedThreadPool();
		JsonMapper.TimerFromJson();//inizialize the timer from json file	
		try {
			System.out.println("STARTING RMI");
			startRMI();
			System.out.println("STARTING SOCKET");
			executor.submit(this);
		} catch (RemoteException | AlreadyBoundException e) {
			e.printStackTrace();
		}
	}
    /* at the connection this function controll the client's username,
	 * if the client is new the function add it to the Maps of clients connected,
	 */ 
	public synchronized void addRMIClient(ClientRMIViewRemote clientStub, String username, ServerRMIView rmiView) throws RemoteException{
		if(clientsRMI.containsKey(username)){
			if(disconnectedPlayers.contains(username)){
				games.get(username).reconnectPlayer(username);
				disconnectedPlayers.remove(username);
				return;
			}else{
				clientStub.usernameAlreadyUsed();
				return;
			}
		}
		this.clientsRMI.put(username,clientStub);
		this.lastClientsRMI.put(username,clientStub);
		//controller observes this view
		rmiView.registerObserver(this.currentController);
		try {
			clientStub.addServerstub(rmiView);
		} catch (RemoteException e) {
			this.clientsRMI.remove(username,clientStub);
			this.lastClientsRMI.remove(username,clientStub);
			return;
		}
		System.out.println("new client connected with RMI");
		checkPlayers();
	}
	
	public synchronized Map<String,ClientRMIViewRemote> getClients(){
		return this.clientsRMI; 
	} 
	
	/*
	 * it checks the number of the players in lastClients (clients waiting to start a match) and 
	 * if clients.size()==4 it starts a new game  
	 * or a timer that will start the game if no others players connect before the given time
	 */
	private synchronized void checkPlayers() {
		int numOfClients=lastClientsRMI.size() + lastClientsSocket.size();
		System.out.println("Number of new Clients:"+ numOfClients);
		if(numOfClients<2)
			return;
		if(numOfClients==4){
			timer.cancel();
			startGame();			
		}			
		if(timerStarted)
			return;
		else{
			timerStarted=true;
			newTimer();
			timer.schedule(task, TimerJson.getStartTimer());
		}		
	}	
	
	//it starts the new game and creates a new controller and model for future clients
	private synchronized void startGame(){
		System.out.println("Starting a new game:");	
		StartGame game=new StartGame(this.lastClientsRMI,this.lastClientsSocket,this.currentModel,this.currentController);//va dato in pasto ad un thread
		executor.submit(game);
		lastClientsRMI.forEach((username,stub) -> games.put(username, game));
		lastClientsSocket.forEach((username,stub) -> games.put(username, game));
		this.lastClientsRMI.clear();
		this.lastClientsSocket.clear();
		this.currentModel=new Model();
		this.currentController=new Controller(currentModel,this);
	}
	
	private void startRMI() throws RemoteException, AlreadyBoundException{

		//create the registry to publish remote objects
		Registry registry = LocateRegistry.createRegistry(RMI_PORT);
		System.out.println("Constructing the RMI registry");

		// Create the RMI View, that will be shared with the client
		ServerRMIView rmiView=new ServerRMIView(this);
				
		// publish the view in the registry as a remote object
		@SuppressWarnings("unused")
		ServerRMIViewRemote viewRemote=(ServerRMIViewRemote) UnicastRemoteObject.exportObject(rmiView, 0);
		
		System.out.println("Binding the server implementation to the registry");
		registry.bind(NAME, rmiView);
		System.out.println("RMI is ready to accept clients");
		
	}
	
	public synchronized void disconnectPlayer(String username){
		this.disconnectedPlayers.add(username);
	}
	
	public static void main(String[] args){
		MainServer.instance();
	}
	
	//Start Socket:
	@Override
	public void run() {
		try {
			//creats the socket					
			serverSocket = new ServerSocket(SOCKET_PORT);	
			System.out.println("SERVER SOCKET READY ON PORT" + SOCKET_PORT);
	
			while (true) {
				//Waits for a new client to connect
				Socket socket = serverSocket.accept();
	
				// creates the view (server side) associated with the new client
				ServerSocketView viewSocket = new ServerSocketView(socket, this.currentController,this);
				
				// the controller observes the view
				viewSocket.registerObserver(this.currentController);
											
				// a new thread handle the connection with the view
				executor.submit(viewSocket);
			}
		} catch (IOException e) {
			try {
				serverSocket.close();
			} catch (IOException e1) {
				System.out.println("ServerSocket closed");
			}
		}		
	}
	public void addSocketClient(String username, ServerSocketView serverSocketView) {
		clientsSocket.put(username, serverSocketView);
		lastClientsSocket.put(username, serverSocketView);

		System.out.println("new client connected with Socket");

		checkPlayers();
		/*TODO
		 if(clientsRMI.containsKey(username)){
			if(disconnectedPlayers.contains(username)){
				games.get(username).reconnectPlayer(username);
				disconnectedPlayers.remove(username);
				return;
			}else{
				clientStub.usernameAlreadyUsed();
				return;
			}
		}
		 */
	}	
}