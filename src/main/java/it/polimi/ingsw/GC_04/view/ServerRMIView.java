package it.polimi.ingsw.GC_04.view;

import java.io.Serializable;
import java.rmi.RemoteException;

import it.polimi.ingsw.GC_04.Observable;
import it.polimi.ingsw.GC_04.client.ClientRMIViewRemote;
import it.polimi.ingsw.GC_04.model.resource.Resource;
import it.polimi.ingsw.GC_04.server.MainServer;


// implements the methods. Given that this example is implemented using the Observer pattern, each methods only calls to
//notify() with the corresponding action. The controller that is observing the view will be notified and translate this in
//actual actions upon the model.
public class ServerRMIView extends Observable<String,Resource> implements ServerRMIViewRemote, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -225339130175226319L;
	private MainServer clientManager;
	
	public ServerRMIView(MainServer clientManager) {
		this.clientManager=clientManager;
	}
	
	
	@Override
	public synchronized void registerClient(ClientRMIViewRemote clientStub, String username) throws RemoteException {
		this.clientManager.addRMIClient(clientStub, username,this);
				
	}
	@Override
	public void notifyObserversARemote(String action)  throws RemoteException {
		notifyObserversA(action);
		
	}


	@Override
	public void notifyObserversRRemote(String resource) throws RemoteException{
		notifyObserversR(resource);
		
	}


}
