package it.polimi.ingsw.GC_04.model;

import java.io.IOException;

public enum DiceColor {
	BLACK, ORANGE, WHITE, NEUTRAL;
	
	public static DiceColor fromString(String string) throws IOException {
		if (string.equalsIgnoreCase("BLACK"))
			return BLACK;
		if (string.equalsIgnoreCase("ORANGE"))
			return ORANGE;
		if (string.equalsIgnoreCase("WHITE"))
			return WHITE;
		if (string.equalsIgnoreCase("NEUTRAL"))
			return NEUTRAL;
		else
			throw new IOException();
	}
}
