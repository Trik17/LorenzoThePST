package it.polimi.ingsw.GC_04.model;
import java.util.ArrayList;
import java.util.List;

//eliminato attributi aSpaceT e getter modificata tutta
public class Tower extends Area{
	
	private static boolean created;
	private static Tower territoryTower; 
	private static Tower buildingTower; 
	private static Tower ventureTower; 
	private static Tower characterTower; 
	private ArrayList<DevelopementCard> cardTower;

	
	public static void createTowers(ArrayList<DevelopementCard> cardT,ArrayList<DevelopementCard> cardB,ArrayList<DevelopementCard> cardV,ArrayList<DevelopementCard> cardC) {
		if (created == false) {
			territoryTower = new Tower(cardT);
			buildingTower = new Tower(cardB);
			ventureTower = new Tower(cardV);
			characterTower = new Tower(cardC);
		}

	}
	

	public static Tower territoryTower() {
		return territoryTower;
	}
	public static Tower buildingTower() {
		return buildingTower;
	}
	public static Tower ventureTower() {
		return ventureTower;
	}
	public static Tower characterTower() {
		return characterTower;
	}
	
	public Tower(ArrayList<DevelopementCard> cardTower){//TODO
		
		this.cardTower = cardTower;
		
		//TODO: associare nell'initializer ad ogni torre i suoi act spaces compresi di effetti
		
				
		 
		
	}
	

	
	
}
