package it.polimi.ingsw.GC_04.server.model;

import java.io.Serializable;
import java.util.Map;

import it.polimi.ingsw.GC_04.server.controller.Observable;
import it.polimi.ingsw.GC_04.server.controller.StateOfTheGameCLI;
import it.polimi.ingsw.GC_04.server.model.action.Action;
import it.polimi.ingsw.GC_04.server.model.area.BuildingTower;
import it.polimi.ingsw.GC_04.server.model.area.CharacterTower;
import it.polimi.ingsw.GC_04.server.model.area.CouncilPalaceArea;
import it.polimi.ingsw.GC_04.server.model.area.HarvestArea;
import it.polimi.ingsw.GC_04.server.model.area.MarketArea;
import it.polimi.ingsw.GC_04.server.model.area.ProductionArea;
import it.polimi.ingsw.GC_04.server.model.area.TerritoryTower;
import it.polimi.ingsw.GC_04.server.model.area.Tower;
import it.polimi.ingsw.GC_04.server.model.area.VaticanReport;
import it.polimi.ingsw.GC_04.server.model.area.VentureTower;
import it.polimi.ingsw.GC_04.server.model.card.BuildingCard;
import it.polimi.ingsw.GC_04.server.model.card.CharacterCard;
import it.polimi.ingsw.GC_04.server.model.card.DevelopmentCard;
import it.polimi.ingsw.GC_04.server.model.card.TerritoryCard;
import it.polimi.ingsw.GC_04.server.model.resource.FaithPoints;
import it.polimi.ingsw.GC_04.server.model.resource.Resource;

public class Model implements Serializable{
	
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
	
	private Map<DiceColor, Dice> dices;
	
	private String stateCLI;
	
    public Model() {
    	this.dices = Dice.rollTheDices();
    	this.currentPeriod = 1;
    	
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
    	this.stateCLI = StateOfTheGameCLI.printStateOfTheGame(this,territoryTower.getCards(),characterTower.getCards(), buildingTower.getCards(), ventureTower.getCards(), dices);
    	
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
    public Dice getDice(DiceColor color) {
		if (color.equals(DiceColor.BLACK))
			return dices.get(DiceColor.BLACK);
		else if (color.equals(DiceColor.ORANGE))
			return dices.get(DiceColor.ORANGE);
		else if (color.equals(DiceColor.WHITE))
			return dices.get(DiceColor.WHITE);
		else
			return dices.get(DiceColor.NEUTRAL);
	}

    public Player getPlayer(String username) {
    	for (int i = 0; i < players.length; i++) {
			if (players[i].getName().equals(username))
				return players[i];
		}
		return null;
	}

	public void supportTheChurch(Player player) {
		VaticanReport.addFaithPointsScore(player);
		player.getResource(new FaithPoints()).reset();
	}
}
