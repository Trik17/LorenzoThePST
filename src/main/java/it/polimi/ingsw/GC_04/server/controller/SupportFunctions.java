package it.polimi.ingsw.GC_04.server.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import it.polimi.ingsw.GC_04.client.view.ViewClient;
import it.polimi.ingsw.GC_04.server.model.Player;
import it.polimi.ingsw.GC_04.server.model.card.DevelopmentCard;
import it.polimi.ingsw.GC_04.server.model.card.TerritoryCard;
import it.polimi.ingsw.GC_04.server.model.effect.CouncilPrivilege;
import it.polimi.ingsw.GC_04.server.model.effect.Effect;
import it.polimi.ingsw.GC_04.server.model.resource.Resource;
import it.polimi.ingsw.GC_04.server.model.resource.VictoryPoints;

public class SupportFunctions {

	public static boolean timeout(String s,ViewClient view){
		if("ERRORTIME ".equals(s)){
			view.passTurn();
			return true;
		}
		return false;		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	public static Player maxVictoryPoints(Player[] players) {
	//it returns the player with more victory points and deletes him from the array 
		Player first=null;
		int max=0;
		int index = 0;
		for (int i = 0; i < players.length; i++) {
			if (players[i] != null){
				first = players[i];
				max = players[i].getResource(new VictoryPoints()).getQuantity();
				index = i;
				break;
			}
		}
		
		for (int i = 0; i < players.length; i++) {
			if (players[i] != null && players[i].getResource(new VictoryPoints()).getQuantity() > max) {
				first = players[i];
				max = players[i].getResource(new VictoryPoints()).getQuantity();
				index = i;
				
			}
		}
		
		players[index] = null;
		return first;
	}
	
	public static List<Effect> cloneEffects(List<Effect> effects){
		List<Effect> clone = new ArrayList<Effect>();
		for (Effect item:effects)
			clone.add((Effect) Effect.clone(item));
		return clone;
	}
	
	public static List<CouncilPrivilege> cloneCouncilPrivilege(List<CouncilPrivilege> councilPrivileges){
		
		List<CouncilPrivilege> clone = new ArrayList<>();
		for (CouncilPrivilege item:councilPrivileges) {
			clone.add((CouncilPrivilege) Effect.clone(item));
		}
		return clone;
	}
	
	public static List<Resource> cloneResources(List<Resource> resources){
		List<Resource> clone = new ArrayList<Resource>();
		for (Resource item:resources)
			clone.add((Resource) Resource.clone(item));
		return clone;
	}
	
	public static int[] parseIntArray (String str){
	    StringTokenizer strTok = new StringTokenizer(str);

	    strTok.nextToken(); 
	    //it has to jump the first and the last token because they aren't numbers. 
	    //first token is a string that identified the function of origin
	    //last token is "ok" that inform that the player's inputs are finished
	    
	    int size = strTok.countTokens() -1;
	    int[] vint = new int[size];

	    for (int i = 0; i < size; i++)
	        vint[i] = Integer.parseInt (strTok.nextToken());

	    return vint;
	}
	
	public static boolean isInputValid(String input, int min, int max) {
		try{
			if (input.equals("EMPTY ")) {// "EMPTY " is the input if the user press only ENTER (instead of "" for the condition in the whileLoop in getInput
				System.out.println("Your input is not valid");
				return false;
			}
			StringTokenizer strTok = new StringTokenizer(input);
			int num = Integer.parseInt(strTok.nextToken());
			if (num > max || num < min) {
				System.out.println("Your input is not valid");
				return false;
			}
		}catch(NumberFormatException e) {
			System.out.println("Your input is not valid");
			return false;
		}
		
		return true;
	}
	
	public static String nameCard(DevelopmentCard card) {
		try {
			String name = ")"+card.getName();
			return name;
		}catch (NullPointerException e) {
			String name = ")EMPTY               ";
			return name;
		}
		
	}
	
	public static String cardInArray(DevelopmentCard[] array,int index) {
		String card;
		try {
			card = nameCard(array[index]);
		}catch (ArrayIndexOutOfBoundsException e) {
			card = ")  **************  ";
		}
		return card;
	}
	

	public static void addExtraordinaryEffects(List<CouncilPrivilege> councilPrivileges, List<Effect> requestedAuthorizationEffects, List<Effect> myEffects) {
		
		for(Effect eff: myEffects) {
			if (eff.getClass().equals(CouncilPrivilege.class))
				councilPrivileges.add((CouncilPrivilege) eff);	
			if (eff.isAuthorizationRequested())
				requestedAuthorizationEffects.add(eff);
		}
	}
	public static <E> void shuffleArray(E card[]) {
		List<E> list = new ArrayList<>();
		for (int i = 0; i < card.length; i++) {
			list.add(card[i]);
		}
		Collections.shuffle(list);
		
		for (int i = 0; i < list.size(); i++) {
			card[i] = list.get(i);
		}
	}
}
