package it.polimi.ingsw.GC_04.model;

import java.util.*;


public abstract class DevelopementCard extends Card{
	
	private int period;
	private String name;
	private HashMap<ResourceType,Resource> cost;
	public ArrayList<Effect> immediateEffects;
	public ArrayList<Effect> permanentEffects;
	
	public abstract void takeCard(Player player,ActionSpace aSpace, FamilyMember fMember,int servants);
	
	private void immediateEffect(ArrayList<Effect> effects){};
	private void permanentEffect(ArrayList<Effect> effects){};
	
	public HashMap<ResourceType,Resource> getCost(){
		return cost;
	}
}


