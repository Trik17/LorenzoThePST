package it.polimi.ingsw.GC_04.model;

public class EndVictoryP extends Effect {
	private int endVictoryP; //Victory Points that must be added at the end of the game
	
	public EndVictoryP(){
		
	}
	
	@Override
	public void apply(Player player){
		
	player.getResources().forEach(r->{if(r.getClass().equals(VictoryPoints.class)){((VictoryPoints) r).addEndPoints(this.endVictoryP);}});
		
	}
}
/*

*/