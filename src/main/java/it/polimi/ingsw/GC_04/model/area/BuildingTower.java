package it.polimi.ingsw.GC_04.model.area;

import java.util.List;

import it.polimi.ingsw.GC_04.model.ActionSpace;
import it.polimi.ingsw.GC_04.model.card.BuildingCard;

public class BuildingTower extends Tower{

	private static final long serialVersionUID = -1484399818590572658L;
	public static int numero=0;
	private static final ThreadLocal<BuildingTower> instance=new ThreadLocal<BuildingTower>(){ 
	    @Override 
	    protected BuildingTower initialValue() { 
	        //initialize YourObject
	    	System.out.println(BuildingTower.numero);
	    	BuildingTower.numero++;
	      return new BuildingTower(); 
	      
	      } 
	};
	public static BuildingTower instance() {
		return instance.get();		
	}
	public static BuildingTower instance(BuildingCard[] cards, List<ActionSpace> aSpaces){
		System.out.println(BuildingTower.numero);
    	BuildingTower.numero++;
		instance.set(new BuildingTower(cards, aSpaces));
		return instance.get();
	}
	  
	
	private BuildingTower(BuildingCard[] cards, List<ActionSpace> aSpaces) {
		this.cards = cards;
		this.aSpaces = aSpaces;
	}
	
	private BuildingTower() {
	}

	

}
