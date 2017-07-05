package it.polimi.ingsw.GC_04.model.area;

import it.polimi.ingsw.GC_04.model.card.ExcommunicationTile;

public class VaticanReport {
	
	private final ExcommunicationTile[] excommunications;

	public VaticanReport(ExcommunicationTile[] excommunications) {
		this.excommunications = excommunications;
	}
	
	
	public ExcommunicationTile getExcommunication(int period) {
		return excommunications[period -1];
	}

}
