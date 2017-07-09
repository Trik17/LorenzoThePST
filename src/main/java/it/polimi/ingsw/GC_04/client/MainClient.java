package it.polimi.ingsw.GC_04.client;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

import it.polimi.ingsw.GC_04.client.socket.ClientSocket;
import it.polimi.ingsw.GC_04.client.view.ClientRMI;

/*
 * main class of the client
 */
public class MainClient {
	//TODO alla fine del gioco chiudere socket rispettive
	public static void main(String[] args) throws AccessException, RemoteException, NotBoundException {
	
		Scanner in = new Scanner(System.in);
		System.out.println("Choose an unsername: ");
		String username=in.nextLine();
        System.out.println("Choose RMI or SOCKET: ");
        String connection=in.nextLine();
         
        
        if (connection.equalsIgnoreCase("SOCKET")){
        	new ClientSocket(username);
        }else{
        	new ClientRMI(username);
        }
        	
		
	}
	
}
