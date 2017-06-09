package it.polimi.ingsw.GC_04.model;

public class Model {
	
	private static Player[] players;
	private int currentPeriod;
	
    public Model(Player[] players) {
    	Model.players = players;
    	currentPeriod = 1;
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
