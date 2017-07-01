package it.polimi.ingsw.GC_04.model;

import java.io.Serializable;

import it.polimi.ingsw.GC_04.Observable;
import it.polimi.ingsw.GC_04.controller.StateOfTheGameCLI;
import it.polimi.ingsw.GC_04.model.action.Action;
import it.polimi.ingsw.GC_04.model.area.BuildingTower;
import it.polimi.ingsw.GC_04.model.area.CharacterTower;
import it.polimi.ingsw.GC_04.model.area.CouncilPalaceArea;
import it.polimi.ingsw.GC_04.model.area.HarvestArea;
import it.polimi.ingsw.GC_04.model.area.MarketArea;
import it.polimi.ingsw.GC_04.model.area.ProductionArea;
import it.polimi.ingsw.GC_04.model.area.TerritoryTower;
import it.polimi.ingsw.GC_04.model.area.Tower;
import it.polimi.ingsw.GC_04.model.area.VaticanReport;
import it.polimi.ingsw.GC_04.model.area.VentureTower;
import it.polimi.ingsw.GC_04.model.card.BuildingCard;
import it.polimi.ingsw.GC_04.model.card.CharacterCard;
import it.polimi.ingsw.GC_04.model.card.DevelopmentCard;
import it.polimi.ingsw.GC_04.model.card.TerritoryCard;
import it.polimi.ingsw.GC_04.model.resource.Resource;

public class Model extends Observable<Action, Resource> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4908982852125469835L;
	private boolean areasSetted;
	
	private Player[] players;
	private int currentPeriod;
	private HarvestArea harvestArea;
	private ProductionArea productionArea;
	private TerritoryTower territoryTower;
	private CharacterTower characterTower;
	private BuildingTower buildingTower;
	private VentureTower ventureTower;
	private CouncilPalaceArea councilPalaceArea;
	private MarketArea marketArea;
	private VaticanReport vaticanReport;
	
	private String stateCLI;
	
    public Model() {
    	currentPeriod = 1;
    	
	}
    
    public Tower getTower(DevelopmentCard cardType) {
    	if (cardType instanceof TerritoryCard)
    		return territoryTower;
    	else if (cardType instanceof CharacterCard) 
    		return characterTower;
    	else if (cardType instanceof BuildingCard)
    		return buildingTower;
    	else 
    		return ventureTower;
		
	}
    
    public VaticanReport getVaticanReport() {
		return vaticanReport;
	}
    
    public HarvestArea getHarvest() {
    	return harvestArea;
		
	}
    public ProductionArea getProduction() {
    	return productionArea;
    	
    }
    public MarketArea getMarket() {
    	return marketArea;
    	
    }
    public CouncilPalaceArea getCouncilPalace() {
    	return councilPalaceArea;
    	
    }
    public void setPlayers(Player[] players) {
    	this.players = players;
    }
	
    public Player[] getPlayers() {
    	return players;
    }
    
    public int getPeriod() {
    	return currentPeriod;
    }
    
    public void incrementPeriod() {
    	currentPeriod++;
    }
    
    public String getStateCLI() {
    	return stateCLI;
		
	}
    public void setStateCLI() {
    	this.stateCLI = StateOfTheGameCLI.printStateOfTheGame(this,TerritoryTower.instance().getCards(), CharacterTower.instance().getCards(), BuildingTower.instance().getCards(), VentureTower.instance().getCards(), Dice.getDice(DiceColor.BLACK), Dice.getDice(DiceColor.ORANGE), Dice.getDice(DiceColor.WHITE));
    	
    }
    public void setAreas(TerritoryTower tTower,CharacterTower cTower, BuildingTower bTower, VentureTower vTower, MarketArea market, CouncilPalaceArea councilPalace, HarvestArea harvest, ProductionArea production, VaticanReport vaticanReport) {
    	if (!areasSetted) {
    		this.territoryTower = tTower;
    		this.characterTower = cTower;
    		this.buildingTower = bTower;
    		this.ventureTower = vTower;
    		this.marketArea = market;
    		this.councilPalaceArea = councilPalace;
    		this.harvestArea = harvest;
    		this.productionArea = production;
    		this.vaticanReport = vaticanReport;
    		areasSetted = !areasSetted;
    	}
		
	}

}
