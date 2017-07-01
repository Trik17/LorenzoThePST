package it.polimi.ingsw.GC_04.model.area;

import java.util.ArrayList;
import java.util.List;
import it.polimi.ingsw.GC_04.model.ActionSpace;
import it.polimi.ingsw.GC_04.model.Player;

public class CouncilPalaceArea extends Area{ 
	private static final long serialVersionUID = 2892765005021763947L;
	private static Player[] turnOrder; 
	private static Player[] nextTurnOrder;
	private ActionSpace actionSpaceDefault;
	
	private static final ThreadLocal<CouncilPalaceArea> instance=new ThreadLocal<CouncilPalaceArea>(){ 
	    @Override 
	    protected CouncilPalaceArea initialValue() { 
	        //initialize YourObject 
	      return new CouncilPalaceArea(); 
	      } 
	};
	public static CouncilPalaceArea instance() {
		return instance.get();		
	}
	public static CouncilPalaceArea instance(Player[] players,ActionSpace actionSpaceDefault){
		instance.set(new CouncilPalaceArea(players,actionSpaceDefault));
		return instance.get();
	}
	
	
	private CouncilPalaceArea(Player[] players,ActionSpace actionSpaceDefault){ 
		turnOrder = players;
		int nrOfPlayers = turnOrder.length;
		nextTurnOrder = new Player[nrOfPlayers];
		aSpaces = new ArrayList<>();
		aSpaces.add(actionSpaceDefault);
		this.actionSpaceDefault = actionSpaceDefault;
	}
		
	private CouncilPalaceArea() {
	}
	public static Player[] getTurnOrder(){
		return turnOrder;
		
	}
	
	public static void setNextTurnOrder(Player player){
		for(int pos = 0; pos<turnOrder.length; pos++) {
			if (turnOrder[pos].equals(player)) return;
			else if (turnOrder[pos] == null) {
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
	
	public void reset() {
		aSpaces = new ArrayList<>();
		//TODO: dire a tricki come fare per gli effetti
	}
	
	public List<ActionSpace> getASpaces() {
		return aSpaces;
	}
	public ActionSpace getActionSpaceDefault() {
		return actionSpaceDefault;
	}
	
}
	

