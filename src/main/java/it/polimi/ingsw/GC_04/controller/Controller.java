package it.polimi.ingsw.GC_04.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import it.polimi.ingsw.GC_04.Initializer;
import it.polimi.ingsw.GC_04.Observer;
import it.polimi.ingsw.GC_04.client.rmi.ClientRMIViewRemote;
import it.polimi.ingsw.GC_04.model.ActionSpace;
import it.polimi.ingsw.GC_04.model.Model;
import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.action.Action;
import it.polimi.ingsw.GC_04.model.action.PassTurn;
import it.polimi.ingsw.GC_04.model.action.TakeACard;
import it.polimi.ingsw.GC_04.model.area.BuildingTower;
import it.polimi.ingsw.GC_04.model.area.CharacterTower;
import it.polimi.ingsw.GC_04.model.area.CouncilPalaceArea;
import it.polimi.ingsw.GC_04.model.area.TerritoryTower;
import it.polimi.ingsw.GC_04.model.area.Tower;
import it.polimi.ingsw.GC_04.model.area.VaticanReport;
import it.polimi.ingsw.GC_04.model.area.VentureTower;
import it.polimi.ingsw.GC_04.model.card.DevelopmentCard;
import it.polimi.ingsw.GC_04.model.effect.CouncilPrivilege;
import it.polimi.ingsw.GC_04.model.effect.Effect;
import it.polimi.ingsw.GC_04.model.effect.ExchangeResourcesEffect;
import it.polimi.ingsw.GC_04.model.effect.TakeACardEffect;
import it.polimi.ingsw.GC_04.model.resource.*;

public class Controller implements Observer<Action,Resource> {
	
	private final static int FINALPERIOD = 3;
	private final static int FINALTURN = 4;
	private Model model;
	private Map<String, ClientRMIViewRemote> views;
	private Initializer initializer;
	private String player;
	private int currentPlayer = 0;
	private int turn = 0;
	private boolean lastPhase;

	public Controller(Model model) {
		this.model = model;
	}
	
	
	public void setViews(Map<String, ClientRMIViewRemote> clients){
		this.views = clients;
	}
	
	public void initialize(Player[] players){
		this.initializer = new Initializer(players);
		CouncilPalaceArea.instance();
		this.player = CouncilPalaceArea.getTurnOrder()[0].getName();
		startGame();
	}
	
//	@Override//cancella
//	public void updateR(Resource e) {
//		System.out.println("DENTRO UPDATE DEL MODEL");// cancella
//		System.out.println("stampo quantità risorsa");// cancella
//		System.out.println(e.getQuantity());// cancella
//		
//		
//	}
	
	private void startGame() {
//		try {
//			System.out.println("server: provo a salutare");
//			views[currentPlayer].askSomething("ciao");
//			views[2].askSomething("ciao");
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		try {
			views.get(player).setState(model.getStateCLI());
			views.get(player).chooseAction();
		} catch (RemoteException e) {
			//FAI CODICE PER SALTARE TURNO -> ERRORE DI CONNESSIONE
			e.printStackTrace();
		}
	}
	
	public void setCouncilPrivilege(List<CouncilPrivilege> councilPrivileges, Resource resource,int cont) {
		
		councilPrivileges.get(cont).setCouncilPrivilege(resource);
		
	}
	private int[] setFurtherCheckNeeded(List<Effect> requestedAuthorizationEffects) {
		//it stores in an array the indices of the Resources that offer a choice
		int[] furtherCheckNeeded = new int[0];
		if (!requestedAuthorizationEffects.isEmpty()) {
			furtherCheckNeeded = new int[requestedAuthorizationEffects.size()-1];
			int cont = 0;
			for (int i = 0; i < requestedAuthorizationEffects.size(); i++) {
				if (requestedAuthorizationEffects.get(i) instanceof ExchangeResourcesEffect)
					if (!(((ExchangeResourcesEffect) requestedAuthorizationEffects.get(i)).getCost2() == null)) {
						furtherCheckNeeded[cont] = i;
						cont ++;
					}
			}
			for (int i = 0; i < requestedAuthorizationEffects.size(); i++) {
				if (requestedAuthorizationEffects.get(i) instanceof TakeACardEffect) {
					furtherCheckNeeded[cont] = i;
					cont ++;
					}
			}
			
		}
		return furtherCheckNeeded;
	}
	
