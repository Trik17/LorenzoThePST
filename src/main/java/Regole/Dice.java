package Regole;

import java.util.Random;

public class Dice {
	
	public DiceColor color;
	public int value;
	
	public Dice(DiceColor color){
			this.color = color;
		
	}
	
	public void roll(){
		//associa a value un numero random tra 1 e 6
		Random rand = new Random();
		this.value = 1 + rand.nextInt(6);
	}

	
	
		
		

	
	
}
