
package it.polimi.ingsw.GC_04.client.view;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

import it.polimi.ingsw.GC_04.server.controller.SupportFunctions;
import it.polimi.ingsw.GC_04.server.model.effect.CouncilPrivilege;
import it.polimi.ingsw.GC_04.server.model.effect.Effect;
import it.polimi.ingsw.GC_04.server.model.effect.ExchangeResourcesEffect;
import it.polimi.ingsw.GC_04.server.model.effect.ResourceEffect;
import it.polimi.ingsw.GC_04.server.model.effect.TakeACardEffect;
import it.polimi.ingsw.GC_04.server.model.resource.Resource;
import it.polimi.ingsw.GC_04.server.timer.TimerJson;

public class ViewCLI extends ViewClient implements Runnable{
	
	private static final long serialVersionUID = -2328795643634959640L;
	private String strInput = ""; 
	private boolean timeout=false;
	
	protected ScannerInputThread scanner;
	private AtomicBoolean whileSecurity;
	private Object lockStrInput;
	
	public ViewCLI() {
		super();
		whileSecurity=new AtomicBoolean(false);
		this.scanner=ScannerInputThread.instance(this);
		executor.submit(this);
		lockStrInput= new Object();
	} 
	
	
	private void print(String string) {
		System.out.println(string);
	}
	
	public String getStrInput(){
		synchronized (lockStrInput) {
			String str=strInput;
			return str;
		}
		
	}
	public void setStrInput(String string){
		synchronized (lockStrInput) {
			strInput=string;
		}
	}
	private String getInput(){
		setStrInput("");	
		Timer timer=new Timer();
		TimerTask task=new TimerTask(){
			public void run(){
				if( getStrInput().equals("") ){
					System.out.println( "Time out for input" );
					timeout=true;
				}
			}
		};			
		timer.schedule( task, TimerJson.getInputTimer()); //timer
		scanner.scan();
		while(getStrInput()=="" && !timeout){			
		}		
		timer.cancel(); 
				
		if (timeout){
			setStrInput("ERRORTIME");
			timeout=false;
		}
		
		
		return getStrInput()+" ";
	}	
	
