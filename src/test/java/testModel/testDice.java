package testModel;

import static org.junit.Assert.*;

import org.junit.Test;

import it.polimi.ingsw.GC_04.model.Dice;

public class testDice {
	int b=0;
	int o=0;
	int w=0;
	int n; 
	
	@Test
	public void testRollTheDices() {
		Dice.createDices();
		Dice.rollTheDices();
		b=Dice.getBlackDice().getValue();
		o=Dice.getOrangeDice().getValue();
		w=Dice.getWhiteDice().getValue();		
		n=Dice.getNeutralDice().getValue();
		assertTrue(Dice.MINDICEVALUE<=b && b<=Dice.MAXDICEVALUE && Dice.MINDICEVALUE<=o && o<=Dice.MAXDICEVALUE && Dice.MINDICEVALUE<=w && w<=Dice.MAXDICEVALUE && Dice.NEUTRALDICEVALUE==n);
	}
	
	@Test
	public void testDiceNeg(){
		Dice d=new Dice(-3);
		assertEquals(Dice.NEUTRALDICEVALUE, d.getValue());
		
	}
	@Test
	public void testDicePos(){
		Dice d=new Dice(3);
		assertEquals(3, d.getValue());
		
	}
	@Test
	public void testDiceZero(){
		Dice d=new Dice(0);
		assertEquals(0, d.getValue());
		
	}
	

}
