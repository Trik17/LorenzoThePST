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
	private Map<String,ClientRMIViewRemote> clients;
	private Map<String,ClientRMIViewRemote> lastClients; //clients that are waiting for a match
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
	
	
	
	
	//this is the timer that starts the countdown (to start a match) when two players connect to the server 
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
	public static MainServer instance() {
		if (instance == null) {
			instance = new MainServer();
		}
		return instance;
	}
	
	private MainServer() {
		this.disconnectedPlayers=new ArrayList<>();
		this.clients=new HashMap<>();
		this.games=new HashMap<>();
		this.lastClients=new HashMap<>();
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

	
	public synchronized void addRMIClient(ClientRMIViewRemote clientStub, String username, ServerRMIView rmiView) throws RemoteException{
		if(clients.containsKey(username)){
			if(disconnectedPlayers.contains(username)){
				games.get(username).reconnectPlayer(username);
				disconnectedPlayers.remove(username);
				return;
			}else{
				clientStub.changeUsername(this.clients.keySet());
				return;
			}
		}
		this.clients.put(username,clientStub);
		this.lastClients.put(username,clientStub);
		//controller observes this view
		rmiView.registerObserver(this.currentController);
		try {
			clientStub.addServerstub(rmiView);
		} catch (RemoteException e) {
			this.clients.remove(username,clientStub);
			this.lastClients.remove(username,clientStub);
			return;
		}
		System.out.println("new client connected");
		checkPlayers();
	}
	
	public synchronized Map<String,ClientRMIViewRemote> getClients(){
		return this.clients; 
	} 
	
	private synchronized void checkPlayers() {
		System.out.println("Number of new Clients:"+ lastClients.size());
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
			newTimer();
			timer.schedule(task, TimerJson.getStartTimer());
		}		
	}	
	
	
	private synchronized void startGame(){
		System.out.println("Starting a new game:");	
		StartGame game=new StartGame(this.lastClients,this.currentModel,this.currentController);//va dato in pasto ad un thread
		executor.submit(game);
		lastClients.forEach((username,stub) -> games.put(username, game));
		this.lastClients.clear();
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
//		try {
//			//creats the socket
//					
//			serverSocket = new ServerSocket(SOCKET_PORT);	
//			System.out.println("SERVER SOCKET READY ON PORT" + SOCKET_PORT);
//	
//			while (true) {
//				//Waits for a new client to connect
//				Socket socket = serverSocket.accept();
//	
//				// creates the view (server side) associated with the new client
//				ServerSocketView view = new ServerSocketView(socket, this.currentController);
//	
//				// the controller observes the view
//				view.registerObserver(this.currentController);
//	
//				// a new thread handle the connection with the view
//				executor.submit(view);
//			}
//		} catch (IOException e) {
//			executor.submit(this);
//		}		
	}	
}