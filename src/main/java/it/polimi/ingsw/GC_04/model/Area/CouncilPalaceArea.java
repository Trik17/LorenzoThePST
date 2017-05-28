package it.polimi.ingsw.GC_04.model.Area;

import java.util.ArrayList;

import it.polimi.ingsw.GC_04.model.ActionSpace;
import it.polimi.ingsw.GC_04.model.Player;

//cambiato per forza lo schema del singleton, ma rimane cmq un singleton
//attributo e set e get turnOrder e nextTurn
public class CouncilPalaceArea extends Area{ 
	private static CouncilPalaceArea instance;
	private static Player[] turnOrder; 
	private static Player[] nextTurnOrder; 
	
	
	public static CouncilPalaceArea instance() {
		//un'eccezione che faccia inserire il parametro se councilPalace non è stato creato, o forse lo collego al game e prende il numero di giocatori da lì, ora vediamo
		return instance;
		
	}
	public static CouncilPalaceArea instance(int nrOfPlayers){
		if (instance==null) instance = new CouncilPalaceArea(nrOfPlayers);
		return instance;
	}
	
	private CouncilPalaceArea(int nrOfPlayers){  //dovrò passare anche i player in realtà
		aSpaces = new ArrayList<ActionSpace>();
		turnOrder = new Player[nrOfPlayers];
		nextTurnOrder = new Player[nrOfPlayers];
		
		
		
	}
	
	public Player[] getTurnOrder(){
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
	
	
}
	

