package it.polimi.ingsw.GC_04.model;

import java.io.IOException;

public enum FamilyColor {
	
	RED,
	BLUE,
	YELLOW,
	GREEN,
	NEUTRAL;
	
	public static FamilyColor fromString(String string) throws IOException {
		if (string.equalsIgnoreCase("RED"))
			return FamilyColor.RED;
		if (string.equalsIgnoreCase("BLUE"))
			return BLUE;
		if (string.equalsIgnoreCase("YELLOW"))
			return FamilyColor.YELLOW;
		if (string.equalsIgnoreCase("GREEN"))
			return GREEN;
		else
			throw new IOException();
	}
}
