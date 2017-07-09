package it.polimi.ingsw.GC_04.server.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import it.polimi.ingsw.GC_04.client.view.ClientRMIViewRemote;
import it.polimi.ingsw.GC_04.server.MainServer;
import it.polimi.ingsw.GC_04.server.model.Model;
import it.polimi.ingsw.GC_04.server.model.Player;
import it.polimi.ingsw.GC_04.server.model.action.Action;
import it.polimi.ingsw.GC_04.server.model.action.PassTurn;
import it.polimi.ingsw.GC_04.server.model.action.TakeACard;
import it.polimi.ingsw.GC_04.server.model.area.VaticanReport;
import it.polimi.ingsw.GC_04.server.model.card.ExcommunicationTile;
import it.polimi.ingsw.GC_04.server.model.effect.CouncilPrivilege;
import it.polimi.ingsw.GC_04.server.model.effect.Effect;
import it.polimi.ingsw.GC_04.server.model.resource.*;
import it.polimi.ingsw.GC_04.server.timer.TimerJson;
//TODO le wait() e le notify() in updateA e updateR hanno rischio di deadlock se c'è una disconnessione, metti delle notify 
//nella gestione della disconnessione e nel catch delle remote exception
public class Controller implements Observer<String> {
	
	private final static int FINALAGE = 3; //age is the period, bounded between 1 and 3
	private final static int FINALROW = 4; //when in a phase a player makes a move for the fourth time 
		
	private Model model;
	private Map<String, ClientRMIViewRemote> views;
	private Initializer initializer;
	private String player;
	private int currentPlayer = 0;
	
	private Timer timerAction;
	private Timer timerExcomunication;
	private TimerTask taskAction;
	private TimerTask taskExcomunication;
	private MainServer server;
	private AtomicBoolean isWaiting;	
	private ClonedAction clonedAction;
	private Object lock;
	private AtomicInteger count;
	private List<String> playerExcommunicationSetted;
	private boolean endGame=false;
	
