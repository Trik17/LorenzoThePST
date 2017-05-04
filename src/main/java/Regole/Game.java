package Regole;

public class Game {
	
	/*public Track victoryTrack;
	public Track militaryTrack;
	public Track faithTrack;
	public Track orderTrack;*/
	public Dice blackDice;
	public Dice whiteDice;
	public Dice orangeDice;
	private Player player1;
	private Player player2;
	private Player player3;
	private Player player4;
	
	public Game(){
		
		/*this.victoryTrack = new Track(NameTrack.VictoryPoints);
		this.militaryTrack = new Track(NameTrack.MilitaryPoints);
		this.faithTrack = new Track(NameTrack.FaithPoints);
		this.orderTrack = new Track(NameTrack.TurnOrder);*/
		
		this.blackDice = new Dice(DiceColor.BLACK);
		this.whiteDice = new Dice(DiceColor.WHITE);
		this.orangeDice = new Dice(DiceColor.ORANGE);
		
	}
	

	public void rollTheDices(){
		
		blackDice.roll();
		whiteDice.roll();
		orangeDice.roll();
		player1.refreshFMemberValue();
		player2.refreshFMemberValue();
		player3.refreshFMemberValue();
		player4.refreshFMemberValue();
	
	}
}
