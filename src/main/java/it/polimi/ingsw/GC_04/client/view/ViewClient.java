package it.polimi.ingsw.GC_04.client.view;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import java.io.Serializable;
import java.rmi.RemoteException;

import it.polimi.ingsw.GC_04.server.controller.JsonMapper;
import it.polimi.ingsw.GC_04.server.view.ServerRMIViewRemote;


public abstract class ViewClient implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6860755801717581167L;
	protected ServerRMIViewRemote serverStub;
	private int turn;
	protected String state;
	protected ExecutorService executor;
	
	public abstract void chooseAction()throws RemoteException;
	
	
	public ViewClient() {
		turn = 0;
		this.executor = Executors.newCachedThreadPool();
		JsonMapper.TimerFromJson();
	}

	public void setState(String state) {
		this.state = state;
	}
	

	public void passTurn() {
		try {
			serverStub.notifyObserversARemote("0");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void addServerstub(ServerRMIViewRemote serverStub){
		this.serverStub=serverStub;
	}

	
	
	
}
