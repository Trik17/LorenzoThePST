package it.polimi.ingsw.GC_04.view;

import java.rmi.RemoteException;

import it.polimi.ingsw.GC_04.client.rmi.ClientViewRemote;
import it.polimi.ingsw.GC_04.server.ClientManager;


// implements the methods. Given that this example is implemented using the Observer pattern, each methods only calls to
//notify() with the corresponding action. The controller that is observing the view will be notified and translate this in
//actual actions upon the model.
public class RMIView implements RMIViewRemote{
	private ClientManager clientManager;
	
	public RMIView(ClientManager clientManager) {
		this.clientManager=clientManager;
	}
	
	
	@Override
	public synchronized void registerClient(ClientViewRemote clientStub, String username) throws RemoteException {
		this.clientManager.addClient(clientStub, username);
		//manca qualcosa
				
	}


}
