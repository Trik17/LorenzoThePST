package it.polimi.ingsw.GC_04.server;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import it.polimi.ingsw.GC_04.view.RMIView;
import it.polimi.ingsw.GC_04.view.RMIViewRemote;

public class Server {
	
	//Main class from the server side
	private static Server instance;
	public static final int SOCKET_PORT=1953;
	public static final int RMI_PORT = 12008;
	public static final String NAME = "lorenzo";
	private ClientManager clientManager;

	private Server() {
	}
	
	public static Server instance() throws RemoteException{
		if (instance == null) {
			instance = new Server();
		}
		return instance;
	}

	private void startRMI() throws RemoteException, AlreadyBoundException{

		//create the registry to publish remote objects
		Registry registry = LocateRegistry.createRegistry(RMI_PORT);
		System.out.println("Constructing the RMI registry");

		// Create the RMI View, that will be shared with the client
		RMIView rmiView=new RMIView(this.clientManager);
		
		/*  VA FATTO POI ALLA CREAZIONE DELLA SINGOLA RMIVIEW
		//controller observes this view
		rmiView.registerObserver(this.controller);
		
		//this view observes the model
		this.model.registerObserver(rmiView);  
		*/
		
		// publish the view in the registry as a remote object
		@SuppressWarnings("unused")
		RMIViewRemote viewRemote=(RMIViewRemote) UnicastRemoteObject.exportObject(rmiView, 0);
		
		System.out.println("Binding the server implementation to the registry");
		registry.bind(NAME, rmiView);
		
		
	}
	
	
	/*
	private void startSocket() throws IOException {

		// creates the thread pool to handle clients
		ExecutorService executor = Executors.newCachedThreadPool();

		//creats the socket
		ServerSocket serverSocket = new ServerSocket(SOCKET_PORT);

		System.out.println("SERVER SOCKET READY ON PORT" + SOCKET_PORT);

		while (true) {
			//Waits for a new client to connect
			Socket socket = serverSocket.accept();

			// creates the view (server side) associated with the new client
			ServerSocket view = new ServerSocket(socket, this.model);

			// the view observes the model
			this.model.registerObserver(view);

			// the controller observes the view
			view.registerObserver(this.controller);

			// a new thread handle the connection with the view
			executor.submit(view);
		}
	}*/

	public static void main(String[] args) throws IOException, AlreadyBoundException {
		Server server=Server.instance();
		instance.clientManager=new ClientManager();
		
		
		System.out.println("START RMI");
		server.startRMI();
		//System.out.println("START SOCKET");
		//server.startSocket();
	}
}

	

