package it.polimi.ingsw.GC_04.model;

//è un Singleton
public class CouncilPalace extends Area{ 
	private static CouncilPalace instance;
	
	
	public static CouncilPalace instance(){
		if (instance==null) instance = new CouncilPalace();
		return instance;
	}
	
	private CouncilPalace(){
		
		
	}
	
	
	
	
}
