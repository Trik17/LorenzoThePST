package it.polimi.ingsw.GC_04.client.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;


//is the remote interface of the client to receive and show data from the server through RMI.
public interface ClientViewRemote extends Remote {
	
	public String getUsername() throws RemoteException;

	public void askSomething(String string) throws RemoteException;
	
	
	
	
}