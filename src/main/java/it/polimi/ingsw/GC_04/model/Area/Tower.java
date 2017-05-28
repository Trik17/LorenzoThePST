package it.polimi.ingsw.GC_04.model.Area;
import java.util.ArrayList;

import it.polimi.ingsw.GC_04.model.Card.DevelopmentCard;


//eliminato attributi aSpaceT e getter modificata tutta
public class Tower extends Area{
	
	private static boolean towersCreated;
	private static Tower territoryTower; 
	private static Tower buildingTower; 
	private static Tower ventureTower; 
	private static Tower characterTower; 
	private ArrayList<DevelopmentCard> cardTower; //verranno prese da file

	//it allows to create only 4 towers because if the static attribute towersCreated is true it does nothing
	public static void createTowers(ArrayList<DevelopmentCard> cardT,ArrayList<DevelopmentCard> cardB,ArrayList<DevelopmentCard> cardV,ArrayList<DevelopmentCard> cardC) {
		if (towersCreated == false) {
			territoryTower = new Tower(cardT);
			buildingTower = new Tower(cardB);
			ventureTower = new Tower(cardV);
			characterTower = new Tower(cardC);
			towersCreated = true;
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
	
	public Tower(ArrayList<DevelopmentCard> cardTower){//TODO
		
		this.cardTower = cardTower;
		
		//TODO: associare nell'initializer ad ogni torre i suoi act spaces compresi di effetti
		
				
		 
		
	}
	

	
	
}
