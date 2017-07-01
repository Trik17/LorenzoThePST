package it.polimi.ingsw.GC_04.model.area;

import java.util.List;

import it.polimi.ingsw.GC_04.model.ActionSpace;

public class MarketArea extends Area{
	private static final long serialVersionUID = 869502343725350378L;
	private static final ThreadLocal<MarketArea> instance=new ThreadLocal<MarketArea>(){ 
	    @Override 
	    protected MarketArea initialValue() { 
	        //initialize YourObject 
	      return new MarketArea(); 
	      } 
	};
	public static MarketArea instance() {
		return instance.get();		
	}
	public static MarketArea instance(List<ActionSpace> aSpaces){
		instance.set(new MarketArea(aSpaces));
		return instance.get();
	}
	
	private MarketArea(List<ActionSpace> aSpaces) {
		this.aSpaces = aSpaces;
	}
	
	private MarketArea() {
	}
	public void reset() {
		for (ActionSpace aSpace:aSpaces)
			aSpace.reset();
		
	}
}
