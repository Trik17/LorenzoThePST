package it.polimi.ingsw.GC_04;
import java.util.ArrayList;
import java.util.List;


public class Tower extends Area{
	
	private ArrayList<DevelopementCard> cardTower;
	private ArrayList<ActionSpace> actSpaceT;

	
	public Tower(ArrayList<DevelopementCard> cardTower){

		this.cardTower = cardTower;
		
		Effect effect = new Effect();		
		//in realtà gli effetti sono diversi ma vengono presi da file
		//quindi non so come minchia si faccia
		actSpaceT.add(new ActionSpace(7, effect)); 
		actSpaceT.add(new ActionSpace(5, effect)); 
		actSpaceT.add(new ActionSpace(0, effect)); 
		actSpaceT.add(new ActionSpace(0, effect)); 
		
				
		/*Decidere se le carte le sceglie o no la torre ad ogni turno e non il game , anche caricare da file
		*/	 
		
	}
	
	public List<ActionSpace> getActSpaceT(){
		return actSpaceT;
	}
	
	public boolean colorIsntThere(FamilyColor color){
		if (color == FamilyColor.NEUTRAL) return true;
		
		for(ActionSpace aSpace:actSpaceT) {
				if(color == aSpace.getPresentColor())
					return false;}
		
		return true;
		
	}
}
