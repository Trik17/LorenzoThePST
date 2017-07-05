package it.polimi.ingsw.GC_04.client.view;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import it.polimi.ingsw.GC_04.server.timer.TimerJson;

public class ScannerInputThread implements Runnable {
	private Scanner reader; 
	private static ScannerInputThread instance;
	private ExecutorService executor;
	private ViewCLI view;
	private static boolean whileSecurity=false;
	
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
	
	public static synchronized boolean getWhileSecurity(){
		return ScannerInputThread.whileSecurity;
	}
	public static synchronized void setWhileSecurity(boolean set){
		ScannerInputThread.whileSecurity=set;
	}
	

	@Override
	public void run() {
		if (getWhileSecurity()){
		System.out.println( "\nInsert action in "+ TimerJson.getInputTimer()/1000 +" seconds: \n" );
		String string=reader.next();
		if(string.equals(""))
			string="EMPTY";
		view.setStrInput(string);
		}else{
			setWhileSecurity(true);
			executor.submit(this);
			while(true){				
			}
		}
		
	}

}
