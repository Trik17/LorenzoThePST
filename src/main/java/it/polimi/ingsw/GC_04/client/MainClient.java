package it.polimi.ingsw.GC_04.client;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.StringTokenizer;

import it.polimi.ingsw.GC_04.client.rmi.ClientRMI;



public class MainClient {
	
	public static void main(String[] args) throws AccessException, RemoteException, NotBoundException {
		
		String string = "ciao miriam andrea";
		StringTokenizer stringTokenizer = new StringTokenizer(string);
		System.out.println(stringTokenizer.countTokens());
		
		
		Scanner in = new Scanner(System.in);
		System.out.println("Choose an unsername: ");
		String username=in.nextLine();
//        System.out.println("Choose RMI or SOCKET: ");
//        String connection=in.nextLine();
         
        
//        if (connection.equalsIgnoreCase("RMI")){
        	ClientRMI client=new ClientRMI(username);
        	client.clientConnection();
//        }else if(connection.equalsIgnoreCase("SOCKET")){
//        	ClientSocket.main(null);
//        }
        	
		
	}
	
}