	@SuppressWarnings("unchecked")
	@Override
	public void run(){
		if(whileSecurity.get()){
			try {
				switch (setRun) {
				case CHOOSEACTION:
					chooseAction();
					setRun=null;
					break;
				case SETFURTHERCHECKNEEDEDEFFECT:
					setFurtherCheckNeededEffect((List<Effect>) inputParameter1,(int[]) inputParameter2);
					setRun=null;
					break;
				case SETCOUNCILPRIVILEGE:
					setCouncilPrivilege((int) inputParameter1);
					setRun=null;
					break;
				case SETREQUESTEDAUTHORIZATIONEFFECTS:
					setRequestedAuthorizationEffects((List<Effect>) inputParameter1);
					setRun=null;
					break;
				case SETDISCOUNT:
					setDiscount((List<Resource>) inputParameter1);
					setRun=null;
					break;
				case EXCOMMUNICATIONMANAGEMENT:
					excommunicationManagement((String) inputParameter1,(String) inputParameter2);
					setRun=null;
					break;
				default:
					break;
				}
				
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			whileSecurity.set(true);
			while(true){				
			}
		}
	}
	
	public synchronized void chooseAction() throws RemoteException{
		printStateOfTheGame(state);
		String input = new String();
		
		print("Choose an area between:"); 
		print("1)TOWER");
		print("2)MARKET");
		print("3)PRODUCTION");
		print("4)HARVEST");
		print("5)COUNCIL PALACE");
		print("0)PASS TURN");
		String area = getInput();
		if(SupportFunctions.timeout(area, this))
			return;
		if (!SupportFunctions.isInputValid(area, 0, 5)) {
			chooseAction();
			return;
		}
		if ("0 ".equals(area))
			passTurn();
		else if ("1 ".equals(area)) {
			input += "TOWER ";
			input += chooseATower();
			input += chooseACard();
			input += chooseDice();
			input += chooseNrOfServants();
			
			serverStub.notifyObserversARemote(input);
			
		}
		else if ("2 ".equals(area)) {
			input += "MARKET ";
			input += chooseDice();
			input += chooseNrOfServants();
			input += chooseAShop();
			
			serverStub.notifyObserversARemote(input);
		}else {
			if ("3 ".equals(area))
				input += "PRODUCTION ";
			if ("4 ".equals(area))
				input += "HARVEST ";
			if ("5 ".equals(area))
				input += "COUNCILPALACE ";
			input += chooseDice();
			input += chooseNrOfServants();
			
			serverStub.notifyObserversARemote(input);	
		}
	}//TODO AGGIUSTARE INTERPRETE

	private synchronized String chooseAShop() {
		print("Choose a shop between 1, 2, 3, 4"); 
		String actSpace = getInput();
		if(SupportFunctions.timeout(actSpace, this))
			return actSpace;
		if (!SupportFunctions.isInputValid(actSpace, 1, 4)) {
			return chooseAShop();
		}
		return actSpace;
	}


	private synchronized String chooseDice() {
		String input;
		print("Choose the dice that you want to use between:");
		print("1)BLACK");
		print("2)ORANGE");
		print("3)WHITE");
		print("4)NEUTRAL");
		input = getInput();
		if(SupportFunctions.timeout(input, this))
			return input;
		if (!SupportFunctions.isInputValid(input, 1, 4)) {
			return chooseDice();
			
		}
		return input;
	}


	public synchronized void setCouncilPrivilege(int nrOfPrivileges) throws RemoteException {
		String privileges = "COUNCIL ";
		while (nrOfPrivileges > 0) {
			print("Choose your privilege between:");
			print("1) 1 Stone and 1 Wood");
			print("2) 2 Servants");
			print("3) 2 Coins");
			print("4) 2 Military Points");
			print("5) 1 Faith Point");
		
			String resource =getInput();
			if(SupportFunctions.timeout(resource, this)) {
				serverStub.notifyObserversARemote(privileges);
				return;
			}
			else if (!SupportFunctions.isInputValid(resource, 1, 5)) {
				privileges += "1 ";
			}else {
				privileges += resource+" ";
			}
			nrOfPrivileges--;
		}
		serverStub.notifyObserversRRemote(privileges);
	}
	
	public synchronized void setRequestedAuthorizationEffects(List<Effect> effects) throws RemoteException {
		String output = "AUTHORIZATION";
		if (effects.isEmpty())
			serverStub.notifyObserversRRemote(output);
		String input = new String();
		int effectCounter = 1;
		print("Which of these effects do you want to activate?");
		print("After every number, press Enter");
		print("When you have finished, type OK and press Enter");
		print("");
		
		for(Effect eff:effects) {
			if (eff instanceof ExchangeResourcesEffect) {
				if (((ExchangeResourcesEffect) eff).getCost2() == null) {
					String cost = "";
					String effect = "";
					cost = cost + calculateCost(((ExchangeResourcesEffect) eff).getChosenCost());
					effect = effect + calculateEffect(((ExchangeResourcesEffect) eff).getEffect());			
					print(effectCounter+")Pay "+cost+" to receive "+effect);	
					effectCounter++;	
			
				}else {
					String cost1;
					String effect1;
					String cost2;
					String effect2;
					cost1 = calculateCost(((ExchangeResourcesEffect) eff).getCost1());
					effect1 = calculateEffect(((ExchangeResourcesEffect) eff).getEffect1());
					cost2 = calculateCost(((ExchangeResourcesEffect) eff).getCost2());
					effect2 = calculateEffect(((ExchangeResourcesEffect) eff).getEffect2());
					print(effectCounter+")Pay "+cost1+" to receive "+effect1+" or pay "+cost2+" to receive "+effect2);	
					effectCounter++;	
			
				}
			}else if (eff instanceof TakeACardEffect) {
				int value = ((TakeACardEffect) eff).getDice().getValue();
				if (((TakeACardEffect) eff).getCardType() == null) {
					print(effectCounter+")Take a card with dice value "+value+" from any tower");
					effectCounter++;	
				}else {
					String cardType = ((TakeACardEffect) eff).getCardType().getClass().getSimpleName(); 
					print(effectCounter+")Take a "+cardType+ " with dice value "+value);
					effectCounter++;
				}
			}else {
				serverStub.notifyObserversRRemote(output);
			}
			
		}
		
		while(true) {
			input = getInput();
			if(SupportFunctions.timeout(input, this))
				serverStub.notifyObserversRRemote(output);
			if (input.equalsIgnoreCase("OK"))
				break;
			
			if (!SupportFunctions.isInputValid(input, 1, effectCounter -1)) {
				setRequestedAuthorizationEffects(effects);
				return;
			}
			
			output = output+ " " +input;
		}
		
		serverStub.notifyObserversRRemote(output);
	
	}
	
	private synchronized String chooseExchangeResourcesEffect(Effect effect) throws RemoteException {
		String input;
		String cost1;
		String effect1;
		String cost2;
		String effect2;
		cost1 = calculateCost(((ExchangeResourcesEffect) effect).getCost1());
		effect1 = calculateEffect(((ExchangeResourcesEffect) effect).getEffect1());
		cost2 = calculateCost(((ExchangeResourcesEffect) effect).getCost2());
		effect2 = calculateEffect(((ExchangeResourcesEffect) effect).getEffect2());
		print("1)Pay "+cost1+" to receive "+effect1);
		print("2)Pay "+cost2+" to receive "+effect2);	
		input = getInput();
		if(SupportFunctions.timeout(input, this))
			serverStub.notifyObserversRRemote(input);
		if (!SupportFunctions.isInputValid(input, 1, 2)) {
			return chooseExchangeResourcesEffect(effect);
		}
		return input;
	}


	public synchronized void setFurtherCheckNeededEffect(List<Effect> rAE, int[] fCN) throws RemoteException {
		
		/*rAE = RequestedAuthorizationEffects
		 *fCN = FurtherCheckNeededEffect -> it contains the indices of the effects of rAE that need a player choice
		 */
		String input = "CHECKNEEDED ";
		print("Which of these options do you want to activate?");
		print("After every number, press Enter");
		print("");
		
		int cont = 0;
		
		while (cont < fCN.length) {
			Effect effect = rAE.get(fCN[cont]);
			if (effect instanceof ExchangeResourcesEffect) {
				input += "RESOURCE ";
				chooseExchangeResourcesEffect(effect);
		
			}
			else if (effect instanceof TakeACardEffect) {
				input += "CARD ";
				if (((TakeACardEffect) effect).getCardType() == null) 
					input += chooseATower();
				else 
					input += "DEFAULT ";
				input += chooseACard();
				input += chooseNrOfServants();
			}
			
			cont++;
		}
		serverStub.notifyObserversRRemote(input);
	}
	
	private synchronized String chooseNrOfServants() {
		String input;
	
		print("How many servants do you want to use?");

		input = getInput();
		if(SupportFunctions.timeout(input, this))
			return input;			
		if (!SupportFunctions.isInputValid(input, 0, 100)) {
			return chooseNrOfServants();
		}
		return input;
	}


	public synchronized String calculateCost(List<Resource> costs) {
		String cost = new String();
		int costQuantity;
		String costType;
		
		for (int i = 0; i < costs.size(); i++) {
			costQuantity = costs.get(i).getQuantity();
			costType = costs.get(i).getClass().getSimpleName();
			cost = cost +" "+ costQuantity +" "+ costType;
		}
		return cost;
	}
			
	private synchronized String calculateEffect(List<ResourceEffect> list) {
		String effect = new String();
		int effectQuantity;
		String effectType;
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getClass().equals(CouncilPrivilege.class)) {
				effectQuantity = 1;
				effectType = "CouncilPrivilege";
				effect = effect +" "+ effectQuantity +" "+ effectType;
			}else {
				for (int j = 0; j < list.get(i).getEffect().size(); j++) {
					effectQuantity = list.get(i).getEffect().get(j).getQuantity();
					effectType = list.get(i).getEffect().get(j).getClass().getSimpleName();
					effect = effect +" "+ effectQuantity +" "+ effectType;
				}
			}
		}
		return effect;
		
	}	
	public synchronized void setDiscount(List<Resource> rawMaterials) throws RemoteException {
		String input = "DISCOUNT ";
		
		for (int i = 0; i < rawMaterials.size(); i++) {
			print("You can choose between two discounts, what do you prefer?");
			print("1) "+ rawMaterials.get(i).getQuantity() +" Stone");
			print("2) "+ rawMaterials.get(i).getQuantity() +" Wood");
		
			input += getInput();
			if(SupportFunctions.timeout(input, this))
				serverStub.notifyObserversRRemote(input);
			if (!SupportFunctions.isInputValid(input, 1, 2)) {
				input += "1 ";	
			}
		}
		serverStub.notifyObserversRRemote(input);
	}

	public void printStateOfTheGame(String state) {
		print(state);
		
	}


	public synchronized String chooseATower() {
		String input;
		
		print("1)Take a card from Territory Tower");
		print("2)Take a card from Character Tower");
		print("3)Take a card from Building Tower");
		print("4)Take a card from Venture Tower");
		input = getInput();
		if(SupportFunctions.timeout(input, this))
			return input;
		if (!SupportFunctions.isInputValid(input, 1, 4)) {
			return chooseATower();
		}
		return input;
	}
		
	public synchronized String chooseACard() {
		String input;
		print("Choose a card between 1,2,3,4, then  press Enter");
		
		input = getInput();
		if(SupportFunctions.timeout(input, this))
			return input;
		if (!SupportFunctions.isInputValid(input, 1, 4)) {
			return chooseACard();
		}

		print("Which cost do you want to pay?");
		print("If there's only one cost available, type 1 and press Enter");
		
		String cost = getInput();
		
		if(SupportFunctions.timeout(input, this))
			return input;
	
		if (!SupportFunctions.isInputValid(cost, 1, 2)) {
			return chooseACard();
		}
		input += cost;
		
		return input;
	}
	public synchronized void excommunicationManagement(String description, String username) throws RemoteException {
		String input = "EXCOMMUNICATION "+username+" ";
		
		print("\n\nPERIOD EXCOMMUNICATION:\n\n");
		print(description);
		print("\n1)Suffer the Excommunication");
		print("\n2)Support the Church");
		
		String answer = getInput();
		
		if(SupportFunctions.timeout(input, this))
			serverStub.notifyObserversRRemote("1 ");
	
		if (!SupportFunctions.isInputValid(answer, 1, 2)) {
			excommunicationManagement(description,username);
			return;
		}
		
		input += answer;
		
		serverStub.notifyObserversRRemote(input);
	}
		
	

	
}
