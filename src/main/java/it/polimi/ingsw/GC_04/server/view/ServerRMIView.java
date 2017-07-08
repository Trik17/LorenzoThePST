package it.polimi.ingsw.GC_04.server.view;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

import it.polimi.ingsw.GC_04.client.view.ClientRMIViewRemote;
import it.polimi.ingsw.GC_04.server.MainServer;
import it.polimi.ingsw.GC_04.server.controller.Observable;


// implements the methods. Given that this example is implemented using the Observer pattern, each methods only calls to
//notify() with the corresponding action. The controller that is observing the view will be notified and translate this in
//actual actions upon the model.
public class ServerRMIView extends Observable<String> implements ServerRMIViewRemote, Serializable, Runnable {
	
	private static final long serialVersionUID = -225339130175226319L;
	private MainServer clientManager;
	private ExecutorService executor;
	private String resource;
	private String action;
	private AtomicBoolean updateType;//true is for notifyObserversARemote; false is for notifyObserversRRemote
	
	public ServerRMIView(MainServer clientManager) {
		this.clientManager=clientManager;
		this.executor = Executors.newCachedThreadPool();
		updateType=new AtomicBoolean(true);
	}
	
	
	@Override
	public synchronized void registerClient(ClientRMIViewRemote clientStub, String username) throws RemoteException {
		this.clientManager.addRMIClient(clientStub, username,this);
				
	}
	@Override
	public void notifyObserversARemote(String action)  throws RemoteException {
		this.action=action;
		updateType.set(true);
		executor.submit(this);
	}

	@Override
	public void notifyObserversRRemote(String resource) throws RemoteException{
		this.resource=resource;
		updateType.set(false);
		executor.submit(this);
		
	}


	@Override
	public void run() {
		
		if(updateType.get()){
			notifyObserversA(action);
		}else{
			notifyObserversR(this.resource);
		}
		
	}


}
