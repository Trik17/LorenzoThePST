package it.polimi.ingsw.GC_04.client;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import it.polimi.ingsw.GC_04.timer.TimerJson;

public class ScannerInputThread implements Runnable {
	private Scanner reader; 
	private static ScannerInputThread instance;
	private ExecutorService executor;
	private ViewCLI view;
	
	public static ScannerInputThread instance(ViewCLI view){
		if(instance==null)
			return instance=new ScannerInputThread(view);
		else return instance;
	}
	
	private ScannerInputThread(ViewCLI view) {
		this.view=view;
		this.reader= new Scanner(System.in);
		this.executor = Executors.newCachedThreadPool();
	}
	
	public void scan(){
		executor.submit(this);
	}
	
	

	@Override
	public void run() {
		System.out.println( "Insert action in "+ TimerJson.getInputTimer()/1000 +" seconds: " );
		String string=reader.next();
		if(string.equals(""))
			string="EMPTY";
		view.setStrInput(string);
		
	}

}
