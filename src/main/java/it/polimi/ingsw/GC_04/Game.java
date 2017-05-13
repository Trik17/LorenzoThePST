package it.polimi.ingsw.GC_04;

public class Game {
	
	/*public Track victoryTrack;
	public Track militaryTrack;
	public Track faithTrack;
	public Track orderTrack;*/
	private Dice blackDice;
	private Dice whiteDice;
	private Dice orangeDice;
	private Player player1;
	private Player player2;
	private Player player3;
	private Player player4;
	
	public Game(){
		
		this.blackDice = new Dice(DiceColor.BLACK);
		this.whiteDice = new Dice(DiceColor.WHITE);
		this.orangeDice = new Dice(DiceColor.ORANGE);
		
	}
	
	
	
	public void rollTheDices(){  //public?? o lo fa automaticamente game stesso?
		
		blackDice.roll();
		whiteDice.roll();
		orangeDice.roll();
		player1.refreshFMemberValue();
		player2.refreshFMemberValue();
		player3.refreshFMemberValue();
		player4.refreshFMemberValue();
	
	}
	
	public int getDice(Dice dice){
		
		return
		dice.getValue();
	}
}
