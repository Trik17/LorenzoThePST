package it.polimi.ingsw.GC_04.model.area;

import java.util.List;

import it.polimi.ingsw.GC_04.model.ActionSpace;
import it.polimi.ingsw.GC_04.model.card.TerritoryCard;

public class TerritoryTower extends Tower{
	
	private static final long serialVersionUID = -4901690566709128087L;
	private static final ThreadLocal<TerritoryTower> instance=new ThreadLocal<TerritoryTower>(){ 
	    @Override 
	    protected TerritoryTower initialValue() { 
	        //initialize YourObject 
	      return new TerritoryTower(); 
	      } 
	};
	public static TerritoryTower instance() {
		return instance.get();		
	}
	public static TerritoryTower instance(TerritoryCard[] cards, List<ActionSpace> aSpaces){
		instance.set(new TerritoryTower(cards, aSpaces));
		return instance.get();
	}
	
	
	private TerritoryTower(TerritoryCard[] cards, List<ActionSpace> aSpaces) {
		this.cards = cards;
		this.aSpaces = aSpaces;
	}
	private TerritoryTower() {
	}

}
