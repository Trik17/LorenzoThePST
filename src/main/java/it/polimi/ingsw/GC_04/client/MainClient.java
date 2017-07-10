package it.polimi.ingsw.GC_04.client;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

import it.polimi.ingsw.GC_04.client.view.ClientRMI;

/*
 * main class of the client
 */
public class MainClient {
	public static void main(String[] args) throws AccessException, RemoteException, NotBoundException {
	
		Scanner in = new Scanner(System.in);
		System.out.println("Choose an unsername: ");
		String username=in.nextLine();
		System.out.println("Choose CLI or GUI ");
        String view=in.nextLine();        
    
        if (view.equalsIgnoreCase("GUI")) {
        	ClientRMI client=new ClientRMI(username,true);
        }else{
        	ClientRMI client=new ClientRMI(username,false);
		}  
		
	}
	
}
