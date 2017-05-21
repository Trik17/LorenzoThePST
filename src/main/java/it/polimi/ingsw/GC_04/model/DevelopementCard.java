package it.polimi.ingsw.GC_04.model;

import java.util.*;


public abstract class DevelopementCard extends Card{
	
	private int period;
	private String name;
	private ArrayList<Resource> cost;
	private ArrayList<Effect> immediateEffects;
	private ArrayList<Effect> permanentEffects;
	
	public abstract void takeCard(Player player,ActionSpace aSpace, FamilyMember fMember,int servants);
	
	private void immediateEffect(ArrayList<Effect> effects){};
	private void permanentEffect(ArrayList<Effect> effects){};
	
	public ArrayList<Resource> getCost(){
		return cost;
	}
	
	public ArrayList<Effect> getImmediateE(){
		return immediateEffects;
	}
	
	public ArrayList<Effect> getPermanentE(){
		return permanentEffects;
	}
	
	
}


