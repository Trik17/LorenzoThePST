package it.polimi.ingsw.GC_04.client;

import java.util.Scanner;

import it.polimi.ingsw.GC_04.timer.TimerJson;

public class ScannerInputThread implements Runnable {

	@Override
	public void run() {
		System.out.println( "Insert action in "+ TimerJson.getInputTimer()/1000 +" seconds: " );
		Scanner reader = new Scanner(System.in);
		ViewCLI.strInput = reader.next();
		
	}

}
