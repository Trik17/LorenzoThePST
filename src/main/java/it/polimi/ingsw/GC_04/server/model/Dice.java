package it.polimi.ingsw.GC_04.server.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Dice implements Serializable {
	private static final long serialVersionUID = -1756458801038562978L;
	public static final int NEUTRALDICEVALUE = 0;
	public static final int MINDICEVALUE = 1;
	public static final int MAXDICEVALUE = 6;
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
	
	public static Map<DiceColor, Dice> rollTheDices() {
		Map<DiceColor, Dice> dices = new HashMap<>();
		dices.put(DiceColor.BLACK, new Dice());
		dices.put(DiceColor.ORANGE, new Dice());
		dices.put(DiceColor.WHITE, new Dice());
		dices.put(DiceColor.NEUTRAL, new Dice(0));
		return dices;
	}
	
	public int getValue(){
		return this.value;
	}
	
	
	
	
}
