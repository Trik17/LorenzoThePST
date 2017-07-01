package it.polimi.ingsw.GC_04.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import it.polimi.ingsw.GC_04.client.ViewCLI;
import it.polimi.ingsw.GC_04.client.ViewClient;
import it.polimi.ingsw.GC_04.model.card.DevelopmentCard;
import it.polimi.ingsw.GC_04.model.effect.CouncilPrivilege;
import it.polimi.ingsw.GC_04.model.effect.Effect;
import it.polimi.ingsw.GC_04.model.resource.Resource;

public class SupportFunctions {

	public static boolean timeout(String s,ViewClient view){
		if("".equals(s)){
			view.passTurn();
			return true;
		}
		return false;		
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

	    int size = strTok.countTokens ();
	    int[] vint = new int[size];

	    for (int i = 0; i < size; i++)
	        vint[i] = Integer.parseInt (strTok.nextToken());

	    return vint;
	}
	
	public static boolean isInputValid(String input, int min, int max) {
		try{
			if (Integer.parseInt(input) > max || Integer.parseInt(input) < min) {
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
}
