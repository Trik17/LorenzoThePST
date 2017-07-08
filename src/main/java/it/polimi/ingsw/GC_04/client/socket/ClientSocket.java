package it.polimi.ingsw.GC_04.client.socket;

public class ClientSocket {
	public static final int Socket_PORT = 17000;
	private String username;
	private boolean GUI;
	
	public ClientSocket(String username, boolean GUI) {
		this.username=username;
		this.GUI=GUI;
	}

	

}
