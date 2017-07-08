package it.polimi.ingsw.GC_04.client.socket;

import java.io.IOException;
import java.io.ObjectInputStream;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class ClientSocketIn implements Runnable{
	private ObjectInputStream in;
	private ClientSocket client;
	private ObjectMapper mapper;

	public ClientSocketIn(ClientSocket clientSocket, ObjectInputStream objectInputStream) {
		this.in=objectInputStream;
		this.client=clientSocket;
		mapper = new ObjectMapper(); 
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
	}
//c2 = mapper.readValue(s, Message.class);
	@Override
	public void run() {
		try{
			while(true){
				Object object=in.readObject();
				//TODO a seconda di ciò che ricevi fai su view
				
				
				
			}			
		}catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}

}
