package it.polimi.ingsw.GC_04.client.rmi;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
//implements ClientViewRemote interface
public class ClientRMIView extends UnicastRemoteObject implements ClientViewRemote, Serializable {
	
	protected ClientRMIView() throws RemoteException {
		super();
	}

}