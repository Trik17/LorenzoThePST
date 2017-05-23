package it.polimi.ingsw.GC_04.model;

import java.util.ArrayList;
import java.util.List;
//modificata completamente
public class Game {
	
	private Dice blackDice;
	private Dice whiteDice;
	private Dice orangeDice;
	private Player[] players;
	private ArrayList<Area> areas;
	
	
    //manca costruttore
	
	
	
	public void rollTheDices(){  //public?? o lo fa automaticamente game stesso?
		
		blackDice.roll();
		whiteDice.roll();
		orangeDice.roll();
	
	}
	
	public int getDice(Dice dice){
		
		return
		dice.getValue();
	}
}
