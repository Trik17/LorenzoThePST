package Regole;

import java.util.ArrayList;

public class PersonalBoard {
	
	public ArrayList<DevelopementCard> territory;
	public int requestedMilitaryPoints;
	public ArrayList<DevelopementCard> building;
	public ArrayList<DevelopementCard> venture;
	public ArrayList<DevelopementCard> character;
	public int nrOfCoins;
	public int nrOfWoods;
	public int nrOfStones;
	public int nrOfServants;
	
	public PersonalBoard(int turnOrder){
		nrOfCoins = turnOrder + 4;
		nrOfWoods = 2;
		nrOfStones = 2;
		nrOfServants = 3;
	}
	
	
}
