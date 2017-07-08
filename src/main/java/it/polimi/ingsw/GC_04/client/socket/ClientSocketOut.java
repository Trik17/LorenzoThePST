package it.polimi.ingsw.GC_04.client.socket;

import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class ClientSocketOut implements Runnable{
	private PrintWriter out;
	private ClientSocket client;
	private ObjectMapper mapper;   
	private Message message;
	
	
	public ClientSocketOut(ClientSocket clientSocket, PrintWriter OutputStream) {
		out=OutputStream;
		this.client=clientSocket;
		message=new Message();
		mapper = new ObjectMapper(); 
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
	}
	public void sendUsername() {
		send(client.getUsername());
	}
	private synchronized void  send(String string){
		out.println(string);
		out.flush();
	}

	@Override
	public void run() {
		
		while(true){
			
			
		}
	}

}
