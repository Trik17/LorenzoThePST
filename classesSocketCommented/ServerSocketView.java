// package it.polimi.ingsw.GC_04.server.view;

// import java.io.IOException;
// import java.io.ObjectInputStream;
// import java.io.ObjectOutputStream;
// import java.io.PrintWriter;
// import java.net.Socket;
// import java.util.Scanner;

// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.fasterxml.jackson.databind.SerializationFeature;

// import it.polimi.ingsw.GC_04.client.socket.Message;
// import it.polimi.ingsw.GC_04.server.MainServer;
// import it.polimi.ingsw.GC_04.server.controller.Controller;
// import it.polimi.ingsw.GC_04.server.controller.Observable;
// import it.polimi.ingsw.GC_04.server.model.resource.Resource;

// public class ServerSocketView extends Observable<String> implements Runnable{
	// private Socket socket;
	// private Scanner socketIn;
	// private PrintWriter socketOut;
	// private Controller controller;
	// private MainServer server;
	// private Message message;
	// private ObjectMapper mapper;
	// private String username;
	
	// public ServerSocketView(Socket socket, Controller controller, MainServer mainServer) throws IOException {
//		creates the streams to communicate with the client-side, and the reference to the model
		// this.socket = socket;
		// this.socketIn = new Scanner(socket.getInputStream());
		// this.socketOut = new PrintWriter(socket.getOutputStream());
		// this.controller=controller;
		// this.server=mainServer;
		// message=new Message();
		// mapper = new ObjectMapper();
        // mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
	// }

	// @Override
	// public void run() {
		// socketOut.println("username");
		// socketOut.flush();
		// this.username=socketIn.nextLine();
		// server.addSocketClient(username, this);
		
		// while(true){
			// String line=socketIn.nextLine();
			// try {
				// message= mapper.readValue(line, Message.class);
			// } catch (IOException e) {
				// e.printStackTrace();
			// }
			
			
			
			
		// }
	// }

	
// }
