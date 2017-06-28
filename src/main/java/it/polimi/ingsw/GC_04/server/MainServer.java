package it.polimi.ingsw.GC_04.server;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import it.polimi.ingsw.GC_04.view.ServerRMIView;
import it.polimi.ingsw.GC_04.view.ServerRMIViewRemote;

public class MainServer {
	
	//Main class from the server side
	private static MainServer instance;
	public static final int SOCKET_PORT=1953;private ClientManager clientManager;
	

	private MainServer() {
	}
	
	public static MainServer instance() throws RemoteException{
		if (instance == null) {
			instance = new MainServer();
		}
		return instance;
	}

	
	
	
	public static void main(String[] args) throws IOException, AlreadyBoundException {
		MainServer server=MainServer.instance();
		instance.clientManager=new ClientManager();
	}
}

	

