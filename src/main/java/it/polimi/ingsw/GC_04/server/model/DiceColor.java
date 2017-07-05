package it.polimi.ingsw.GC_04.server.model;

public enum DiceColor {
	BLACK, ORANGE, WHITE, NEUTRAL;
	
	public static DiceColor fromString(String string){
		if ("1".equals(string))
			return BLACK;
		else if ("2".equals(string))
			return ORANGE;
		else if ("3".equals(string))
			return WHITE;
		else if ("4".equals(string))
			return NEUTRAL;
		else
			return null;
	}
}
