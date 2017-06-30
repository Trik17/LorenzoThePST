package it.polimi.ingsw.GC_04.model;

import java.io.Serializable;

import it.polimi.ingsw.GC_04.Observable;
import it.polimi.ingsw.GC_04.controller.StateOfTheGameCLI;
import it.polimi.ingsw.GC_04.model.action.Action;
import it.polimi.ingsw.GC_04.model.area.BuildingTower;
import it.polimi.ingsw.GC_04.model.area.CharacterTower;
import it.polimi.ingsw.GC_04.model.area.TerritoryTower;
import it.polimi.ingsw.GC_04.model.area.VentureTower;
import it.polimi.ingsw.GC_04.model.resource.Resource;

public class Model extends Observable<Action, Resource> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4908982852125469835L;
	
	private Player[] players;
	private int currentPeriod;
	private String stateCLI;
	
    public Model() {
    	currentPeriod = 1;
    	
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

}
