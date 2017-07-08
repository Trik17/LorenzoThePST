package it.polimi.ingsw.GC_04.server.view;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import it.polimi.ingsw.GC_04.server.MainServer;
import it.polimi.ingsw.GC_04.server.controller.Controller;
import it.polimi.ingsw.GC_04.server.controller.Observable;
import it.polimi.ingsw.GC_04.server.model.resource.Resource;

public class ServerSocketView extends Observable<String> implements Runnable{
	private Socket socket;
	private ObjectInputStream socketIn;
	private ObjectOutputStream socketOut;
	private Controller controller;
	private MainServer server;
	
	public ServerSocketView(Socket socket, Controller controller, MainServer mainServer) throws IOException {
		// creates the streams to communicate with the client-side, and the reference to the model
		this.socket = socket;
		this.socketIn = new ObjectInputStream(socket.getInputStream());
		this.socketOut = new ObjectOutputStream(socket.getOutputStream());
		this.controller=controller;
		this.server=mainServer;
	}

	@Override
	public void run() {
		addSocketClientToServer();
		
		System.out.println("Connesso al server");
		// TODO while true per aspettare messaggi da server
		
	}

	private void addSocketClientToServer() {
		// TODO Auto-generated method stub
		
	}
}
