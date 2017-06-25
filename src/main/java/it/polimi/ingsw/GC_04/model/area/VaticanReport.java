package it.polimi.ingsw.GC_04.model.area;

import java.util.ArrayList;

import it.polimi.ingsw.GC_04.model.card.ExcommunicationTile;

public class VaticanReport {

	private static VaticanReport instance;
	
	private ExcommunicationTile excomm1;
	private ExcommunicationTile excomm2;
	private ExcommunicationTile excomm3;
	

	private VaticanReport(ExcommunicationTile excomm1,ExcommunicationTile excomm2,ExcommunicationTile excomm3) {
		this.excomm1 = excomm1;
		this.excomm2 = excomm2;
		this.excomm3 = excomm3;
	}
	
	public static VaticanReport instance(ExcommunicationTile excomm1,ExcommunicationTile excomm2,ExcommunicationTile excomm3){
		if (instance==null) 
			instance = new VaticanReport(excomm1,excomm2,excomm3);
		return instance;
	}
	public static VaticanReport  instance() {
		return instance;
	}

	public ExcommunicationTile getExcommunication(int period) {
		switch (period) {
		case 1:
			return excomm1;
		case 2:
			return excomm2;
		case 3:
			return excomm3;
		default:
			return null;
		}
		
	}

public static void excommunicationsManagement() {
		//TODO
		
	}
}
