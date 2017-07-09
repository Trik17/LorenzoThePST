package it.polimi.ingsw.GC_04.server.model.resource;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.polimi.ingsw.GC_04.server.model.Player;

public class VictoryPoints extends Resource{
	
	private static final long serialVersionUID = -786583972309692082L;
	private int endVictoryPoints;
	
	@JsonCreator
	public VictoryPoints(@JsonProperty("quantity")int quantity){
		super(quantity);
	}
	//constructor needed for Json
	public VictoryPoints() {
	}
		
	/*
	 * methods to add player's endVictoryPoints to his victorypoints
	 */
	public static void sumEndVictoryPoints(Player player) {
		
		VictoryPoints victoryPoints = (VictoryPoints) player.getResource(new VictoryPoints());
		
		player.getResource(new VictoryPoints()).addQuantity(victoryPoints.endVictoryPoints);
		
	}
	
	/*
	 * methods to add the quantity of the object VictoryPoints that calls it
	 * to the player's endVictoryPoints
	 */
	public void addEndVictoryPoints(Player player) {
		
		VictoryPoints victoryPoints = (VictoryPoints) player.getResource(new VictoryPoints());
		
		victoryPoints.endVictoryPoints += this.getQuantity();
		
	}
	   
}
