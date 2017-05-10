package it.polimi.ingsw.GC_04;

import java.util.Random;

public class Dice {
	
	private DiceColor color;
	private int value;
	
	public Dice(DiceColor color){
			this.color = color;
		
	}
	
	public void roll(){
		//associa a value un numero random tra 1 e 6
		Random rand = new Random();
		this.value = 1 + rand.nextInt(6);
	}
	
	public int getValue(){
		return value;
	}

	
	
		
		

	
	
}
