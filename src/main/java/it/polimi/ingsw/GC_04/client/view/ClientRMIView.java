package it.polimi.ingsw.GC_04.client.view;

import java.io.IOException;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sun.corba.se.spi.orbutil.fsm.State;

import it.polimi.ingsw.GC_04.client.view.gui.StateOfTheGame;
import it.polimi.ingsw.GC_04.server.model.effect.Effect;
import it.polimi.ingsw.GC_04.server.model.resource.Resource;
import it.polimi.ingsw.GC_04.server.view.ServerRMIViewRemote;
/*implements the metods of ClientRMIViewRemote interface 
 * 
 */
public class ClientRMIView extends UnicastRemoteObject implements ClientRMIViewRemote, Serializable, Runnable {
	
	private static final long serialVersionUID = 9014192198954467429L;
	private final String username; 
	private ViewClient view;
	private ServerRMIViewRemote serverStub;
	private ExecutorService executor;
	private boolean gui=false;
	private ObjectMapper mapper ;
	
	
	protected ClientRMIView(String username, boolean gui) throws RemoteException {
		super();
		this.username=username;
		this.gui=gui;
		if (gui) {
			this.view=new ViewGUI();
		}else{
			this.view=new ViewCLI();
		}
		this.executor = Executors.newCachedThreadPool();
		this.mapper = new ObjectMapper();           
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
			
	}
	@Override
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
		if(gui){
			executor.submit((ViewGUI) view);
		}else{
			executor.submit((ViewCLI) view);
		}
			
	}
	@Override
	public void setFurtherCheckNeededEffect(List<Effect> requestedAuthorizationEffects, int[] furtherCheckNeeded) throws RemoteException{
		view.inputParameter1 = requestedAuthorizationEffects;
		view.inputParameter1 = furtherCheckNeeded;
		view.setRun = SetRun.SETFURTHERCHECKNEEDEDEFFECT;
		executor.submit((ViewCLI) view);
		
	}
	@Override
	public void setCouncilPrivilege(int nrOfPrivileges) throws RemoteException{
		view.inputParameter1 = nrOfPrivileges;
		view.setRun = SetRun.SETCOUNCILPRIVILEGE;
		executor.submit((ViewCLI) view);
		
	}
	@Override
	public void setRequestedAuthorizationEffects(List<Effect> requestedAuthorizationEffects) throws RemoteException{
		view.inputParameter1 = requestedAuthorizationEffects;
		view.setRun = SetRun.SETREQUESTEDAUTHORIZATIONEFFECTS;
		executor.submit((ViewCLI) view);
	}
	@Override
	public void setDiscount(List<Resource> rawMaterials) throws RemoteException{
		view.inputParameter1 = rawMaterials;
		view.setRun = SetRun.SETDISCOUNT;
		executor.submit((ViewCLI) view);
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
		executor.submit((ViewCLI) view);
		
	}
	@Override
	public void stateOfTheGame(StateOfTheGame state) throws RemoteException {
//		StateOfTheGame stateOfTheGame;
//		String string;
//		try {
//			stateOfTheGame = mapper.readValue(state, StateOfTheGame.class);
//			string=stateOfTheGame.getStateCLI();
//		} catch (IOException e) {
//			string=state;
//		}
		view.printStateOfTheGame(state.getStateCLI());		
	}
	
	@Override
	public void setState(StateOfTheGame state) throws RemoteException {
//		System.out.println(state);
//		StateOfTheGame stateOfTheGame;
//		try {
//			stateOfTheGame = mapper.readValue(state, StateOfTheGame.class);
//		} catch (IOException e) {
//			e.printStackTrace();
//			stateOfTheGame=new StateOfTheGame();
//			stateOfTheGame.setStateCLI(state);
//		}
		view.setState(state);		
	}
	@Override
	public void print(String string) throws RemoteException {
		System.out.println(string);
		return;
	}
	@Override
	public void usernameAlreadyUsed() throws RemoteException{
		System.out.println("Username already used, restart client with another username");
		executor.submit(this);
		return;
	}
	@Override
	public void exit() throws RemoteException {
		System.out.println("Game ended");
		executor.submit(this);
		return;
	}
	
	//to quit client at the end of the game
	@Override
	public void run() {
		synchronized (this) {
			try {
				wait(800);
			} catch (Exception e) {
			}
		}
		
		System.exit(0);
	}

}