	public void setChoice(List<Effect> requestedAuthorizationEffects, int index,Player player) throws RemoteException {
		Effect effect = requestedAuthorizationEffects.get(index);
		int[] choice = views.get(player).setFurtherCheckNeededEffect(effect);
		if (effect instanceof ExchangeResourcesEffect) {
			if (choice[0] == 1)
				((ExchangeResourcesEffect) effect).setEffect(((ExchangeResourcesEffect) effect).getEffect1(), ((ExchangeResourcesEffect) effect).getCost1());
			else
				((ExchangeResourcesEffect) effect).setEffect(((ExchangeResourcesEffect) effect).getEffect2(), ((ExchangeResourcesEffect) effect).getCost2());		
		}
		else if (effect instanceof TakeACardEffect) {
			Tower tower;
			if (choice.length == 4) {
				
				switch (choice[0]) {
				case 1:
					tower = TerritoryTower.instance();
					break;
				case 2:
					tower = CharacterTower.instance();
					break;
				case 3:
					tower = BuildingTower.instance();
					break;
				default:
					tower = VentureTower.instance();
					break;
				}
			}else {
				tower = ((TakeACardEffect) effect).getCardType().getTower();
			}
			DevelopmentCard card = tower.getCards()[choice[1] -1];
			ActionSpace aSpace = tower.getASpaces().get(choice[1] -1);
			int servants = choice[2];
			List<Resource> cost = new ArrayList<Resource>();
			if (choice[3] == 1)
				cost = tower.getCards()[choice[1] -1].getCost1();
			else
				cost = tower.getCards()[choice[1] -1].getCost2();;
				((TakeACardEffect) effect).setParameters(player,card,aSpace,servants,cost);
		}
	
	}

	
		
	
	@Override
	public void update(Action action)  {
		try{
		System.out.println("DENTRO UPDATE DEL MODEL");// cancella
		System.out.println("stampo il nome el player che mi ha inviato l'azione (sono il controller");// cancella
		try{
			System.out.println(action.getPlayer().getName());// cancella
		}catch(Exception e){
			e.printStackTrace();
		}
		
		if (action.getClass().equals(PassTurn.class)) {
			updateTurn();
			views.get(player).chooseAction();
			return;
		}
		action.checkExtraordinaryEffect();
		Resource privilege;
		List<CouncilPrivilege> councilPrivileges = SupportFunctions.cloneCouncilPrivilege(action.getCouncilPrivileges());
		
		int cont = 0;
		while(cont < councilPrivileges.size()) {
			privilege = views.get(player).setCouncilPrivilege();
			setCouncilPrivilege(councilPrivileges,privilege,cont);
			cont++;
			/* it clones all of the instances of CouncilPrivilege present in the effects of the action
			 * and ask the client which privilege he wants to apply, then set the parameters chosen in the clone
			 */
		}
		List<Effect> requestedAuthorizationEffects = SupportFunctions.cloneEffects(action.getRequestedAuthorizationEffects());
		int[] furtherCheckNeeded = setFurtherCheckNeeded(requestedAuthorizationEffects);
	
		requestedAuthorizationEffects = organizeExchangeResourcesEffects(requestedAuthorizationEffects);
		int[] requestedEffects = views.get(player).setRequestedAuthorizationEffects(requestedAuthorizationEffects); //it returns the indices of the effects chosen by the player
		
		if (furtherCheckNeeded.length != 0 && requestedEffects.length != 0) {
		//it asks the player which choice he wants to make between those proposed
			for (int i:furtherCheckNeeded) {
				for (int j: requestedEffects) {
					if (furtherCheckNeeded[i] == requestedEffects[j]) {
						setChoice(requestedAuthorizationEffects, requestedEffects[j],action.getPlayer());
					}
				}
			}
		}
		List<Resource> discount = new ArrayList<Resource>();
		if (action instanceof TakeACard) {
			if (((TakeACard) action).getCard() == null){
				System.out.println("You can't do this move");
				views.get(player).chooseAction();
				return;
			}
			discount = setDiscount(action.getPlayer(), ((TakeACard) action).getCard());
			
		}
		if(action.isApplicable()) {
			action.setRequestedAuthorizationEffects(requestedAuthorizationEffects);
			action.setCouncilPrivilege(councilPrivileges);
			action.setDiscount(discount);
			action.apply(); 
			
		}else {
			System.out.println("You can't do this move");
			views.get(player).chooseAction();
			return;
		}
		updateTurn();
		stateOfTheGame();

		views.get(player).chooseAction();
		}catch(RemoteException e){
			e.printStackTrace();
		}
	}
	
