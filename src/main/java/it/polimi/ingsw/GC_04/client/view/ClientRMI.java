package it.polimi.ingsw.GC_04.client.view;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import it.polimi.ingsw.GC_04.server.view.ServerRMIViewRemote;


public class ClientRMI {
	public static final int RMI_PORT = 12008;
	public static final String HOST = "localhost";
	public static final String NAME = "lorenzo";
	private ServerRMIViewRemote serverStub;
	private ClientRMIView clientRmiView;
	private String username;
	private boolean gui=false;
	
	public ClientRMI(String username, boolean gui) throws RemoteException, NotBoundException {
		this.username=username;
		this.gui=gui;
		clientConnection();
	}
	
	public void clientConnection() throws RemoteException, NotBoundException{
		
		//Get the remote registry
		Registry registry = LocateRegistry.getRegistry(HOST, RMI_PORT);

		//get the stub (local object) of the remote view
		serverStub = (ServerRMIViewRemote) registry.lookup(NAME);

		this.clientRmiView=new ClientRMIView(username,this.gui);

		// register the client view in the server side to receive messages from the server (in ClientManager)
		serverStub.registerClient(clientRmiView,username);
			
	}
	
}