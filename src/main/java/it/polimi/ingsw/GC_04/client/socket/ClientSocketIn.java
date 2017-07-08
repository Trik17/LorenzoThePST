package it.polimi.ingsw.GC_04.client.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class ClientSocketIn implements Runnable{
	private Scanner in;
	private ClientSocket client;
	private ObjectMapper mapper;
	private String line;

	public ClientSocketIn(ClientSocket clientSocket, Scanner InputStream) {
		this.in=InputStream;
		this.client=clientSocket;
		line="";
		mapper = new ObjectMapper(); 
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
	}
//c2 = mapper.readValue(s, Message.class);
	@Override
	public void run() {
		
		while(!line.equals("username")){
			line=in.nextLine();			
		}		
		client.getSocketOut().sendUsername();
			
			
		while(true){
				line=in.nextLine();
				//TODO a seconda di ciò che ricevi fai su view
				
				
				
			}			
		
				
	}

}
