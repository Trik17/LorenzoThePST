package it.polimi.ingsw.GC_04.model;

import it.polimi.ingsw.GC_04.Observable;
import it.polimi.ingsw.GC_04.model.action.Action;
import it.polimi.ingsw.GC_04.model.card.ExcommunicationTile;
import it.polimi.ingsw.GC_04.model.resource.Resource;

public class Model extends Observable<Action, Resource>{
	
	private static Player[] players;
	private static int currentPeriod;
	
    public Model() {
    	currentPeriod = 1;
    	
	}
    public void setPlayers(Player[] players) {
    	Model.players = players;
    }
	
    public static Player[] getPlayers() {
    	return players;
    }
    
    public int getPeriod() {
    	return currentPeriod;
    }
    
    public void incrementPeriod() {
    	currentPeriod++;
    }

}
