package it.polimi.ingsw.GC_04.server.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import it.polimi.ingsw.GC_04.server.model.ActionSpace;
import it.polimi.ingsw.GC_04.server.model.DiceColor;
import it.polimi.ingsw.GC_04.server.model.FamilyMember;
import it.polimi.ingsw.GC_04.server.model.Model;
import it.polimi.ingsw.GC_04.server.model.Player;
import it.polimi.ingsw.GC_04.server.model.action.Action;
import it.polimi.ingsw.GC_04.server.model.action.GoToTheCouncilPalace;
import it.polimi.ingsw.GC_04.server.model.action.GoToTheMarket;
import it.polimi.ingsw.GC_04.server.model.action.PassTurn;
import it.polimi.ingsw.GC_04.server.model.action.RunHarvest;
import it.polimi.ingsw.GC_04.server.model.action.RunProduction;
import it.polimi.ingsw.GC_04.server.model.area.Area;
import it.polimi.ingsw.GC_04.server.model.area.Tower;
import it.polimi.ingsw.GC_04.server.model.card.BuildingCard;
import it.polimi.ingsw.GC_04.server.model.card.CharacterCard;
import it.polimi.ingsw.GC_04.server.model.card.DevelopmentCard;
import it.polimi.ingsw.GC_04.server.model.card.TerritoryCard;
import it.polimi.ingsw.GC_04.server.model.card.VentureCard;
import it.polimi.ingsw.GC_04.server.model.resource.Resource;

/*
 * this class is used by the controller to interpret the String received from the player 
 * with the update methods 
 */
public class InputActionInterpreter {
	private Action action;
	private Model model;
	private Player player;
	String area;
	String tower;
	String nrOfCard;
	String cost;
	String diceColor;
	String nrOfServants;
	String actSpace;

	InputActionInterpreter(String input, Model model, Player player) {
		this.model = model;
		this.player = player;
		StringTokenizer strTok = new StringTokenizer(input);

		area = strTok.nextToken();
		int cont = strTok.countTokens();

		if (area.equals("TOWER")) {
			if (cont != 5)
				this.action = new PassTurn();
			tower = strTok.nextToken();
			nrOfCard = strTok.nextToken();
			cost = strTok.nextToken();
			diceColor = strTok.nextToken();
			nrOfServants = strTok.nextToken();

		} else if (area.equals("MARKET")) {
			if (cont != 3)
				this.action = new PassTurn();
			diceColor = strTok.nextToken();
			nrOfServants = strTok.nextToken();
			actSpace = strTok.nextToken();

		} else if (area.equals("PRODUCTION") || area.equals("HARVEST") || area.equals("COUNCILPALACE")) {
			if (cont != 2)
				this.action = new PassTurn();
			diceColor = strTok.nextToken();
			nrOfServants = strTok.nextToken();
		} else if (area.equals("0")) {
			this.action = new PassTurn();
		}
	}

	public void otherActions(String area, String diceColor, String nrOfServants) {

		FamilyMember fMember = player.getFamilyMember(DiceColor.fromString(diceColor));
		int servants = Integer.parseInt(nrOfServants);

		if ("PRODUCTION".equals(area))
			this.action = new RunProduction(model, player, fMember, servants);
		else if ("HARVEST".equals(area))
			this.action = new RunHarvest(model, player, fMember, servants);
		else
			this.action = new GoToTheCouncilPalace(model, player, fMember, servants);

	}

	public void goToTheMarket(String diceColor, String actSpace, String nrOfServants) {
		ActionSpace realASpace;
		Area realArea;

		FamilyMember fMember = player.getFamilyMember(DiceColor.fromString(diceColor));
		int aSpace = Integer.parseInt(actSpace) - 1;
		int servants = Integer.parseInt(nrOfServants);

		realArea = model.getMarket();
		realASpace = realArea.getASpaces().get(aSpace);
		this.action = new GoToTheMarket(model, player, fMember, servants, realASpace);

	}

	public void takeACard(String tower, String nrOfCard, String diceColor, String nrOfServants, String cost) {
		Tower realTower;
		ActionSpace realASpace;
		DevelopmentCard realCard;
		List<Resource> realCost = new ArrayList<>();

		FamilyMember fMember = player.getFamilyMember(DiceColor.fromString(diceColor));

		int card = Integer.parseInt(nrOfCard) - 1;
		int servants = Integer.parseInt(nrOfServants);

		if ("1".equals(tower)) {
			realTower = model.getTower(new TerritoryCard());
		} else if ("2".equals(tower)) {
			realTower = model.getTower(new CharacterCard());
		} else if ("3".equals(tower)) {
			realTower = model.getTower(new BuildingCard());
		} else
			realTower = model.getTower(new VentureCard());

		realCard = realTower.getCards()[card];

		if (realCard.getCost1() == null && realCard.getCost2() == null)
			realCost = null;
		else if (realCard.getCost2() == null)
			realCost = realCard.getCost1();
		else {
			if (!SupportFunctions.isInputValid(cost, 1, 2)) {
				return;
			} else {
				int chosenCost = Integer.parseInt(cost);

				if (chosenCost == 1)
					realCost = realCard.getCost1();
				if (chosenCost == 2)
					realCost = realCard.getCost2();
			}
		}
		realASpace = realTower.getASpaces().get(card);
		this.action = realCard.takeCard(model, player, realASpace, fMember, servants, realCost);
	
	}

	public Action getAction() {
		if (area.equals("TOWER"))
			takeACard(tower, nrOfCard, diceColor, nrOfServants, cost);
		else if (area.equals("MARKET"))
			goToTheMarket(diceColor, actSpace, nrOfServants);
		else if (area.equals("PRODUCTION") || area.equals("HARVEST") || area.equals("COUNCILPALACE"))
			otherActions(area, diceColor, nrOfServants);
		return action;

	}

}
