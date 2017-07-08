package it.polimi.ingsw.GC_04.client;

import java.io.IOException;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Random;
import java.util.Scanner;

import it.polimi.ingsw.GC_04.client.socket.ClientSocket;
import it.polimi.ingsw.GC_04.client.view.ClientRMI;


public class MainClient {
	//TODO alla fine del gioco chiudere socket rispettive
	public static void main(String[] args) throws NotBoundException, IOException {
		//TODO rimetti gli scanner nelle righe commentate
		Scanner in = new Scanner(System.in);
		//cancelaaaaaaaaaaaaaa
		int x=0;
		Random rnd =new Random();
		x=rnd.nextInt(58578);
//		String username="andre&miriam&gigi"+x;
		System.out.println("Choose an unsername: ");
		String username=in.nextLine();
        System.out.println("Choose RMI or SOCKET: ");
        String connection=in.nextLine();
         
        
        if (connection.equalsIgnoreCase("SOCKET")){
        	ClientSocket client=new ClientSocket(username);
        }else{
        	ClientRMI client=new ClientRMI(username);
        }
        	
		
	}
	
}
