package it.polimi.ingsw.GC_04.view;

import java.rmi.Remote;
import java.rmi.RemoteException;

import it.polimi.ingsw.GC_04.Observer;
import it.polimi.ingsw.GC_04.client.rmi.ClientRMIViewRemote;
import it.polimi.ingsw.GC_04.model.resource.Resource;
//defines the methods exposed to the clients. implemented by RMIView
public interface ServerRMIViewRemote extends Remote{
	
	public void registerClient(ClientRMIViewRemote clientStub, String username) throws RemoteException;
	public void notifyObserversRremote(Resource resource)  throws RemoteException;
}
