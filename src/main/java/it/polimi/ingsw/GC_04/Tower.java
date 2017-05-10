package it.polimi.ingsw.GC_04;
import java.util.ArrayList;


public class Tower extends Area{
	
	private ArrayList<DevelopementCard> cardTower;
	private ActionSpace actSpaceT1;
	private ActionSpace actSpaceT2;
	private ActionSpace actSpaceT3;
	private ActionSpace actSpaceT4;
	
	
	
	public Tower(ArrayList<DevelopementCard> cardTower){

		this.cardTower = cardTower;
		
		Effect effect = new Effect();		
		//in realtà gli effetti sono diversi ma vengono presi da file
		//quindi non so come minchia si faccia
		actSpaceT1 = new ActionSpace(7, effect);
		actSpaceT2 = new ActionSpace(5, effect);
		actSpaceT3 = new ActionSpace(0, effect);
		actSpaceT1 = new ActionSpace(0, effect);
		
				
		/*Decidere se le carte le sceglie o no la torre ad ogni turno e non il game , anche caricare da file
		*/	 
		
		
	}
}
