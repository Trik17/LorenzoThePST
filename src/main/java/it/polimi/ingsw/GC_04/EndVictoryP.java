package it.polimi.ingsw.GC_04;

public class EndVictoryP extends Effect {
	private int endVictoryP; //only for venture's card in the original game
	
	public EndVictoryP(){
		
	}
	
	@Override
	public void apply(Player player){
		
	((VictoryPoints) player.getResources().get(ResourceType.VICTORYP)).addEndPoints(endVictoryP);
	
	}
}
