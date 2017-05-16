package it.polimi.ingsw.GC_04.model;

//è un Singleton
public class Production {
	private static Production instance;
	
	
	public static Production instance(){
		if (instance==null) instance = new Production();
		return instance;
	}
	
	private Production(){
		
	}
}
