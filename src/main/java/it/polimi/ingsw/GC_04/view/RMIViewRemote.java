package it.polimi.ingsw.GC_04.view;

import java.rmi.Remote;
import java.rmi.RemoteException;

import it.polimi.ingsw.GC_04.client.rmi.ClientViewRemote;
//defines the methods exposed to the clients. implemented by RMIView
public interface RMIViewRemote extends Remote{
	
	public void registerClient(ClientViewRemote clientStub) throws RemoteException;
	
	public void printModel() throws RemoteException;
	
	public void makeAction() throws RemoteException;
}
