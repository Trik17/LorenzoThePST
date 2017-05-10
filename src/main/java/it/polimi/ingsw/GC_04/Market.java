package it.polimi.ingsw.GC_04;

//è un Singleton
public class Market {
	private static Market instance;
	
	
	public static Market instance(){
		if (instance==null) instance = new Market();
		return instance;
	}
	
	private Market(){
		
	}

}
