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
	private final String username; 
	private ViewClient view;

	protected ClientRMIView(String username) throws RemoteException {
		super();
		this.username=username;
		this.view=new ViewCLI();
	}
	
	
	@Override
	public String getUsername() throws RemoteException {
		return this.username;		
	}
	
	

}