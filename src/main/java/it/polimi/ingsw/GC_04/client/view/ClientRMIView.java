package it.polimi.ingsw.GC_04.client.view;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import it.polimi.ingsw.GC_04.server.model.effect.Effect;
import it.polimi.ingsw.GC_04.server.model.resource.Resource;
import it.polimi.ingsw.GC_04.server.view.ServerRMIViewRemote;
//implements ClientViewRemote interface
public class ClientRMIView extends UnicastRemoteObject implements ClientRMIViewRemote {
	
	private final String username; 
	private ViewClient view;
	private ServerRMIViewRemote serverStub;
	private ExecutorService executor;
	private boolean GUI;
	
	
	protected ClientRMIView(String username, boolean GUI) throws RemoteException {
		super();
		this.username=username;
		this.GUI=GUI;
		if (GUI) {
			this.view=new ViewGUI();
		}else {
			this.view=new ViewCLI();
		}
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
		view.inputParameter1 = description;
		view.inputParameter2 = username;
		view.setRun = SetRun.EXCOMMUNICATIONMANAGEMENT;
		executor.submit(view);
		
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
	public void usernameAlreadyUsed() throws RemoteException{
		System.out.println("Username already used, restart client with another username");
		System.exit(0);
	}
	@Override
	public void exit() throws RemoteException {
		System.exit(0);
		
	}

}