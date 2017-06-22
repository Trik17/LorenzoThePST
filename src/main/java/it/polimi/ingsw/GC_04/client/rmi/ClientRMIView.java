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
//mi manca qua il serverstub!!
	
	
	protected ClientRMIView(String username) throws RemoteException {
		super();
		this.username=username;
		this.view=new ViewCLI();
	}
	@Override
	public void askSomething(String a) throws RemoteException{
		System.out.println("0000");
		if (a.equalsIgnoreCase("ciao"))
			System.out.println("mi hai salutato");
		else
			System.out.println("chi sa che cosa hai scritto");
		
	}
	@Override
	public String getUsername() throws RemoteException {
		return this.username;		
	}
	
	

}