package it.polimi.ingsw.GC_04.controller;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import it.polimi.ingsw.GC_04.Initializer;
import it.polimi.ingsw.GC_04.JsonMapper;
import it.polimi.ingsw.GC_04.Observer;
import it.polimi.ingsw.GC_04.client.ClientRMIViewRemote;
import it.polimi.ingsw.GC_04.model.Model;
import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.action.Action;
import it.polimi.ingsw.GC_04.model.action.ErrorInput;
import it.polimi.ingsw.GC_04.model.action.PassTurn;
import it.polimi.ingsw.GC_04.model.action.TakeACard;
import it.polimi.ingsw.GC_04.model.effect.CouncilPrivilege;
import it.polimi.ingsw.GC_04.model.effect.Effect;
import it.polimi.ingsw.GC_04.model.resource.*;
import it.polimi.ingsw.GC_04.server.MainServer;

public class Controller implements Observer<String,Resource> {
	
	private final static int FINALPERIOD = 3;
	private final static int FINALTURN = 4;
	private Model model;
	private Map<String, ClientRMIViewRemote> views;
	private Initializer initializer;
	private String player;
	private int currentPlayer = 0;
	private int turn = 0;
	private boolean lastPhase;
	private Timer timer;
	private TimerTask task;
	private MainServer server;
	
	private ClonedAction clonedAction;

	public Controller(Model model,MainServer server) {
		this.model = model;
		clonedAction = new ClonedAction();
		this.server=server;
		JsonMapper.TimerFromJson();
	}
	
	
	
	private void disconnect(String username){//da chiamare ad ogni remoteexception
		for(Player p: model.getPlayers()){
			if(p.getName().equals(username))
				p.disconnect();
		}
		server.disconnectPlayer(username);
		views.forEach((name,stub) -> {
			try {
				if(isPlayerConnected(name))
					stub.print(username+" disconnected");
			} catch (RemoteException e) {
			}
		});
		updateTurn();
		chooseAction();
	}
	
	private void chooseAction(){
		if (!isPlayerConnected(player)){
			updateTurn();
			chooseAction();
			
		}		
//		this.timer=new Timer();
//		this.task=new TimerTask(){
//			public void run(){
//				disconnect(player);
//			}
//		};	
//		timer.schedule( task,TimerJson.getActionTimer()); //timer
//		
		//TODO risistemalo e metti timer.cancel in update()
		try {
			views.get(player).setState(model.getStateCLI());
			views.get(player).chooseAction();
		} catch (RemoteException e) {
			disconnect(player);
		}
	}
	
	private boolean isPlayerConnected(String player) {
		for(Player p: model.getPlayers()){
			if(p.getName().equals(player)){
				if(p.isDisconnected())
					return false;
				else
					return true;
			}
				
		}
		return false;
	}

	public void setViews(Map<String, ClientRMIViewRemote> clients){
		this.views = clients;
	}
	
	public void initialize(Player[] players){
		this.initializer = new Initializer(players,this.model);
		this.player = model.getCouncilPalace().getTurnOrder()[0].getName();
		model.setStateCLI();
		startGame();
	}
		
	private void startGame() {
		chooseAction();
	}
	
	public void setCouncilPrivilege(List<CouncilPrivilege> councilPrivileges, Resource resource,int cont) {
		
		councilPrivileges.get(cont).setCouncilPrivilege(resource);
		
	}
	
	
	
	private boolean isPlayerConnected(Player player){
		String name=player.getName();
		for(Player p: model.getPlayers()){
			if(p.getName().equals(name)){
				if(p.isDisconnected())
					return false;
				else
					return true;
			}
				
		}
		return false;
		
	}
	
