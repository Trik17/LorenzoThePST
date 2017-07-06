package it.polimi.ingsw.GC_04.client.view;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import it.polimi.ingsw.GC_04.server.model.effect.Effect;
import it.polimi.ingsw.GC_04.server.model.resource.Resource;
import it.polimi.ingsw.GC_04.server.view.ServerRMIViewRemote;
//implements ClientViewRemote interface
public class ClientRMIView extends UnicastRemoteObject implements ClientRMIViewRemote, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9164262648865618843L;
	private String username; 
	private ViewCLI view;
	private ServerRMIViewRemote serverStub;
	private ExecutorService executor;
	
	
	protected ClientRMIView(String username) throws RemoteException {
		super();
		this.username=username;
		this.view=new ViewCLI();
		this.executor = Executors.newCachedThreadPool();
	}
	public void addServerstub(ServerRMIViewRemote serverStub)throws RemoteException{
		this.serverStub=serverStub;
		this.view.addServerstub(serverStub);
	}

	@Override
	public String getUsername() throws RemoteException {
		return this.username;		
	}
	@Override
	public void chooseAction() throws RemoteException{
		view.setRun = SetRun.CHOOSEACTION;
		executor.submit(view);
			
	}
	@Override
	public void setFurtherCheckNeededEffect(List<Effect> requestedAuthorizationEffects, int[] furtherCheckNeeded) throws RemoteException{
		view.inputParameter1 = requestedAuthorizationEffects;
		view.inputParameter1 = furtherCheckNeeded;
		view.setRun = SetRun.SETFURTHERCHECKNEEDEDEFFECT;
		executor.submit(view);
		
	}
	@Override
	public void setCouncilPrivilege(int nrOfPrivileges) throws RemoteException{
		view.inputParameter1 = nrOfPrivileges;
		view.setRun = SetRun.SETCOUNCILPRIVILEGE;
		executor.submit(view);
		
	}
	@Override
	public void setRequestedAuthorizationEffects(List<Effect> requestedAuthorizationEffects) throws RemoteException{
		view.inputParameter1 = requestedAuthorizationEffects;
		view.setRun = SetRun.SETREQUESTEDAUTHORIZATIONEFFECTS;
		executor.submit(view);
	}
	@Override
	public void setDiscount(List<Resource> rawMaterials) throws RemoteException{
		view.inputParameter1 = rawMaterials;
		view.setRun = SetRun.SETDISCOUNT;
		executor.submit(view);
	}
	@Override
	public ServerRMIViewRemote getServerStub() throws RemoteException{
		return this.serverStub;
	}

	@Override
	public void excommunicationManagement(String description) throws RemoteException {
		//TODO: INVENTARE LA FUNZIONE VERA SULLA VIEW
		
	}
	@Override
	public void stateOfTheGame(String state) throws RemoteException {
		view.printStateOfTheGame(state);
		
	}
	
	@Override
	public void setState(String stateCLI) throws RemoteException {
		view.setState(stateCLI);		
	}
	@Override
	public void print(String string) throws RemoteException {
		System.out.println(string);
		return;
	}
	

	@Override
	public void changeUsername(Set<String> set) throws RemoteException {
		while(!(set.contains(username))){
		username=view.scanner.getInput();
		}
	}
	
	
	
	

}