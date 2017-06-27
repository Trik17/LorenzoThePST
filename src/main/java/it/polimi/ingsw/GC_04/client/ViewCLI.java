package it.polimi.ingsw.GC_04.client;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Scanner;

import it.polimi.ingsw.GC_04.model.effect.CouncilPrivilege;
import it.polimi.ingsw.GC_04.model.effect.Effect;
import it.polimi.ingsw.GC_04.model.effect.ExchangeResourcesEffect;
import it.polimi.ingsw.GC_04.model.effect.ResourceEffect;
import it.polimi.ingsw.GC_04.model.effect.TakeACardEffect;
import it.polimi.ingsw.GC_04.controller.SupportFunctions;
import it.polimi.ingsw.GC_04.model.action.Action;
import it.polimi.ingsw.GC_04.model.action.PassTurn;
import it.polimi.ingsw.GC_04.model.resource.Resource;
import it.polimi.ingsw.GC_04.model.resource.Stones;
import it.polimi.ingsw.GC_04.model.resource.Woods;
import it.polimi.ingsw.GC_04.view.ServerRMIViewRemote;

public class ViewCLI extends ViewClient{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2328795643634959640L;
	
	private void print(String string) {
		System.out.println(string);
	}
	
	public void chooseAction(){
		Scanner in = new Scanner(System.in);
		String diceColor;
		String nrOfServants;
		print("Choose an area between:"); 
		print("1)TOWER");
		print("2)MARKET");
		print("3)PRODUCTION");
		print("4)HARVEST");
		print("5)COUNCIL PALACE");
		print("0)PASS TURN");
		String area = in.nextLine();
		if (!SupportFunctions.isInputValid(area, 0, 5)) {
			chooseAction();
			return;
		}
		if ("0".equals(area))
			passTurn();
		if ("1".equals(area)) {
			print("Choose a tower between:");
			print("1)TERRITORY");
			print("2)CHARACTER");
			print("3)BUILDING");
			print("4)VENTURE");
			String tower = in.nextLine();
			if (!SupportFunctions.isInputValid(tower, 1, 4)) {
				chooseAction();
				return;
			}
			print("Choose a card between 1,2,3,4 (starting from the bottom), then  press Enter");
			String nrOfCard = in.nextLine();
			if (!SupportFunctions.isInputValid(nrOfCard, 1, 4)) {
				chooseAction();
				return;
			}
			print("Choose the dice that you want to use between:");
			print("1)BLACK");
			print("2)ORANGE");
			print("3)WHITE");
			print("4)NEUTRAL");
			diceColor = in.nextLine();
			if (!SupportFunctions.isInputValid(diceColor, 1, 4)) {
				chooseAction();
				return;
			}
			print("How many servants do you want to use?");
			nrOfServants = in.nextLine();
			if (!SupportFunctions.isInputValid(nrOfServants, 0, 100)) {
				chooseAction();
				return;
			}
			print("Which cost do you want to pay?");
			print("If there's only one cost available, press any key");
			String cost = in.nextLine();
			
			input(tower, nrOfCard, diceColor, nrOfServants, cost);
			
		}
		else if ("2".equals(area)) {
			print("Choose the dice that you want to use between:");
			print("1)BLACK");
			print("2)ORANGE");
			print("3)WHITE");
			print("4)NEUTRAL");
			diceColor = in.nextLine();
			if (!SupportFunctions.isInputValid(diceColor, 1, 4)) {
				chooseAction();
				return;
			}
			print("How many servants do you want to use?");
			nrOfServants = in.nextLine();
			if (!SupportFunctions.isInputValid(nrOfServants, 0, 100)) {
				chooseAction();
				return;
			}
			print("Choose a shop between 1, 2, 3, 4"); 
			String actSpace = in.nextLine();
			if (!SupportFunctions.isInputValid(diceColor, 1, 4)) {
				chooseAction();
				return;
			}
			input(area, diceColor, actSpace, nrOfServants);
		}else {
			print("Choose the dice that you want to use between:");
			print("1)BLACK");
			print("2)ORANGE");
			print("3)WHITE");
			print("4)NEUTRAL");
			diceColor = in.nextLine();
			if (!SupportFunctions.isInputValid(diceColor, 1, 4)) {
				chooseAction();
				return;
			}
			print("How many servants do you want to use?");
			nrOfServants = in.nextLine();
			if (!SupportFunctions.isInputValid(nrOfServants, 0, 100)) {
				chooseAction();
				return;
			}
			
			input(area, diceColor, nrOfServants);	
		}
	}

	public Resource setCouncilPrivilege() {
		Scanner in = new Scanner(System.in);
		print("Choose your privilege between:");
		print("1) 1 Stone and 1 Wood");
		print("2) 2 Servants");
		print("3) 2 Coins");
		print("4) 2 Military Points");
		print("5) 1 Faith Point");
		
		String resource = in.nextLine();
		if (!SupportFunctions.isInputValid(resource, 1, 5)) {
			return setCouncilPrivilege();
		}
		return input(resource);
		
		
		
	}
	
