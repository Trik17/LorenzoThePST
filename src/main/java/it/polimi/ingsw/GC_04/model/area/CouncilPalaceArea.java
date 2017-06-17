package it.polimi.ingsw.GC_04.model.area;

import java.util.ArrayList;
import java.util.List;

import it.polimi.ingsw.GC_04.model.ActionSpace;
import it.polimi.ingsw.GC_04.model.Player;

public class CouncilPalaceArea extends Area{ 
	private static CouncilPalaceArea instance;
	private static Player[] turnOrder; 
	private static Player[] nextTurnOrder;
	
	private CouncilPalaceArea(Player[] players){ 
		turnOrder = players;
		int nrOfPlayers = turnOrder.length;
		nextTurnOrder = new Player[nrOfPlayers];
		this.aSpaces = new ArrayList<ActionSpace>();	
	}
		
	public static CouncilPalaceArea instance() {
		return instance;		
	}
	
	public static CouncilPalaceArea instance(Player[] players){
		if (instance==null) instance = new CouncilPalaceArea(players);
		return instance;
	}
	
	
	public static Player[] getTurnOrder(){
		return turnOrder;
		
	}
	
	public static void setNextTurnOrder(Player player){
		for(int pos = 0; pos<turnOrder.length; pos++) {
			if (turnOrder[pos].equals(player)) return;
			if (turnOrder[pos] == null) {
				turnOrder[pos] = player;
				return;
			}
			continue; 
		}
	}
	
	public static void setTurnOrder() {
		Player[] prevTurnOrder = turnOrder;
		int pos = 0; 
		
		for(int turn=0; turn<turnOrder.length; turn++ ) {
			if(nextTurnOrder[turn] != null) {
				turnOrder[turn] = nextTurnOrder[turn];
			}else {
				/*if not every player has placed a family member in the council palace this fills the empty positions
				 with the players that were in the first positions in the previous turn */
				turnOrder[turn] = prevTurnOrder[pos]; 
				pos++; 
			}	
		}
		//it empties the array for the next turn
		for(pos=0; pos<nextTurnOrder.length; pos++) nextTurnOrder[pos]=null;	
		
	}
	
	public List<ActionSpace> getASpaces() {
		return aSpaces;
	}
	
	
}
	

