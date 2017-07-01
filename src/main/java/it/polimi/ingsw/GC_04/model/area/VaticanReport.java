package it.polimi.ingsw.GC_04.model.area;

import it.polimi.ingsw.GC_04.model.card.ExcommunicationTile;

public class VaticanReport {

	private static VaticanReport instance;
	
	private ExcommunicationTile[] excommunications;

	private VaticanReport(ExcommunicationTile[] excommunications) {
		this.excommunications = excommunications;
	}
	
	public static VaticanReport instance(ExcommunicationTile[] excommunications){
		if (instance==null) 
			instance = new VaticanReport(excommunications);
		return instance;
	}
	public static VaticanReport  instance() {
		return instance;
	}

	public ExcommunicationTile getExcommunication(int period) {
		return excommunications[period -1];
	}

}
