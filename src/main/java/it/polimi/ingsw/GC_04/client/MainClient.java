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
	public static void main(String[] args) throws AccessException, RemoteException, NotBoundException {
				
		Scanner in = new Scanner(System.in);
		System.out.println("Choose an unsername: ");
		String username=in.nextLine();
		System.out.println("Choose RMI or SOCKET: ");
        String connection=in.nextLine();
		System.out.println("Choose CLI or GUI ");
        String view=in.nextLine();        
        
        if (connection.equalsIgnoreCase("SOCKET")){
        	if (view.equalsIgnoreCase("GUI")) {
        		ClientSocket client=new ClientSocket(username,true);
			} else {
				ClientSocket client=new ClientSocket(username,false);
			}        	
        }else if(view.equalsIgnoreCase("GUI")){
        	ClientRMI client=new ClientRMI(username,true);
        }else{
        	ClientRMI client=new ClientRMI(username,false);
        }
        	
		
	}
	
}