	public Controller(Model model,MainServer server) {
		this.model = model;
		clonedAction = new ClonedAction();
		this.server=server;
		JsonMapper.TimerFromJson();
		this.isWaiting=new AtomicBoolean(false);
		this.lock=new Object();
		count=new AtomicInteger(0);
		playerExcommunicationSetted=new ArrayList<>();
	}
	/*
	 * this function disconnect the player in the model and in the server
	 * it is called when a remote exception occur or when the timer of the action is over
	 * without a response from the player
	 */
	private void disconnect(String username){
		model.getPlayer(username).disconnect();
		
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
		if(!endGame){
			if (!isPlayerConnected(player)){
				updateTurn();
				chooseAction();
				return;
			}		
			startTimerAction();
			try {
				views.get(player).setState(model.getStateCLI());
				views.get(player).chooseAction();
			} catch (RemoteException e) {
				disconnect(player);
				timerAction.cancel();
			}
		}
	}
	/*
	 * this is the timer for a complete action of a client
	 * when the time is over it disconnect the player
	 */
	private void startTimerAction() {
		this.timerAction=new Timer();
		this.taskAction=new TimerTask(){
			public void run(){
				disconnect(player);
			}
		};	
		timerAction.schedule( taskAction,TimerJson.getActionTimer()); //timer
		
		
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
	public void setInizializer(Player[] players){
		this.initializer = new Initializer(players,this.model);	
	}
	public void initialize(Player[] players){
		setInizializer(players);
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
		
		try {
			views.get(player).setCouncilPrivilege(nrOfPrivileges);
		} catch (RemoteException e) {
			disconnect(player);
		}

		
	}
	
	@Override
	public void update(String input)  {
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
			
			if (!clonedAction.getRawMaterials().isEmpty()) {
				synchronized(this){
					askPlayersDiscounts();
					isWaiting.set(true);
					while(isWaiting.get()){
						wait(800);		
					}
				}
			}			
			
			action.setDiscount(clonedAction.getDiscount());	
		}
		
//		if (action.getClass().equals(ErrorInput.class)) {
//			chooseAction();
//			return;
//		}
		if (action.getClass().equals(PassTurn.class) || !isPlayerConnected(action.getPlayer())) {
			updateTurn();
			chooseAction();
			return;
		}
		action.checkExtraordinaryEffect();
			
		int nrOfPrivileges = action.getCouncilPrivileges().size();
		
		if (nrOfPrivileges != 0) {
			synchronized (this) {
				setCouncilPrivilege(nrOfPrivileges);
				isWaiting.set(true);
				while(isWaiting.get()){
					wait(800);		
				}
			}				
		}
		clonedAction.setRequestedAuthorizationEffects(SupportFunctions.cloneEffects(action.getRequestedAuthorizationEffects()));
		
		if (!clonedAction.getRequestedAuthorizationEffects().isEmpty()) {
			synchronized (this) {
				askPlayerAuthorizations(clonedAction.getRequestedAuthorizationEffects());
				isWaiting.set(true);

				while(isWaiting.get()){
					wait(800);		
				}
			}
			
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
		return;
		}catch(RemoteException e){
			disconnect(player);
			return;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void askPlayersDiscounts() {
		try {
			views.get(player).setDiscount(clonedAction.getRawMaterials());
		} catch (RemoteException e) {
			disconnect(player);
		}
		
	}

	private void askPlayerAuthorizations(List<Effect> requestedAuthorizationEffects) {
		try {
			views.get(player).setRequestedAuthorizationEffects(requestedAuthorizationEffects);
		} catch (RemoteException e) {
			disconnect(player);
		}
		
	}

	private void stateOfTheGame() throws RemoteException {
		views.get(player).stateOfTheGame(model.getStateCLI());
	}


	
	public synchronized void updateTurn() {
		timerAction.cancel();
		int nrOfPlayers = model.getCouncilPalace().getTurnOrder().length -1;
		
		if (model.getAge() == FINALAGE && model.isLastPeriod() && model.getCurrentRow() == FINALROW && player.equals(model.getCouncilPalace().getTurnOrder()[nrOfPlayers].getName())) {
			excommunicationManagement();
			Player[] ranking = FinalScore.getRanking(model.getPlayers());
			printRanking(ranking);
			this.endGame=true;

			return;
		}
		else if (player.equals(model.getCouncilPalace().getTurnOrder()[nrOfPlayers].getName()) && model.getCurrentRow() == FINALROW) {
			/* this is the end of the second turn of an age 
			 * and the controller asks players that have enough faithPoints
			 * to decide if they want to suffer the excommunication or not
			 */
			if (model.isLastPeriod()) {
				excommunicationManagement();
			
				model.incrementAge();
				initializer.changeTurn();
			}
			currentPlayer = 0;
			model.switchLastPeriod();
			model.resetCurrentRow();
			
		}
		else if (player.equals(model.getCouncilPalace().getTurnOrder()[nrOfPlayers].getName()) ) {
			model.incrementCurrentRow();
			currentPlayer = 0;
			
		}else {
			currentPlayer++;
			
		}
		try {
			views.get(player).print("Wait for the other players to make their move");
			player = model.getCouncilPalace().getTurnOrder()[currentPlayer].getName();
			
		} catch (RemoteException e) {
			player = model.getCouncilPalace().getTurnOrder()[currentPlayer].getName();
//			disconnect(player);
		}
		
		try {
			model.setStateCLI();
		
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
	}


	

	

	private void excommunicationManagement() {
		//timer to avoid the block of the game caused by a disconnection of the client during the request of the ecomunications
		startTimerExcommunication();
		
		/*variable used to wait the players' responses
		 * about the excommunications  
		 * it is decremented each time that a player sends his response
		 * (except the players that are excommunicated by default : for a connection error
		 * or because they haven't enough faithpoints)
		 */
		count.set(0);
		setExcommunications();
		
		while(count.get()>0){
			try {
				wait(1000);
			} catch (InterruptedException e) {
			}		
		}
	}

	private void startTimerExcommunication() {
		this.timerExcomunication=new Timer();
		this.taskExcomunication=new TimerTask(){
			public void run(){
				for (int i = 0; i < model.getPlayers().length; i++) {
					for (int j = 0; j < playerExcommunicationSetted.size(); j++){
						if (model.getPlayers()[i].getName().equals(playerExcommunicationSetted.get(j))){
							model.getVaticanReport().getExcommunication(model.getAge()).apply(model.getPlayer(player));
						}
					}
				}
				count.set(0);
			}
		};	
		timerExcomunication.schedule( taskExcomunication, 1000000/*TimerJson.getActionTimer() */ ); 
		
	}

	private void printRanking(Player[] players) {
		String ranking = StateOfTheGameCLI.printRanking(players);
		for (int i = 0; i < players.length; i++) {
			try {
				views.get(players[i].getName()).print(ranking);
//				views.get(player).exit();
				//TODO sysexit non va 
				//TODO e ci sono thread che rimangono aperti ad ogni azione
				//TODO E CHIUDERE SOCKET 
				//ED RMI?
			} catch (RemoteException e) {
			}
		}
	}

	private void setExcommunications() {
		views.forEach((namePlayer,view) -> {
			if (!VaticanReport.isUnderThreshold(model.getPlayer(namePlayer), model.getAge())) {
				try {
					count.incrementAndGet();
					view.excommunicationManagement(model.getVaticanReport().getExcommunication(model.getAge()).getDescription());
				} catch (RemoteException e) {
					//if it catches a remote exception, this player suffers the excommunication
					model.getVaticanReport().getExcommunication(model.getAge()).apply(model.getPlayer(namePlayer));
					count.getAndDecrement();
				}
			}
			else 
				model.getVaticanReport().getExcommunication(model.getAge()).apply(model.getPlayer(namePlayer));
			});
		
	}



	public void reconnect(String username) {
		model.getPlayer(username).reConnect();

		views.forEach((name,stub) -> {
			try {
				if(isPlayerConnected(name))
					stub.print(username+" reconnected");
			} catch (RemoteException e) {
			}
		});
		
	}
	/*UpdateR :
	 * it is the method called from the clients (using the observer pattern) to 
	 * notify his choises requested by the functions of the controller 
	 * 1)askPlayersDiscounts
	 * 2)askPlayerChoices
	 * 3)askPlayerAuthorizations
	 * 4)askPlayerChoices
	 */
	
	@Override
	public void updateR(String input) {
		timerAction.cancel();
		synchronized(lock){
	//		this.resource=resource;
	//		executor.submit(this);
			InputChoicesInterpreter interpreter = new InputChoicesInterpreter(input);
			String type = interpreter.getIdentifier();
			if (type.equals("COUNCIL")){
				clonedAction.setCouncilPrivileges(interpreter.getEffects());
				isWaiting.set(false);
	
				notify();
			}
			else if (type == "AUTHORIZATION") {
				clonedAction.setRequestedEffects(interpreter.getRequestedEffects());
				askPlayerChoices(clonedAction.getRequestedAuthorizationEffects(),clonedAction.getFurtherCheckNeeded());	
				
			}
			else if (type.equals("CHECKNEEDED")) {
				Player currPlayer = model.getCouncilPalace().getTurnOrder()[currentPlayer];
				InputChoicesInterpreter interpreter2 = new InputChoicesInterpreter(model,currPlayer,input,clonedAction.getRequestedAuthorizationEffects(),clonedAction.getFurtherCheckNeeded());
				clonedAction.setRequestedAuthorizationEffects(interpreter2.getEffects());
				isWaiting.set(false);
	
				notify();
			}
			else if (type.equals("DISCOUNT")) {
				clonedAction.setRawMaterialsDiscount(input);
				isWaiting.set(false);
	
				notify();
			}
			else if (type.equals("EXCOMMUNICATION")) {
				interpreter.excommunicationManagementInterpreter(input);
				String thisPlayer = interpreter.getIdentifier(); //it returns the name of the player 
				playerExcommunicationSetted.add(thisPlayer);
				boolean excommunicated = interpreter.isExcommunicated();
				if (excommunicated) {
					int age = model.getAge();
					ExcommunicationTile excommunication = model.getVaticanReport().getExcommunication(age);
					excommunication.apply(model.getPlayer(thisPlayer));
					
				}else {
					model.supportTheChurch(model.getPlayer(thisPlayer));
				}
				count.getAndDecrement();
			}
		}
	}

	private void askPlayerChoices(List<Effect> requestedAuthorizationEffects, int[] furtherCheckNeeded) {
		 try {
			views.get(player).setFurtherCheckNeededEffect(requestedAuthorizationEffects,furtherCheckNeeded);
		} catch (RemoteException e) {
			disconnect(player);
		}		
	}

}