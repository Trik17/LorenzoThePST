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
	private int value; // 1<=value<=6
	
	private static final ThreadLocal<Dice> blackDice=new ThreadLocal<Dice>(){
		@Override
		protected Dice initialValue(){
			return new Dice();
		}
	};
	private static final ThreadLocal<Dice> whiteDice=new ThreadLocal<Dice>(){
		@Override
		protected Dice initialValue(){
			return new Dice();
		}
	};
	private static final ThreadLocal<Dice> orangeDice=new ThreadLocal<Dice>(){
		@Override
		protected Dice initialValue(){
			return new Dice();
		}
	};
	//this Dice only serves to be associated to the neutral family member. Its value never changes
	private static final ThreadLocal<Dice> neutralDice=new ThreadLocal<Dice>(){
		@Override
		protected Dice initialValue(){
			return new Dice(NEUTRALDICEVALUE);
		}
	};
		
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
			blackDice.get();
			whiteDice.get();
			orangeDice.get();
			neutralDice.get();
	}
	
	
	
	
	public static void rollTheDices(){
		//it associates a random number between 1 and 6 with the attribute value
		blackDice.set(new Dice());
		orangeDice.set(new Dice());
		whiteDice.set(new Dice());

	}
	
	public int getValue(){
		return this.value;
	}
	
	public static Dice getDice(DiceColor color) {
		if (color == DiceColor.BLACK)
			return blackDice.get();
		else if (color == DiceColor.ORANGE)
			return orangeDice.get();
		else if (color == DiceColor.WHITE)
			return whiteDice.get();
		else
			return neutralDice.get();
	}
	
	
}
