package it.polimi.ingsw.GC_04.server.model.resource;

import java.util.List;

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
			// TODO Auto-generated constructor stub
		}
		
	public static void sumEndVictoryPoints(Player player) {
		List<Resource> playerRes = player.getResources();
		
		for(Resource r:playerRes) {
			if(r.getClass().equals(VictoryPoints.class)) 
				((VictoryPoints) r).addQuantity(((VictoryPoints) r).endVictoryPoints);
			break;
		}
	}
	public void addEndVictoryPoints(Player player) {
		List<Resource> playerRes = player.getResources();
		
		for(Resource r:playerRes) {
			if(r.getClass().equals(VictoryPoints.class)) {
				((VictoryPoints) r).endVictoryPoints += this.endVictoryPoints;
				break;
			}
		}
		
	}
	   
}
