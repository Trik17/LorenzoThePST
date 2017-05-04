package Regole;

public class Game {
	
	public Track victoryTrack;
	public Track militaryTrack;
	public Track faithTrack;
	public Track orderTrack;
	public Dice blackDice;
	public Dice whiteDice;
	public Dice orangeDice;
	
	public Game(){
		this.victoryTrack = new Track(NameTrack.VictoryPoints);
		this.militaryTrack = new Track(NameTrack.MilitaryPoints);
		this.faithTrack = new Track(NameTrack.FaithPoints);
		this.orderTrack = new Track(NameTrack.TurnOrder);
	}
}
