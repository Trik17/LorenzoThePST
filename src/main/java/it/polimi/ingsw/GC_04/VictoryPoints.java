package it.polimi.ingsw.GC_04;

public class VictoryPoints extends Resource{
	private int endAccumulator; //victory points from venture's cards, for the end of the game
	
	public VictoryPoints(int quantity){
		super(quantity);
	}
	
	public void addEndPoints(int quantity){ 
		endAccumulator += quantity;
		
	}
}
