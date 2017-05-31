package it.polimi.ingsw.GC_04.model;

import java.util.Random;

public class Dice {
	private static final int NEUTRALDICEVALUE = 0;
	private static final int MINDICEVALUE = 1;
	private static final int MAXDICEVALUE = 6;
	
	private static Dice blackDice;
	private static Dice whiteDice;
	private static Dice orangeDice;
	private static Dice neutralDice; //this Dice only serves to be associated to the neutral family member. Its value never changes
	private int value; // 1<=value<=6
	
	private Dice() {
		Random rnd = new Random();
		value = MINDICEVALUE + rnd.nextInt(MAXDICEVALUE);
	}
	
	public Dice(int value) {//it is needed to initialize TakeACardEffect
		if (value < NEUTRALDICEVALUE)
			this.value = NEUTRALDICEVALUE;
		this.value = value;
	}
	
	public static void createDices() {
			blackDice = new Dice();
			whiteDice = new Dice();
			orangeDice = new Dice();	
			neutralDice = new Dice(NEUTRALDICEVALUE);
	}
	
	
	
	
	public static void rollTheDices(){
		//it associates a random number between 1 and 6 with the attribute value
		Random rnd = new Random();
		blackDice.value = MINDICEVALUE + rnd.nextInt(MAXDICEVALUE);
		whiteDice.value = MINDICEVALUE + rnd.nextInt(MAXDICEVALUE);
		orangeDice.value = MINDICEVALUE + rnd.nextInt(MAXDICEVALUE);
	}
	
	public int getValue(){
		return this.value;
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
