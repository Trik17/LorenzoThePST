package it.polimi.ingsw.GC_04.model;

import java.io.IOException;

public enum DiceColor {
	BLACK, ORANGE, WHITE, NEUTRAL;
	
	public static DiceColor fromString(String string){
		if (string.equalsIgnoreCase("1"))
			return BLACK;
		if (string.equalsIgnoreCase("2"))
			return ORANGE;
		if (string.equalsIgnoreCase("3"))
			return WHITE;
		if (string.equalsIgnoreCase("4"))
			return NEUTRAL;
		else
			return null;
	}
}
