package it.polimi.ingsw.GC_04.server.view;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import it.polimi.ingsw.GC_04.client.view.ClientRMIViewRemote;
import it.polimi.ingsw.GC_04.server.MainServer;
import it.polimi.ingsw.GC_04.server.controller.Observable;
import it.polimi.ingsw.GC_04.server.model.resource.Resource;


// implements the methods. Given that this example is implemented using the Observer pattern, each methods only calls to
//notify() with the corresponding action. The controller that is observing the view will be notified and translate this in
//actual actions upon the model.
public class ServerRMIView extends Observable<String,Resource> implements ServerRMIViewRemote, Serializable, Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -225339130175226319L;
	private MainServer clientManager;
	private ExecutorService executor;
	private String resource;
	
	public ServerRMIView(MainServer clientManager) {
		this.clientManager=clientManager;
		this.executor = Executors.newCachedThreadPool();
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
		this.resource=resource;
		//TODO devo mettere get e setter syncronized su resource?
		executor.submit(this);
		
	}


	@Override
	public void run() {
		notifyObserversR(resource);
		
	}


}
