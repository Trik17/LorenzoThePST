package it.polimi.ingsw.GC_04.client.rmi;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import it.polimi.ingsw.GC_04.view.RMIViewRemote;


public class ClientRMI {
	public final static int RMI_PORT = 12008;
	public final static String HOST = "localhost";
	public static final String NAME = "lorenzo";
	
	
	public void clientConnection() throws AccessException, RemoteException, NotBoundException{
		
		//Get the remote registry
		Registry registry = LocateRegistry.getRegistry(HOST, RMI_PORT);

		//get the stub (local object) of the remote view
		RMIViewRemote serverStub = (RMIViewRemote) registry.lookup(NAME);

		ClientRMIView rmiView=new ClientRMIView();

		// register the client view in the server side (to receive messages from the server)
		serverStub.registerClient(rmiView);
		
		//Scanner in = new Scanner(System.in);
		
		//ora si fa sempre serverStub.metodo che si trova su rmiviewremote
		
		

		
	}
	
}