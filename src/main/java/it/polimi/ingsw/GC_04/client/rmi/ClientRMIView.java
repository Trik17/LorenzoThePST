package it.polimi.ingsw.GC_04.client.rmi;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
//implements ClientViewRemote interface
public class ClientRMIView extends UnicastRemoteObject implements ClientViewRemote, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9164262648865618843L;

	protected ClientRMIView() throws RemoteException {
		super();
	}
	
	

}