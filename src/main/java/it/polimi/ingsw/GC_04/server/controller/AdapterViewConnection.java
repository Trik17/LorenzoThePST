package it.polimi.ingsw.GC_04.server.controller;

import java.util.Map;

import it.polimi.ingsw.GC_04.client.view.ClientRMIViewRemote;
import it.polimi.ingsw.GC_04.server.view.ServerSocketView;

public class AdapterViewConnection {
	private Map<String, ClientRMIViewRemote> viewsRMI;
	private Map<String, ServerSocketView> viewsSocket;
	
	public AdapterViewConnection(Map<String, ClientRMIViewRemote> clientsRMI, Map<String, ServerSocketView> clientsSocket) {
		this.viewsRMI=clientsRMI;
		this.viewsSocket=clientsSocket;
	}
	
	public void setState(String player, String stateCLI){
		
	}
	
	
}
