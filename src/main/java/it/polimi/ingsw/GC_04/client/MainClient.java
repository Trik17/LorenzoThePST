package it.polimi.ingsw.GC_04.client;

import java.util.Scanner;

import it.polimi.ingsw.GC_04.client.rmi.ClientRMI;



public class MainClient {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
        System.out.println("Chose RMI or SOCKET: ");
        String connection=in.nextLine();
        in.close();      
        if (connection.equalsIgnoreCase("RMI")){
        	ClientRMI.main(null);
        }/*else if(connection.equalsIgnoreCase("SOCKET")){
        	ClientSocket.main(null);
        }*/
        	
		
	}
	
}
