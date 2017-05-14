package it.polimi.ingsw.GC_04;

import java.util.*;

public abstract class DevelopementCard extends Card{
	
	private int period;
	private String name;
	private Cost cost;
	public ArrayList<Effect> immediateEffects;
	public ArrayList<Effect> permanentEffects;
	
	public abstract void takeCard(Player player);
	
	private void immediateEffect(ArrayList<Effect> effects){};
	private void permanentEffect(ArrayList<Effect> effects){};
	
}


