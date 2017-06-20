package it.polimi.ingsw.GC_04.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import it.polimi.ingsw.GC_04.client.rmi.ViewCLI;
import it.polimi.ingsw.GC_04.model.effect.Effect;
import it.polimi.ingsw.GC_04.model.resource.Resource;

public class SupportFunctions {

	public static List<Effect> cloneEffects(List<Effect> effects){
		List<Effect> clone = new ArrayList<Effect>();
		for (Effect item:effects)
			clone.add((Effect) Effect.clone(item));
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
				ViewCLI.print("Your input is not valid");
				return false;
			}
		}catch(NumberFormatException e) {
			ViewCLI.print("Your input is not valid");
			return false;
		}
		
		return true;
	}
}
