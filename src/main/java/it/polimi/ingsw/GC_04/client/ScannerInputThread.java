package it.polimi.ingsw.GC_04.client;

import java.util.Scanner;

import it.polimi.ingsw.GC_04.timer.TimerJson;

public class ScannerInputThread implements Runnable {

	@Override
	public void run() {
		System.out.println( "Inserisci azione entro "+ TimerJson.getActionTimer()/1000 +" secondi: " );
		Scanner reader = new Scanner(System.in);
		ViewCLI.strInput = reader.next();
		
	}

}
