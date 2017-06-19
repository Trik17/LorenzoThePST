package it.polimi.ingsw.GC_04.server;

import java.util.Set;

import it.polimi.ingsw.GC_04.client.rmi.ClientViewRemote;
import it.polimi.ingsw.GC_04.model.Player;

public class ClientManager {
	private Set<ClientViewRemote> clients;

	public Set<ClientViewRemote> getClients(){
		return this.clients;
	}
	
	public void addClient(ClientViewRemote clientStub){
		this.clients.add(clientStub);
		//controlla giocatori
		//username devono essere diversi 
		//vedi se devi iniziare timer o avviare la partita
	}
}
