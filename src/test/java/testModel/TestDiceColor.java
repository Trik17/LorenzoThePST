package testModel;

import static org.junit.Assert.*;

import org.junit.Test;

import it.polimi.ingsw.GC_04.server.model.DiceColor;

public class TestDiceColor {

	@Test
	public void TestDiceColor() {
		assertEquals(DiceColor.BLACK, DiceColor.fromString("1"));
		assertEquals(DiceColor.ORANGE, DiceColor.fromString("2"));
		assertEquals(DiceColor.WHITE, DiceColor.fromString("3"));
		assertEquals(DiceColor.NEUTRAL, DiceColor.fromString("4"));
		assertEquals(null, DiceColor.fromString("6"));
	}
}