	private void stateOfTheGame() throws RemoteException {
		views.get(player).stateOfTheGame(model.getStateCLI());
	}


	public List<Resource> setDiscount(Player player, DevelopmentCard card) {
		//this method uploads the action's discounts accumulated by the player 
		List<Resource> discounts;
		List<Resource> myDiscounts = SupportFunctions.cloneResources(player.getDiscount().getDiscount(card));
		if (myDiscounts.isEmpty())
			return new ArrayList<>();
		if (!myDiscounts.stream().anyMatch(res -> res.getClass().equals(RawMaterial.class)))
			discounts = myDiscounts;
		else {
			myDiscounts.forEach(res -> {if (res instanceof RawMaterial)
				try {
					res = views.get(player).setDiscount(res);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}});
			discounts = myDiscounts;
		}
		return discounts;
			
			
	}
	
	public List<Effect> organizeExchangeResourcesEffects(List<Effect> requestedAuthorizationEffects) {
		//it finds ExchangeResourcesEffect that offer only one effect and sets it as chosen effect
		for (Effect eff:requestedAuthorizationEffects) {
			if (eff instanceof ExchangeResourcesEffect)
				if (((ExchangeResourcesEffect) eff).getCost2() == null) {
					((ExchangeResourcesEffect) eff).setEffect(((ExchangeResourcesEffect) eff).getEffect1(), ((ExchangeResourcesEffect) eff).getCost1());
				}
		}
		return requestedAuthorizationEffects;
		
	}

	public void setFurtherCheckNeededEffect(List<Effect> effects,int index) {
		if (effects.get(index) instanceof ExchangeResourcesEffect) {
			
		}
	}
	
	public void updateTurn() {//TODO: tutto
		int nrOfPlayers = CouncilPalaceArea.getTurnOrder().length -1;
		
		if (model.getPeriod() == FINALPERIOD && lastPhase && turn == FINALTURN && player.equals(CouncilPalaceArea.getTurnOrder()[nrOfPlayers]))
			//TODO: final score
			return;
		else if (player.equals(CouncilPalaceArea.getTurnOrder()[nrOfPlayers])) {
			if (lastPhase) {
				excommunicationsManagement();
				model.incrementPeriod();
				initializer.changeTurn();
				}
			currentPlayer = 0;
		}else {
			currentPlayer++;
		}
		player = CouncilPalaceArea.getTurnOrder()[currentPlayer].getName();
		lastPhase =!lastPhase;
		model.setStateCLI();
		
	}


	private void excommunicationsManagement() {
		views.forEach((player,view) -> {
			try {
				view.excommunicationManagement(VaticanReport.instance().getExcommunication(model.getPeriod()).getDescription());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
	}
	
}
