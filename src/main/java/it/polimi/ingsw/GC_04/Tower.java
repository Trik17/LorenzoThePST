package it.polimi.ingsw.GC_04;
import java.util.ArrayList;


public class Tower extends Area{
	
	private CardType cardType;
	private ArrayList<DevelopementCard> cardTower;
	private ActionSpace actSpaceT1;
	private ActionSpace actSpaceT2;
	private ActionSpace actSpaceT3;
	private ActionSpace actSpaceT4;
	
	
	
	private Tower(CardType cardType, ArrayList<DevelopementCard> cardTower){
		this.cardType = cardType;
		this.cardTower = cardTower;
		
		switch(cardType){
		case TERRITORY:
			actSpaceT1 = new ActionSpace(Area.TOWERS, 7 /*2 legnetti*/);
			actSpaceT2 = new ActionSpace(Area.TOWERS, 5 /*1 legnetto*/);
			actSpaceT3 = new ActionSpace(Area.TOWERS, 0);
			actSpaceT4 = new ActionSpace(Area.TOWERS, 0);
		case CHARACTER:
			actSpaceT1 = new ActionSpace(Area.TOWERS, 7 /*2 legnetti*/);
			actSpaceT2 = new ActionSpace(Area.TOWERS, 5 /*1 legnetto*/);
			actSpaceT3 = new ActionSpace(Area.TOWERS, 0);
			actSpaceT1 = new ActionSpace(Area.TOWERS, 0);
		
				
		 
		}
		
		//decidere se le carte le sceglie o no la torre ad ogni turno e non il game , anche caricare da file
	}
}
