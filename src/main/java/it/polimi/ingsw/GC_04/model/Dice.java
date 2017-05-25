package it.polimi.ingsw.GC_04.model;

import java.util.Random;

public class Dice {
	
	private static boolean dicesCreated;
	
	private static Dice blackDice;
	private static Dice whiteDice;
	private static Dice orangeDice;
	private static Dice neutralDice; //this Dice only serves to be associated to the neutral family member. Its value never changes
	private DiceColor color;
	private int value;
	
	
	public static void createDices() {
		//it allows to create only 3 dices because if the static attribute dicesCreated is true it does nothing
		if (dicesCreated == false) {
			blackDice = new Dice(DiceColor.BLACK);
			whiteDice = new Dice(DiceColor.WHITE);
			orangeDice = new Dice(DiceColor.ORANGE);	
			neutralDice = new Dice(DiceColor.NONE);
		}
	}
	
	private Dice(DiceColor color){
			this.color = color;	
	}
	
	public static void rollTheDices(){
		//it associates a random number between 1 and 6 with the attribute value
		Random rnd = new Random();
		blackDice.value = 1 + rnd.nextInt(6);
		whiteDice.value = 1 + rnd.nextInt(6);
		orangeDice.value = 1 + rnd.nextInt(6);
	}
	
	public int getValue(){
		return value;
	}
	
	public static Dice getBlackDice() {
		return blackDice;
		
	}
	public static Dice getWhiteDice() {
		return whiteDice;
		
	}
	public static Dice getOrangeDice() {
		return orangeDice;
		
	}
	public static Dice getNeutralDice() {
		return neutralDice;
	}
	

	
	
}
