package it.polimi.ingsw.GC_04.view;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import it.polimi.ingsw.GC_04.model.effect.CouncilPrivilege;
import it.polimi.ingsw.GC_04.model.effect.Effect;
import it.polimi.ingsw.GC_04.model.effect.ExchangeResourcesEffect;
import it.polimi.ingsw.GC_04.model.action.Action;
import it.polimi.ingsw.GC_04.model.resource.Resource;

public class ViewCLI extends View{
	
	
	public static void print(String string) {
		System.out.println(string);
	}
	
	public void chooseAction(){
		Scanner in = new Scanner(System.in);
		print("Scegli un'area tra"); 
		print("1)TOWER");
		print("2)MARKET");
		print("3)PRODUCTION");
		print("4)HARVEST");
		print("5)COUNCIL PALACE");
		String area = in.nextLine();
		if (area.equalsIgnoreCase("TOWER")) {
			print("Scegli la torre tra ");
			print("1)TERRITORY");
			print("2)BUILDING");
			print("3)VENTURE");
			print("4)CHARACTER");
			String tower = in.nextLine();
			print("Scegli la carta tra 1, 2, 3, 4");
			String nrOfCard = in.nextLine();
			print("Scegli il dado che vuoi usare tra ");
			print("1)BLACK");
			print("2)ORANGE");
			print("3)WHITE");
			print("4)NEUTRAL");
			String diceColor = in.nextLine();
			print("Quanti servants vuoi usare per questa mossa?");
			String nrOfServants = in.nextLine();
			print("Scegli, se previsto, quale costo vuoi pagare per questa carta tra 1, 2");
			print("Se non è prevista una scelta premi 1");
			String cost = in.nextLine();
			try {
				input(tower, nrOfCard, diceColor, nrOfServants, cost);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (area.equalsIgnoreCase("MARKET")) {
			print("Scegli il dado che vuoi usare tra ");
			print("1)BLACK");
			print("2)ORANGE");
			print("3)WHITE");
			print("4)NEUTRAL");
			String diceColor = in.nextLine();
			print("Scegli lo shop tra 1, 2, 3, 4"); //in realtà di pende dal numero di giocatori
			String actSpace = in.nextLine();
			print("Quanti servants vuoi usare per questa mossa?");
			String nrOfServants = in.nextLine();
			input(area, diceColor, actSpace, nrOfServants);
		}else {
			print("Scegli il dado che vuoi usare tra ");
			print("1)BLACK");
			print("2)ORANGE");
			print("3)WHITE");
			print("4)NEUTRAL");
			String diceColor = in.nextLine();
			print("Quanti servants vuoi usare per questa mossa?");
			String nrOfServants = in.nextLine();
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
		
		try {
			return input(resource);
		} catch (IOException e) {
			print("Your input is wrong.");
			return setCouncilPrivilege();
		}
		
		
		
	}
	
	public void setRequestedAuthorizationEffects(List<Effect> effects) {
		
		int effectCounter = 1;
		print("Which of these effects do you want to activate?");
		print("After every number, press Enter");
		print("When you have finished, type OK and press Enter");
		
		for(Effect eff:effects) {
			if (eff instanceof ExchangeResourcesEffect) {
				if (((ExchangeResourcesEffect) eff).getCost2() == null) {
					int costQuantity;
					int effectQuantity;
					String costType;
					String effectType;
					String cost = new String();
					String effect = new String();
					for (int i = 0; i < ((ExchangeResourcesEffect) eff).getChosenCost().size(); i++) {
						costQuantity = ((ExchangeResourcesEffect) eff).getChosenCost().get(i).getQuantity();
						costType = ((ExchangeResourcesEffect) eff).getChosenCost().get(i).getClass().getSimpleName();
						cost = cost +" "+ costQuantity +" "+ costType;
					}
					for (int i = 0; i < ((ExchangeResourcesEffect) eff).getEffect().size(); i++) {
						if (((ExchangeResourcesEffect) eff).getEffect().get(i).getClass().equals(CouncilPrivilege.class)) {
							effectQuantity = 1;
							effectType = "Council Privilege";
							effect = effect +" "+ effectQuantity +" "+ effectType;
						}else {
							for (int j = 0; j < ((ExchangeResourcesEffect) eff).getEffect().get(i).getEffect().size(); j++) {
								effectQuantity = ((ExchangeResourcesEffect) eff).getEffect().get(i).getEffect().get(j).getQuantity();
								effectType = ((ExchangeResourcesEffect) eff).getEffect().get(i).getEffect().get(j).getClass().getSimpleName();
								effect = effect +" "+ effectQuantity +" "+ effectType;
							}
						}
						
							
					}
					print(effectCounter+")Pay "+cost+" to receive "+effect);	
					effectCounter++;
			
				}
			}
		}
	}
			
			
			
		
		
	

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAction(Action action) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateResource(Resource resource) {
		// TODO Auto-generated method stub
		
	}
}
