package it.polimi.ingsw.GC_04.view;

import java.io.Serializable;
import java.rmi.RemoteException;

import it.polimi.ingsw.GC_04.Observable;
import it.polimi.ingsw.GC_04.client.rmi.ClientRMIViewRemote;
import it.polimi.ingsw.GC_04.model.action.Action;
import it.polimi.ingsw.GC_04.model.resource.Resource;
import it.polimi.ingsw.GC_04.server.ClientManager;


// implements the methods. Given that this example is implemented using the Observer pattern, each methods only calls to
//notify() with the corresponding action. The controller that is observing the view will be notified and translate this in
//actual actions upon the model.
public class ServerRMIView extends Observable<Action,Resource> implements ServerRMIViewRemote, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -225339130175226319L;
	private ClientManager clientManager;
	
	public ServerRMIView(ClientManager clientManager) {
		this.clientManager=clientManager;
	}
	
	
	@Override
	public synchronized void registerClient(ClientRMIViewRemote clientStub, String username) throws RemoteException {
		this.clientManager.addRMIClient(clientStub, username,this);
				
	}
	@Override
	public void notifyObserversA(Action action) {
		System.out.println("dentro server rmi view notifyobserver action");
		notifyObserversA(action);
		
	}


//	@Override
//	public void notifyObserversRremote(Resource resource) throws RemoteException  {
//		notifyObserversR(resource);
//		
//	}


}
