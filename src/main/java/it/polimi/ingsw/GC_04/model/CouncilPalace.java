package it.polimi.ingsw.GC_04.model;

import java.lang.reflect.Array;
import java.util.ArrayList;

//cambiato per forza lo schema del singleton, ma rimane cmq un singleton
//attributo e set e get turnOrder e nextTurn
public class CouncilPalace extends Area{ 
	private static CouncilPalace instance;
	private static Player[] turnOrder; 
	private static Player[] nextTurnOrder; 
	
	
	public static CouncilPalace instance() {
		//un'eccezione che faccia inserire il parametro se councilPalace non è stato creato, o forse lo collego al game e prende il numero di giocatori da lì, ora vediamo
		return instance;
		
	}
	public static CouncilPalace instance(int nrOfPlayers){
		if (instance==null) instance = new CouncilPalace(nrOfPlayers);
		return instance;
	}
	
	private CouncilPalace(int nrOfPlayers){  //dovrò passare anche i player in realtà
		aSpaces = new ArrayList<ActionSpace>();
		turnOrder = new Player[nrOfPlayers];
		nextTurnOrder = new Player[nrOfPlayers];
		
		
		
	}
	
	public Player[] getTurnOrder(){
		return turnOrder;
		
	}
	
	public void setNextTurnOrder(Player player){
		for(Player p:turnOrder) {
			if (p == player) return;
			if (p == null) {
				p = player;
				return;
			}
			continue; 
		}
	}
	
	public void setTurnOrder() {
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
		for(Player p:nextTurnOrder) p=null;	
		
	}
	
	
}
	

