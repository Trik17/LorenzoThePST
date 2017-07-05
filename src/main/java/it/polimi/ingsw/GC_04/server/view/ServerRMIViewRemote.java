package it.polimi.ingsw.GC_04.server.view;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

import it.polimi.ingsw.GC_04.client.view.ClientRMIViewRemote;

//defines the methods exposed to the clients. implemented by RMIView
public interface ServerRMIViewRemote extends Remote ,  Serializable {
	
	public void registerClient(ClientRMIViewRemote clientStub, String username) throws RemoteException;
	public void notifyObserversARemote(String action) throws RemoteException;
	public void notifyObserversRRemote(String privileges)throws RemoteException;
	
	
}
