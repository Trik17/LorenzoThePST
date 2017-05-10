package it.polimi.ingsw.GC_04;

//è un Singleton
public class Harvest extends Area {
	private static Harvest instance;
	
	
	public static Harvest instance(){
		if (instance==null) instance = new Harvest();
		return instance;
	}
	
	private Harvest(){
		
	}
	
}
