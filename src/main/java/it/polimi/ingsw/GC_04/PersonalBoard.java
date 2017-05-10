package it.polimi.ingsw.GC_04;

import java.util.ArrayList;

public class PersonalBoard {
	
	private ArrayList<DevelopementCard> territory;
	private int requestedMilitaryPoints;
	private ArrayList<DevelopementCard> building;
	private ArrayList<DevelopementCard> venture;
	private ArrayList<DevelopementCard> character;
	private int nrOfCoins;
	private int nrOfWoods;
	private int nrOfStones;
	private int nrOfServants;
	
	public PersonalBoard(int turnOrder){
		nrOfCoins = turnOrder + 4;
		nrOfWoods = 2;
		nrOfStones = 2;
		nrOfServants = 3;
	}
	
	
}
