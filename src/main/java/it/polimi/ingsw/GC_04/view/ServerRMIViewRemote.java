package it.polimi.ingsw.GC_04.view;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

import it.polimi.ingsw.GC_04.client.ClientRMIViewRemote;
import it.polimi.ingsw.GC_04.controller.InputActionInterpreter;
import it.polimi.ingsw.GC_04.model.action.Action;

//defines the methods exposed to the clients. implemented by RMIView
public interface ServerRMIViewRemote extends Remote ,  Serializable {
	
	public void registerClient(ClientRMIViewRemote clientStub, String username) throws RemoteException;
	public void notifyObserversARemote(String action) throws RemoteException;
	public void notifyObserversRRemote(String privileges);
	
	
}
