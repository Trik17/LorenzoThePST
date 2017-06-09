package it.polimi.ingsw.GC_04.model;

public class Game {
	
	private static Player[] players;
	private int currentPeriod;
	
    public Game(Player[] players) {
    	Game.players = players;
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
