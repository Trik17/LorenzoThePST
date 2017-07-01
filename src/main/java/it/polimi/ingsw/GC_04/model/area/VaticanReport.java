package it.polimi.ingsw.GC_04.model.area;

import it.polimi.ingsw.GC_04.model.card.ExcommunicationTile;

public class VaticanReport {

	private static final ThreadLocal<VaticanReport> instance=new ThreadLocal<VaticanReport>(){ 
	    @Override 
	    protected VaticanReport initialValue() { 
	        //initialize YourObject 
	      return new VaticanReport(); 
	      } 
	};
	public static VaticanReport instance() {
		return instance.get();		
	}
	public static VaticanReport instance(ExcommunicationTile[] excommunications){
		instance.set(new VaticanReport(excommunications));
		return instance.get();
	}
	
	private ExcommunicationTile[] excommunications;

	private VaticanReport(ExcommunicationTile[] excommunications) {
		this.excommunications = excommunications;
	}
	
	private VaticanReport() {
	}
	

	public ExcommunicationTile getExcommunication(int period) {
		return excommunications[period -1];
	}

}
