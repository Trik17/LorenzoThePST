/*package it.polimi.ingsw.GC_04.client.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import it.polimi.ingsw.GC_04.client.view.ViewCLI;
import it.polimi.ingsw.GC_04.client.view.ViewClient;
import it.polimi.ingsw.GC_04.client.view.ViewGUI;

public class ClientSocket {
	private final static int SOCKET_PORT = 17000;
	private final static String IP = "127.0.0.1";
	private String username;
	private ClientSocketOut socketOut;
	private ClientSocketIn socketIn;
	private boolean GUI;
	private ViewClient view;
	
	public ClientSocket(String username, boolean GUI) throws IOException {
		this.username=username;
		this.GUI=GUI;
		if (GUI) {
			view=new ViewGUI();
		} else {
			view=new ViewCLI();
		}
		clientConnection();		
	}
	public String getUsername() {
		return username;
	}
	public ClientSocketIn getSocketIn() {
		return socketIn;
	}
	public ClientSocketOut getSocketOut() {
		return socketOut;
	}

	private void clientConnection() throws IOException {
		Socket socket = new Socket(IP, SOCKET_PORT);

		ExecutorService executor = Executors.newFixedThreadPool(2);

		//Creates one thread to send messages to the server
		executor.submit(socketOut=new ClientSocketOut(this,
				new PrintWriter(socket.getOutputStream())));

		//Creates one thread to receive messages from the server
		executor.submit(socketIn=new ClientSocketIn(this,
				new Scanner(socket.getInputStream())));
	}

	

}*/
