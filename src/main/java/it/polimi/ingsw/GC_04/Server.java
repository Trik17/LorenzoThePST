package it.polimi.ingsw.GC_04;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import it.polimi.ingsw.GC_04.connection.Controller;
import it.polimi.ingsw.GC_04.connection.Server;

public class Server {

	//Main class from the server side
	private static Server instance;
	private Controller controller;
	public final static int SOCKET_PORT=19953;
	public final static int RMI_PORT = 172008;
	public static final String NAME = "lorenzo";

	private Model gioco;
	private Controller controller;

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
		RMIView rmiView=new RMIView();

		//controller observes this view
		rmiView.registerObserver(this.controller);

		//this view observes the model
		this.gioco.registerObserver(rmiView);

		// publish the view in the registry as a remote object
		RMIViewRemote viewRemote=(RMIViewRemote) UnicastRemoteObject.
				exportObject(rmiView, 0);
		
		System.out.println("Binding the server implementation to the registry");
		registry.bind(NAME, rmiView);

		
	}
	
	private void startSocket() throws IOException {

		// creates the thread pool to handle clients
		ExecutorService executor = Executors.newCachedThreadPool();

		//creats the socket
		ServerSocket serverSocket = new ServerSocket(PORT);

		System.out.println("SERVER SOCKET READY ON PORT" + PORT);

		while (true) {
			//Waits for a new client to connect
			Socket socket = serverSocket.accept();

			// creates the view (server side) associated with the new client
			ServerSocketView view = new ServerSocketView(socket, this.gioco);

			// the view observes the model
			this.gioco.registerObserver(view);

			// the controller observes the view
			view.registerObserver(this.controller);

			// a new thread handle the connection with the view
			executor.submit(view);
		}
	}

	public static void main(String[] args) throws IOException, AlreadyBoundException {
		Server server=Server.instance();
		System.out.println("START RMI");
		server.startRMI();
		System.out.println("START SOCKET");
		server.startSocket();
	}
}
