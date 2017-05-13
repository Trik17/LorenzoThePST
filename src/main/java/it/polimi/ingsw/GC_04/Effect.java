package it.polimi.ingsw.GC_04;

public class Effect {
	private Coins coins;
	private Woods woods;
	private Stones stones;
	private Servants servants;
	private FaithPoints faithP;
	private MilitaryPoints militaryP;
	private VictoryPoints victoryP;
	
	public Effect(){
		//inizializzare da file a seconda della carta
		
		
		
	}
	
	public void activateImmediateE(Player player){
		player.modifyResource(coins, woods, stones,servants,faithP,militaryP,victoryP);
		
	}
}
