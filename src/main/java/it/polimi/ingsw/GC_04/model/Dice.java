package it.polimi.ingsw.GC_04.model;

import java.io.Serializable;
import java.util.Random;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Dice implements Serializable {
	private static final long serialVersionUID = -1756458801038562978L;
	public static final int NEUTRALDICEVALUE = 0;
	public static final int MINDICEVALUE = 1;
	public static final int MAXDICEVALUE = 6;
	
	private static Dice blackDice;
	private static Dice whiteDice;
	private static Dice orangeDice;
	private static Dice neutralDice; //this Dice only serves to be associated to the neutral family member. Its value never changes
	private int value; // 1<=value<=6
	
	private Dice() {
		Random rnd = new Random();
		value = MINDICEVALUE + rnd.nextInt(MAXDICEVALUE);
	}
	@JsonCreator
	public Dice(@JsonProperty("value") int value) {//it is needed to initialize TakeACardEffect
		if (value < NEUTRALDICEVALUE)
			this.value = NEUTRALDICEVALUE;
		else
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
	
	public static Dice getDice(DiceColor color) {
		if (color == DiceColor.BLACK)
			return blackDice;
		else if (color == DiceColor.ORANGE)
			return orangeDice;
		else if (color == DiceColor.WHITE)
			return whiteDice;
		else
			return neutralDice;
	}
	
	
}
