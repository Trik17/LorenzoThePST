package it.polimi.ingsw.GC_04.client;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

import it.polimi.ingsw.GC_04.client.socket.ClientSocket;


public class MainClient {
	
	public static void main(String[] args) throws AccessException, RemoteException, NotBoundException {
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
//        String connection=in.nextLine();
         
        
//        if (connection.equalsIgnoreCase("SOCKET")){
//        	ClientSocket client=new ClientSocket();
//        }else{
        	ClientRMI client=new ClientRMI(username);
//        }
        	
		
	}
	
}
