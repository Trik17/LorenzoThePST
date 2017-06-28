package it.polimi.ingsw.GC_04.model;

import java.io.Serializable;

import it.polimi.ingsw.GC_04.Observable;
import it.polimi.ingsw.GC_04.model.action.Action;
import it.polimi.ingsw.GC_04.model.resource.Resource;

public class Model extends Observable<Action, Resource> implements Serializable{
	
	private Player[] players;
	private int currentPeriod;
	
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

}