	private void setCouncilPrivilege(int nrOfPrivileges) {
		if (nrOfPrivileges == 0) 
			return;
		try {
			views.get(player).setCouncilPrivilege(nrOfPrivileges);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	@Override
	public synchronized void update(String input)  {
		Player currPlayer = model.getCouncilPalace().getTurnOrder()[currentPlayer];
		InputActionInterpreter interpreter = new InputActionInterpreter(input, model, currPlayer);
		
		Action action = interpreter.getAction();
	try{
		if (action instanceof TakeACard) {
			if (((TakeACard) action).getCard() == null){
				views.get(player).print("You can't do this move");
				chooseAction();
				return;
			}
			
			clonedAction.setDiscount(action.getPlayer(), ((TakeACard) action).getCard());
			
			if (!clonedAction.getRawMaterials().isEmpty()) 
				askPlayersDiscounts();
			
			action.setDiscount(clonedAction.getDiscount());	
		}
		
		if (action.getClass().equals(ErrorInput.class)) {
			chooseAction();
			return;
		}
		if (action.getClass().equals(PassTurn.class) || !isPlayerConnected(action.getPlayer())) {
			updateTurn();
			chooseAction();
			return;
		}
		action.checkExtraordinaryEffect();
			
		int nrOfPrivileges = action.getCouncilPrivileges().size();
		
		setCouncilPrivilege(nrOfPrivileges);//TODO fallo fare a un thread magari
		
		clonedAction.setRequestedAuthorizationEffects(SupportFunctions.cloneEffects(action.getRequestedAuthorizationEffects()));
		
		if (!clonedAction.getRequestedAuthorizationEffects().isEmpty()) {
			askPlayerAuthorizations(clonedAction.getRequestedAuthorizationEffects());//TODO fallo fare a un thread magari
		}
		
		if(action.isApplicable()) {
			action.setRequestedAuthorizationEffects(clonedAction.getRequestedAuthorizationEffects());
			action.setCouncilPrivilege(clonedAction.getCouncilPrivileges());
			action.apply(); 
			
		}else {
			views.get(player).print("You can't do this move");
			chooseAction();
			return;
		}
		updateTurn();
		stateOfTheGame();

		chooseAction();
		}catch(RemoteException e){
			updateTurn();
			chooseAction();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void askPlayersDiscounts() {
		try {
			views.get(player).setDiscount(clonedAction.getRawMaterials());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void askPlayerAuthorizations(List<Effect> requestedAuthorizationEffects) {
		try {
			views.get(player).setRequestedAuthorizationEffects(requestedAuthorizationEffects);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void stateOfTheGame() throws RemoteException {
		views.get(player).stateOfTheGame(model.getStateCLI());
	}


	
	public void updateTurn() {
		int nrOfPlayers = model.getCouncilPalace().getTurnOrder().length -1;
		
		if (model.getPeriod() == FINALPERIOD && lastPhase && turn == FINALTURN && player.equals(model.getCouncilPalace().getTurnOrder()[nrOfPlayers]))
			//TODO: final score
			
			//TODO GESTIONE CHIUSURA CONNESSIONE, CLIENT E MAGARI CHIUSURA THREAD SERVER?
			return;
		else if (player.equals(model.getCouncilPalace().getTurnOrder()[nrOfPlayers])) {
			if (lastPhase) {
				excommunicationsManagement();
				model.incrementPeriod();
				initializer.changeTurn();
				}
			currentPlayer = 0;
		}else {
			currentPlayer++;
		}
		player = model.getCouncilPalace().getTurnOrder()[currentPlayer].getName();
		lastPhase =!lastPhase;
		
		try {
			model.setStateCLI();
		
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
	}


	private void excommunicationsManagement() {
		views.forEach((player,view) -> {
			try {
				view.excommunicationManagement(model.getVaticanReport().getExcommunication(model.getPeriod()).getDescription());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
	}



	public void reconnect(String username) {
		for (int i = 0; i < model.getPlayers().length; i++) {
			if(model.getPlayers()[i].getName().equals(username)){
				model.getPlayers()[i].reConnect();
				return;
			}			
		}			
		
		
	}

	@Override
	public void updateR(String resource) {
		InputChoicesInterpreter interpreter = new InputChoicesInterpreter(resource);
		String type = interpreter.getType();
		if (type.equals("COUNCIL"))
			clonedAction.setCouncilPrivileges(interpreter.getEffects());
		else if (type == "AUTHORIZATION") {
			clonedAction.setRequestedEffects(interpreter.getRequestedEffects());
			askPlayerChoices(clonedAction.getRequestedAuthorizationEffects(),clonedAction.getFurtherCheckNeeded());	
		}
		else if (type.equals("CHECKNEEDED")) {
			Player currPlayer = model.getCouncilPalace().getTurnOrder()[currentPlayer];
			InputChoicesInterpreter interpreter2 = new InputChoicesInterpreter(model,currPlayer,resource,clonedAction.getRequestedAuthorizationEffects(),clonedAction.getFurtherCheckNeeded());
			clonedAction.setRequestedAuthorizationEffects(interpreter2.getEffects());
		}
		else if (type.equals("DISCOUNT")) {
			clonedAction.setRawMaterialsDiscount(resource);
		}
	}

	private void askPlayerChoices(List<Effect> requestedAuthorizationEffects, int[] furtherCheckNeeded) {
		 try {
			views.get(player).setFurtherCheckNeededEffect(requestedAuthorizationEffects,furtherCheckNeeded);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
