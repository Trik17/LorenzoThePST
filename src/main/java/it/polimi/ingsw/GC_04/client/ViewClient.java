package it.polimi.ingsw.GC_04.client;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.fasterxml.jackson.databind.JsonMappingException;

import java.io.IOException;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;

import it.polimi.ingsw.GC_04.JsonMapper;
import it.polimi.ingsw.GC_04.controller.SupportFunctions;
import it.polimi.ingsw.GC_04.model.ActionSpace;
import it.polimi.ingsw.GC_04.model.DiceColor;
import it.polimi.ingsw.GC_04.model.FamilyMember;
import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.action.Action;
import it.polimi.ingsw.GC_04.model.action.GoToTheCouncilPalace;
import it.polimi.ingsw.GC_04.model.action.GoToTheMarket;
import it.polimi.ingsw.GC_04.model.action.PassTurn;
import it.polimi.ingsw.GC_04.model.action.RunHarvest;
import it.polimi.ingsw.GC_04.model.action.RunProduction;
import it.polimi.ingsw.GC_04.model.area.Area;
import it.polimi.ingsw.GC_04.model.area.BuildingTower;
import it.polimi.ingsw.GC_04.model.area.CharacterTower;
import it.polimi.ingsw.GC_04.model.area.CouncilPalaceArea;
import it.polimi.ingsw.GC_04.model.area.MarketArea;
import it.polimi.ingsw.GC_04.model.area.TerritoryTower;
import it.polimi.ingsw.GC_04.model.area.Tower;
import it.polimi.ingsw.GC_04.model.area.VentureTower;
import it.polimi.ingsw.GC_04.model.card.DevelopmentCard;
import it.polimi.ingsw.GC_04.model.resource.*;
import it.polimi.ingsw.GC_04.view.ServerRMIViewRemote;


public abstract class ViewClient implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6860755801717581167L;
	protected ServerRMIViewRemote serverStub;
	private int turn;
	protected String state;
	protected JsonMapper timerJson;
	protected ExecutorService executor;
	
	public abstract void chooseAction()throws RemoteException;
	
	
	public ViewClient() {
		turn = 0;
		this.executor = Executors.newCachedThreadPool();
		try {
			timerJson.TimerFromJson();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//inizialize the timer from json file
	}

	public void setState(String state) {
		this.state = state;
	}
	

	public void passTurn() {
		try {
			serverStub.notifyObserversARemote("pass");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void addServerstub(ServerRMIViewRemote serverStub){
		this.serverStub=serverStub;
	}

	
	
	
}
