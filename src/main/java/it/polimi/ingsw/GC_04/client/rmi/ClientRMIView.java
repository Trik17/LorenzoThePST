package it.polimi.ingsw.GC_04.client.rmi;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientRMIView extends UnicastRemoteObject implements ClientViewRemote, Serializable {
	
	protected ClientRMIView() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}


}
