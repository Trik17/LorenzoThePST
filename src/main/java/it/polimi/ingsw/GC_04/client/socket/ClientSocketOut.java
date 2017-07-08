package it.polimi.ingsw.GC_04.client.socket;

import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class ClientSocketOut implements Runnable{
	private PrintWriter out;
	private ClientSocket client;
	private ObjectMapper mapper;             
	
	
	public ClientSocketOut(ClientSocket clientSocket, PrintWriter OutputStream) {
		out=OutputStream;
		this.client=clientSocket;
		mapper = new ObjectMapper(); 
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
	}

	/*
	 String s = null;
        try {
            s = mapper.writeValueAsString(c);
        }
        catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	 
	 */
	@Override
	public void run() {
		registerSocketClientToServer();
		
	}

	private void registerSocketClientToServer() {
		//TODO
	}

}
