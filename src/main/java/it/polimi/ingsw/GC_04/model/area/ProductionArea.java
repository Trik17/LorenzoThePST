package it.polimi.ingsw.GC_04.model.area;

import java.util.ArrayList;
import java.util.List;

import it.polimi.ingsw.GC_04.model.ActionSpace;

public class ProductionArea extends ColorReastrictedArea{
	private static final long serialVersionUID = 2343078907285078515L;
	private ActionSpace actionSpaceDefault;
	
	private static final ThreadLocal<ProductionArea> instance=new ThreadLocal<ProductionArea>(){ 
	    @Override 
	    protected ProductionArea initialValue() { 
	        //initialize YourObject 
	      return new ProductionArea(); 
	      } 
	};
	public static ProductionArea instance() {
		return instance.get();		
	}
	
	private ProductionArea(){
		this.aSpaces = new ArrayList<>();		
	}
	
	
	public List<ActionSpace> getASpace() {
		return aSpaces;
	}
	public void reset() {
		aSpaces = new ArrayList<ActionSpace>();
		//TODO: dire a tricki come fare per gli effetti
	}
	public ActionSpace getActionSpaceDefault() {
		return actionSpaceDefault;
	}
}
