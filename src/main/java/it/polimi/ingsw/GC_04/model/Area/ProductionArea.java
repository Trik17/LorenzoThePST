package it.polimi.ingsw.GC_04.model.Area;

import java.util.ArrayList;

import it.polimi.ingsw.GC_04.model.ActionSpace;

//aggiunto attributo,ora estende area
public class ProductionArea extends Area {
	private static ProductionArea instance;
	
	public static ProductionArea instance(){
		if (instance==null) instance = new ProductionArea();
		return instance;
	}
	
	
	private ProductionArea(){
		aSpaces = new ArrayList<ActionSpace>();
		
	}
}
