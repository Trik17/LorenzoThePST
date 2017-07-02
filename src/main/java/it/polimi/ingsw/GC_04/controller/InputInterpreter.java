package it.polimi.ingsw.GC_04.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import it.polimi.ingsw.GC_04.model.ActionSpace;
import it.polimi.ingsw.GC_04.model.DiceColor;
import it.polimi.ingsw.GC_04.model.FamilyMember;
import it.polimi.ingsw.GC_04.model.Model;
import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.action.Action;
import it.polimi.ingsw.GC_04.model.action.ErrorInput;
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
import it.polimi.ingsw.GC_04.model.card.BuildingCard;
import it.polimi.ingsw.GC_04.model.card.CharacterCard;
import it.polimi.ingsw.GC_04.model.card.DevelopmentCard;
import it.polimi.ingsw.GC_04.model.card.TerritoryCard;
import it.polimi.ingsw.GC_04.model.card.VentureCard;
import it.polimi.ingsw.GC_04.model.resource.Coins;
import it.polimi.ingsw.GC_04.model.resource.FaithPoints;
import it.polimi.ingsw.GC_04.model.resource.MilitaryPoints;
import it.polimi.ingsw.GC_04.model.resource.RawMaterial;
import it.polimi.ingsw.GC_04.model.resource.Resource;
import it.polimi.ingsw.GC_04.model.resource.Servants;

public class InputInterpreter {
	private Action action;
	private Model model;
	private Player player;
	
	InputInterpreter(String input, Model model, Player player){
		this.model = model;
		this.player = player;
		StringTokenizer strTok = new StringTokenizer(input);
		
		int cont = strTok.countTokens();
		
		if (cont == 5) {
			String tower = strTok.nextToken();
			String nrOfCard = strTok.nextToken();
			String diceColor = strTok.nextToken();
			String nrOfServants = strTok.nextToken();
			String cost = strTok.nextToken();
			input(tower,nrOfCard,diceColor,nrOfServants,cost);
		}
		else if (cont == 4) {
			String area = strTok.nextToken();
			String diceColor = strTok.nextToken();
			String actSpace = strTok.nextToken();
			String nrOfServants = strTok.nextToken();
			input(area, diceColor, actSpace, nrOfServants);
		}
		else if (cont == 3) {
			String area = strTok.nextToken();
			String diceColor = strTok.nextToken();
			String nrOfServants = strTok.nextToken();
			input(area, diceColor, nrOfServants);
		}
		else if (cont == 1) {
			this.action = new PassTurn();
		}
	}

	
	
	public void input(String area, String diceColor, String nrOfServants) {
		
		FamilyMember fMember = player.getFamilyMember(DiceColor.fromString(diceColor));
		int servants = Integer.parseInt(nrOfServants);
		
		if ("3".equals(area)) 
			this.action = new RunProduction(model,player, fMember, servants);
		else if ("4".equals(area))
			this.action = new RunHarvest(model,player, fMember, servants);
		else
			this.action = new GoToTheCouncilPalace(model,player, fMember, servants);
	
	}
	
	public void input(String area, String diceColor, String actSpace, String nrOfServants) {
		ActionSpace realASpace;
		Area realArea;
		
		FamilyMember fMember = player.getFamilyMember(DiceColor.fromString(diceColor));
		int aSpace = Integer.parseInt(actSpace)-1; 
		int servants = Integer.parseInt(nrOfServants); 
		
		realArea = model.getMarket();
		realASpace = realArea.getASpaces().get(aSpace);
		this.action = new GoToTheMarket(model,player, fMember, servants, realASpace);
		
	}
	
	public void input(String tower,String nrOfCard, String diceColor, String nrOfServants, String cost) {
		Tower realTower;
		ActionSpace realASpace;
		DevelopmentCard realCard;
		List<Resource> realCost = new ArrayList<>();
		
		FamilyMember fMember = player.getFamilyMember(DiceColor.fromString(diceColor));
	
		int card = Integer.parseInt(nrOfCard)-1; 
		int servants = Integer.parseInt(nrOfServants); 
		
		if("1".equals(tower)) {
			realTower = model.getTower(new TerritoryCard());
		}
		else if("2".equals(tower)) {
			realTower = model.getTower(new CharacterCard());
		}
		else if("3".equals(tower)) {
			realTower = model.getTower(new BuildingCard());
		}
		else 
			realTower = model.getTower(new VentureCard());
			
		realCard = realTower.getCards()[card];
		
		if (realCard.getCost1() == null && realCard.getCost2() == null)
			realCost = null;
		else if (realCard.getCost2() == null)
			realCost = realCard.getCost1();
		else {
			if (!SupportFunctions.isInputValid(cost, 1, 2)) {
				this.action = new ErrorInput();
				return;
			}
			else{
				int chosenCost = Integer.parseInt(cost);
			
				if (chosenCost == 1)
					realCost = realCard.getCost1();
				if (chosenCost == 2)
					realCost = realCard.getCost2();
			}
		}
		realASpace = realTower.getASpaces().get(card);
		
		this.action = realCard.takeCard(model,player, realASpace, fMember, servants, realCost);
		
		
	}

	
	
	
//	public void input(String passTurn) {}
	
	public Resource input(String privilege) {
		
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
		
		return resource;
			
	}
	
	public Action getAction() {
		return action;
		
	}
	
}
