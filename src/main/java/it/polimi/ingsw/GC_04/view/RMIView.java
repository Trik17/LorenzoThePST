package it.polimi.ingsw.GC_04.view;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Set;

import it.polimi.ingsw.GC_04.client.rmi.ClientViewRemote;
import it.polimi.ingsw.GC_04.model.action.Action;
import it.polimi.ingsw.GC_04.model.effect.Effect;
import it.polimi.ingsw.GC_04.model.resource.Resource;
import it.polimi.ingsw.GC_04.server.ClientManager;


// implements the methods. Given that this example is implemented using the Observer pattern, each methods only calls to
//notify() with the corresponding action. The controller that is observing the view will be notified and translate this in
//actual actions upon the model.
public class RMIView extends View implements RMIViewRemote{
	private ClientManager clientManager;
	
	public RMIView(ClientManager clientManager) {
		this.clientManager=clientManager;
	}
	
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public synchronized void registerClient(ClientViewRemote clientStub) throws RemoteException {
		this.clientManager.addClient(clientStub);
		//manca qualcosa
		
		
	}

	@Override
	public void printModel() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void makeAction() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAction(Action action) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateResource(Resource resource) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chooseAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Resource setCouncilPrivilege() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRequestedAuthorizationEffects(List<Effect> effects) {
		// TODO Auto-generated method stub
		
	}

	

}
