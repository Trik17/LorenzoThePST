package it.polimi.ingsw.GC_04.view;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

import it.polimi.ingsw.GC_04.Observable;
import it.polimi.ingsw.GC_04.model.ActionSpace;
import it.polimi.ingsw.GC_04.model.DiceColor;
import it.polimi.ingsw.GC_04.model.FamilyMember;
import it.polimi.ingsw.GC_04.model.Model;
import it.polimi.ingsw.GC_04.model.Harvest;
import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.Production;
import it.polimi.ingsw.GC_04.model.action.Action;
import it.polimi.ingsw.GC_04.model.action.GoToTheCouncilPalace;
import it.polimi.ingsw.GC_04.model.action.GoToTheMarket;
import it.polimi.ingsw.GC_04.model.action.RunHarvest;
import it.polimi.ingsw.GC_04.model.action.RunProduction;
import it.polimi.ingsw.GC_04.model.action.TakeTerritory;
import it.polimi.ingsw.GC_04.model.area.Area;
import it.polimi.ingsw.GC_04.model.area.BuildingTower;
import it.polimi.ingsw.GC_04.model.area.CharacterTower;
import it.polimi.ingsw.GC_04.model.area.CouncilPalaceArea;
import it.polimi.ingsw.GC_04.model.area.HarvestArea;
import it.polimi.ingsw.GC_04.model.area.MarketArea;
import it.polimi.ingsw.GC_04.model.area.ProductionArea;
import it.polimi.ingsw.GC_04.model.area.TerritoryTower;
import it.polimi.ingsw.GC_04.model.area.Tower;
import it.polimi.ingsw.GC_04.model.area.VentureTower;
import it.polimi.ingsw.GC_04.model.card.BuildingCard;
import it.polimi.ingsw.GC_04.model.card.CharacterCard;
import it.polimi.ingsw.GC_04.model.card.DevelopmentCard;
import it.polimi.ingsw.GC_04.model.card.TerritoryCard;
import it.polimi.ingsw.GC_04.model.card.VentureCard;
import it.polimi.ingsw.GC_04.model.resource.*;


public abstract class View extends Observable<Action> {
	
	private int turn;
	
	public View() {
		turn = 0;
	}
	
	public abstract void chooseAction();
	
	private void nextPlayer() {//perché è qua???? ATTENZIONE
		int nrOfPlayer = Model.getPlayers().length;
		if (turn < nrOfPlayer)
			turn ++;
		else
			turn = 0;
	}
	
	
	public void input(String tower,String nrOfCard, String diceColor, String nrOfServants, String cost) throws IOException {
		Action action;
		Tower realTower;
		ActionSpace realASpace;
		DevelopmentCard realCard;
		List<Resource> realCost = new ArrayList<Resource>();
		Player player = CouncilPalaceArea.getTurnOrder()[turn];
		
		diceColor = diceColor.toUpperCase();
		
		try {
			FamilyMember fMember = player.getFamilyMember(DiceColor.fromString(diceColor));
			int card = Integer.parseInt(nrOfCard); 
			int servants = Integer.parseInt(nrOfServants); 
			int chosenCost = Integer.parseInt(cost);
			
			if(tower.equalsIgnoreCase("TERRYTORY")) {
				realTower = TerritoryTower.instance();
			}
			if(tower.equalsIgnoreCase("BUILDING")) {
				realTower = BuildingTower.instance();
			}
			if(tower.equalsIgnoreCase("VENTURE")) {
				realTower = VentureTower.instance();
			}
			if(tower.equalsIgnoreCase("CHARACTER")) {
				realTower = CharacterTower.instance();
			}else 
				throw new IOException();
			
			realCard = realTower.getCards()[card];
				
			if (chosenCost == 1)
				realCost = realCard.getCost1();
			if (chosenCost == 2)
				realCost = realCard.getCost2();
			realASpace = realTower.getASpaces().get(card);
			
			action = new TakeTerritory(player,realCard,realASpace,fMember,servants,realCost);
			this.notifyObservers(action);
		}catch (Exception e) {
			 e.printStackTrace();
		}
	}
	
	public void input(String area, String diceColor, String actSpace, String nrOfServants) {
		Player player = CouncilPalaceArea.getTurnOrder()[turn];
		ActionSpace realASpace;
		Area realArea;
		Action action;
		
		try {
			FamilyMember fMember = player.getFamilyMember(DiceColor.fromString(diceColor));
			int aSpace = Integer.parseInt(actSpace); 
			int servants = Integer.parseInt(nrOfServants); 
			
			if (area.equals("MARKET")) {
				realArea = MarketArea.instance();
				realASpace = realArea.getASpaces().get(aSpace);
				action = new GoToTheMarket(player, fMember, servants, realASpace);
			}else 
				throw new IOException();
			
			this.notifyObservers(action);
				
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}
	
	public Resource askCouncilPrivilege(){
		Resource resource=new RawMaterial();//INIZIALIZZATA SOLO PER FAR COMPILARE, DEVE CHIEDERE ALL'UTENTE E GLI RITORNA LA RISPOSTA 
										//MI INTERESSA SOLO LA CLASSE DI RITORNO (STONE =WOODS-> rawMaterials)
											//con quantità vuota
		
		return resource;
	}
	
	public void input(String area, String diceColor, String nrOfServants) {
		Player player = CouncilPalaceArea.getTurnOrder()[turn];
		Action action;
		
		try {
			FamilyMember fMember = player.getFamilyMember(DiceColor.fromString(diceColor));
			int servants = Integer.parseInt(nrOfServants);
			
			if (area.equals("COUNCIL PALACE")) {
				action = new GoToTheCouncilPalace(player, fMember, servants);
			}
			
			if (area.equals("HARVEST")) {
				action = new RunHarvest(player, fMember, servants);
			}
			
			if (area.equals("PRODUCTION")) {
				action = new RunProduction(player, fMember, servants);
			}else 
				throw new IOException();
			
			this.notifyObservers(action);
			
			
		
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		
		
	}
	
}
