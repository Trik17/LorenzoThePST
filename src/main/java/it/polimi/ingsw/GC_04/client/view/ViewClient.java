package it.polimi.ingsw.GC_04.client.view;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import java.io.Serializable;
import java.rmi.RemoteException;

import it.polimi.ingsw.GC_04.server.controller.JsonMapper;
import it.polimi.ingsw.GC_04.server.model.StateOfTheGame;
import it.polimi.ingsw.GC_04.server.view.ServerRMIViewRemote;

// Abstract class of the view extended from ViewCLI and ViewGUI
public abstract class ViewClient implements Serializable {
	
	private static final long serialVersionUID = 6860755801717581167L;
	protected ServerRMIViewRemote serverStub;
	transient Object inputParameter1;
	transient Object inputParameter2;
	SetRun setRun;
	protected StateOfTheGame state;
	protected ExecutorService executor;
	
	public abstract void chooseAction()throws RemoteException;
	public abstract void setCouncilPrivilege(int nrOfPrivileges) throws RemoteException;
	public abstract void printStateOfTheGame(String state);
	
	public ViewClient() {
		this.executor = Executors.newCachedThreadPool();
		JsonMapper.timerFromJson();
	}

	public void setState(StateOfTheGame state) {
		this.state = state;
	}
	

	public void passTurn() {
		try {
			serverStub.notifyObserversARemote("0");
		} catch (RemoteException e) {
		}
	}


	public void addServerstub(ServerRMIViewRemote serverStub){
		this.serverStub=serverStub;
	}
	public void setServerStub(ServerRMIViewRemote serverStub2) {
		this.serverStub=serverStub2;
	}

	
	
	
}
