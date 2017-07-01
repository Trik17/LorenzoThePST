package it.polimi.ingsw.GC_04.model.area;

import java.util.ArrayList;

public class HarvestArea extends ColorReastrictedArea {
	private static final long serialVersionUID = 8070328582738658717L;
	private static final ThreadLocal<HarvestArea> instance=new ThreadLocal<HarvestArea>(){ 
	    @Override 
	    protected HarvestArea initialValue() { 
	        //initialize YourObject 
	      return new HarvestArea(); 
	      } 
	};
	public static HarvestArea instance() {
		return instance.get();		
	}
	
	private HarvestArea() {
		this.aSpaces = new ArrayList<>();
	}
	
	
	public void reset() {
		aSpaces = new ArrayList<>();
	}
}