	public int[] setRequestedAuthorizationEffects(List<Effect> effects) {
		if (effects.isEmpty())
			return new int[0];
		Scanner in = new Scanner(System.in);
		String input = new String();
		String output = new String();
		int effectCounter = 1;
		print("Which of these effects do you want to activate?");
		print("After every number, press Enter");
		print("When you have finished, type OK and press Enter");
		print("");
		
		for(Effect eff:effects) {
			if (eff instanceof ExchangeResourcesEffect) {
				
				if (((ExchangeResourcesEffect) eff).getCost2() == null) {
					String cost = new String();
					String effect = new String();
					cost = cost + calculateCost(((ExchangeResourcesEffect) eff).getChosenCost());
					effect = effect + calculateEffect(((ExchangeResourcesEffect) eff).getEffect());			
					print(effectCounter+")Pay "+cost+" to receive "+effect);	
					effectCounter++;	
			
				}else {
					String cost1 = new String();
					String effect1 = new String();
					String cost2 = new String();
					String effect2 = new String();
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
				return new int[0];
			}
			
		}
		
		while(true) {
			input = in.nextLine();
			if (input.equalsIgnoreCase("OK"))
				break;
			
			if (!SupportFunctions.isInputValid(input, 1, effectCounter -1)) {
				return setRequestedAuthorizationEffects(effects);
			}
			
			output = output+ " " +input;
		}
		int[] out = SupportFunctions.parseIntArray(output);
		
		return out;
		
		
		
		
	}
	
	public int[] setFurtherCheckNeededEffect(Effect effect) {
		Scanner in = new Scanner(System.in);
		String input = new String();
		print("Which of these options do you want to activate?");
		print("After every number, press Enter");
		print("");
		
		if (effect instanceof ExchangeResourcesEffect) {
			String cost1 = new String();
			String effect1 = new String();
			String cost2 = new String();
			String effect2 = new String();
			cost1 = calculateCost(((ExchangeResourcesEffect) effect).getCost1());
			effect1 = calculateEffect(((ExchangeResourcesEffect) effect).getEffect1());
			cost2 = calculateCost(((ExchangeResourcesEffect) effect).getCost2());
			effect2 = calculateEffect(((ExchangeResourcesEffect) effect).getEffect2());
			print("1)Pay "+cost1+" to receive "+effect1);
			print("2)Pay "+cost2+" to receive "+effect2);	
			input = in.nextLine();
			if (!SupportFunctions.isInputValid(input, 1, 2)) {
				return setFurtherCheckNeededEffect(effect);
			}
			
		}
		else if (effect instanceof TakeACardEffect) {
			if (((TakeACardEffect) effect).getCardType() == null) {
				print("1)Take a card from Territory Tower");
				print("2)Take a card from Character Tower");
				print("3)Take a card from Building Tower");
				print("4)Take a card from Venture Tower");
				input = in.nextLine();
				if (!SupportFunctions.isInputValid(input, 1, 4)) {
					return setFurtherCheckNeededEffect(effect);
				}
			}
			print("Choose a card between 1,2,3,4 (starting from the bottom), then  press Enter");
			
			String string = in.nextLine();
			if (!SupportFunctions.isInputValid(input, 1, 4)) {
				return setFurtherCheckNeededEffect(effect);
			}
			input = input + " " + string;
			print("How many servants do you want to use?");

			string = in.nextLine();
			
			if (!SupportFunctions.isInputValid(input, 1, 100)) {
				return setFurtherCheckNeededEffect(effect);
			}
			
			input = input + " " + string;
			
			print("Which cost do you want to pay?");
			print("If there's only one cost available, type 1 and press Enter");
			
			string = in.nextLine();
			
			if (!SupportFunctions.isInputValid(input, 1, 2)) {
				return setFurtherCheckNeededEffect(effect);
			}
			
			input = input + " " + string;
		
		}
		
		int[] out = SupportFunctions.parseIntArray(input);
		return out;
		
		
	}
	
	public String calculateCost(List<Resource> costs) {
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
			
	private String calculateEffect(List<ResourceEffect> list) {
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
	public Resource setDiscount(Resource rawMaterial) {
		Scanner in = new Scanner(System.in);
		String input;
		print("You can choose between two discounts, what do you prefer?");
		print("1) "+ rawMaterial.getQuantity() +" Stone");
		print("2) "+ rawMaterial.getQuantity() +" Wood");
		
		input = in.nextLine();
		if (!SupportFunctions.isInputValid(input, 1, 2)) {
			return setDiscount(rawMaterial);	
		}
		if (Integer.parseInt(input) == 1) 
			return new Stones(rawMaterial.getQuantity());
		else
			return new Woods(rawMaterial.getQuantity());
		
	}


	


	
}
