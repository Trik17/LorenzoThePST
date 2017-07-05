package it.polimi.ingsw.GC_04.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import it.polimi.ingsw.GC_04.model.ActionSpace;
import it.polimi.ingsw.GC_04.model.Model;
import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.area.Tower;
import it.polimi.ingsw.GC_04.model.card.BuildingCard;
import it.polimi.ingsw.GC_04.model.card.CharacterCard;
import it.polimi.ingsw.GC_04.model.card.DevelopmentCard;
import it.polimi.ingsw.GC_04.model.card.TerritoryCard;
import it.polimi.ingsw.GC_04.model.card.VentureCard;
import it.polimi.ingsw.GC_04.model.effect.*;
import it.polimi.ingsw.GC_04.model.resource.Coins;
import it.polimi.ingsw.GC_04.model.resource.FaithPoints;
import it.polimi.ingsw.GC_04.model.resource.MilitaryPoints;
import it.polimi.ingsw.GC_04.model.resource.RawMaterial;
import it.polimi.ingsw.GC_04.model.resource.Resource;
import it.polimi.ingsw.GC_04.model.resource.Servants;

public class InputChoicesInterpreter {
	private String type;
	List<Effect> effects;
	List<Resource> resources;
	int[] requestedEffects;

	public InputChoicesInterpreter(String input) {
		this.resources = new ArrayList<>();
		this.effects = new ArrayList<>();
	
		StringTokenizer strTok = new StringTokenizer(input);
		
		this.type = strTok.nextToken();
		
		if (type.equals("COUNCIL")) {
			while (strTok.hasMoreTokens()) 
				input(strTok.nextToken());
		}
		else if (type.equals("AUTHORIZATION")) {
			requestedEffects = SupportFunctions.parseIntArray(input);
		
		}	
	}

	public InputChoicesInterpreter(Model model, Player player, String input, List<Effect> rAE, int[] fCN) {
		effects = rAE;
		requestedEffects = fCN;
		
		checkNeededInterpreter(model, player, input, rAE, fCN);
	}
	
	public void checkNeededInterpreter(Model model, Player player, String input,List<Effect> rAE, int[] fCN) {
		/*rAE = RequestedAuthorizationEffects
		 *fCN = FurtherCheckNeededEffect -> it contains the indices of the effects of rAE that player has chosen
		 */
		StringTokenizer strTok = new StringTokenizer(input);
		strTok.nextToken(); //the first token is "CHECKNEEDED" and I don't need it anymore
		
		int cont = 0;
		
		Tower tower;
		DevelopmentCard card;
		ActionSpace aSpace;
		int servants;
		List<Resource> cost;
		
		while (strTok.hasMoreTokens()) {
			String effectType = strTok.nextToken();
			Effect effect = rAE.get(fCN[cont]);
			
			if (effectType.equals("RESOURCE"))
				try {
					int choice = Integer.parseInt(strTok.nextToken());
					if (choice == 1)
						((ExchangeResourcesEffect) effect).setEffect(((ExchangeResourcesEffect) effect).getEffect1(), ((ExchangeResourcesEffect) effect).getCost1());
					else
						((ExchangeResourcesEffect) effect).setEffect(((ExchangeResourcesEffect) effect).getEffect2(), ((ExchangeResourcesEffect) effect).getCost2());	
					
					cont++;
				
				} catch (Exception e) {
					// TODO: handle exception
				}
			else if (effectType.equals("CARD")) {
				String towerString = strTok.nextToken();
				
				try {
					if (towerString.equals("DEFAULT")) {
						tower = model.getTower(((TakeACardEffect) effect).getCardType());
					}else {
				
						int towerInt = Integer.parseInt(towerString);
						
						switch (towerInt) {
						case 1:
							tower = model.getTower(new TerritoryCard());
							break;
						case 2:
							tower = model.getTower(new CharacterCard());
							break;
						case 3:
							tower = model.getTower(new BuildingCard());
							break;
						default:
							tower = model.getTower(new VentureCard());
							break;
						}
						
						card = tower.getCards()[Integer.parseInt(strTok.nextToken()) -1];
						aSpace = tower.getASpaces().get(Integer.parseInt(strTok.nextToken()) -1);
						servants = Integer.parseInt(strTok.nextToken());
						
						if (Integer.parseInt(strTok.nextToken()) == 1)
							cost = card.getCost1();
						else
							cost = card.getCost2();
						
						((TakeACardEffect) effect).setParameters(model,player,card,aSpace,servants,cost);
						
					}
				}catch (Exception e) {
						// TODO: handle exception PASS TURNNNNNNNNNNNNNNNNN
				}
					
			}
				
			
		}
	}
	
	public void input(String privilege) {
		
		Resource resource;
		
		if ("1".equals(privilege))
			resource = new RawMaterial(1);
		else if ("2".equals(privilege))
			resource = new Servants(2);
		else if ("3".equals(privilege))
			resource = new Coins(2);
		else if ("4".equals(privilege))
			resource = new MilitaryPoints(2);
		else
			resource = new FaithPoints(1);
		
		Effect cP = new CouncilPrivilege();
		((CouncilPrivilege) cP).setCouncilPrivilege(resource);
		effects.add(cP);
	}

	public String getType() {
		return type;
	}
	
	public List<Resource> getResources() {
		return resources;
		
	}
	public List<Effect> getEffects() {
		return effects;
		
	}
	public int[] getRequestedEffects() {
		return requestedEffects;
		
	}
}
