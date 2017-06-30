package it.polimi.ingsw.GC_04.model.area;

import java.util.List;

import it.polimi.ingsw.GC_04.model.ActionSpace;
import it.polimi.ingsw.GC_04.model.card.BuildingCard;
import it.polimi.ingsw.GC_04.model.card.VentureCard;

public class VentureTower extends Tower{
	private static final long serialVersionUID = 2006143910875010021L;
	private static final ThreadLocal<VentureTower> instance=new ThreadLocal<VentureTower>(){ 
	    @Override 
	    protected VentureTower initialValue() { 
	        //initialize YourObject 
	      return new VentureTower(); 
	      } 
	};
	public static VentureTower instance() {
		return instance.get();		
	}
	public static VentureTower instance(VentureCard[] cards, List<ActionSpace> aSpaces){
		instance.set(new VentureTower(cards, aSpaces));
		return instance.get();
	}
	
	private VentureTower(VentureCard[] cards, List<ActionSpace> aSpaces) {
		this.cards = cards;
		this.aSpaces = aSpaces;
	}
	private VentureTower() {
	}
	
	

}
