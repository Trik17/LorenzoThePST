package it.polimi.ingsw.GC_04.client.rmi;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import it.polimi.ingsw.GC_04.client.ViewCLI;
import it.polimi.ingsw.GC_04.model.effect.Effect;
import it.polimi.ingsw.GC_04.model.resource.Resource;
import it.polimi.ingsw.GC_04.view.ServerRMIViewRemote;
//implements ClientViewRemote interface
public class ClientRMIView extends UnicastRemoteObject implements ClientRMIViewRemote, Serializable, Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9164262648865618843L;
	private String username; 
	private ViewCLI view;
	private ServerRMIViewRemote serverStub;
	private ExecutorService executor;
	private Set<String> usernamesProhibited;
//mi manca qua il serverstub!!
	
	
	protected ClientRMIView(String username) throws RemoteException {
		super();
		this.username=username;
		this.view=new ViewCLI();
		this.executor = Executors.newCachedThreadPool();
	}
	@Override
	public void changeUsername(Set<String> usernames) throws RemoteException{
		this.usernamesProhibited=usernames;
		executor.submit(this);
	}
	
	public void addServerstub(ServerRMIViewRemote serverStub)throws RemoteException{
		this.serverStub=serverStub;
		this.view.addServerstub(serverStub);
	}

	@Override
	public String getUsername() throws RemoteException {
		return this.username;		
	}
	
//	public void setUsername(String username) {
//		this.username=username;		
//	}
	
	@Override
	public void chooseAction() throws RemoteException{
		executor.submit(view);
		return;		
	}
	@Override
	public int[] setFurtherCheckNeededEffect(Effect effect) throws RemoteException{
		return view.setFurtherCheckNeededEffect(effect);
	}
	@Override
	public Resource setCouncilPrivilege() throws RemoteException{
		return view.setCouncilPrivilege();
	}
	@Override
	public int[] setRequestedAuthorizationEffects(List<Effect> requestedAuthorizationEffects) throws RemoteException{
		return view.setRequestedAuthorizationEffects(requestedAuthorizationEffects);
	}
	@Override
	public Resource setDiscount(Resource res) throws RemoteException{
		return view.setDiscount(res);
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
	public void print(String string)  throws RemoteException{
		System.out.println(username);
		
	}
	@Override
	public void notifyReconnection(String username)  throws RemoteException{
		System.out.println(username+" si è riconnesso");
		
	}
	
	private String askUsername(){
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.println("Username already used, choose another name: ");
		return in.nextLine();
	}
	
	@Override
	public void run() {		
		while(usernamesProhibited.contains(this.username))
			this.username=askUsername();
		try {
			serverStub.registerClient(this, this.username);
		} catch (RemoteException e) {
			System.out.println("connection error");
		}
		
	}
	
	
	
	

}