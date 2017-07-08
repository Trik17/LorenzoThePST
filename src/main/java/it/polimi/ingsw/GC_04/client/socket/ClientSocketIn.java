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

	public ClientSocketIn(ClientSocket clientSocket, Scanner InputStream) {
		this.in=InputStream;
		this.client=clientSocket;
		mapper = new ObjectMapper(); 
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
	}
//c2 = mapper.readValue(s, Message.class);
	@Override
	public void run() {
		
			while(true){
				Object object=in.nextLine();
				//TODO a seconda di ciò che ricevi fai su view
				
				
				
			}			
		
				
	}

}
