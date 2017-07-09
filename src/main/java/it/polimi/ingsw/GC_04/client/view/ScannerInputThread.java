package it.polimi.ingsw.GC_04.client.view;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

import it.polimi.ingsw.GC_04.server.timer.TimerJson;


/*
 * support class used by ViewCLI to get the input in a separeted thread
 * it is implemented using the Singleton design pattern 
 * and it has a while(true) to avoid the closure of the thread that has an open scanner 
 */
public class ScannerInputThread implements Runnable {
	private Scanner reader; 
	private static ScannerInputThread instance;
	private ExecutorService executor;
	private ViewCLI view;
	private static AtomicBoolean whileSecurity;
	
	//singleton pattern
	public static ScannerInputThread instance(ViewCLI view){
		if(instance==null)
			return instance=new ScannerInputThread(view);
		else return instance;
	}
	
	//at the creation it starts a while(true) to avoid closure
	private ScannerInputThread(ViewCLI view) {
		this.view=view;
		this.reader= new Scanner(System.in);
		this.executor = Executors.newCachedThreadPool();
		whileSecurity=new AtomicBoolean(false);
	}
	
	public void scan(){
		executor.submit(this);
	}
	
	public String getInput(){
		String string=reader.nextLine();
		return string;
	}
	
	@Override
	public void run() {
		if (whileSecurity.get()){
		System.out.println( "\nInsert action in "+ TimerJson.getInputTimer()/1000 +" seconds: \n" );
		String string=reader.next();
		if(string.equals(""))
			string="EMPTY";
		view.setStrInput(string);
		}else{
			whileSecurity.set(true);;
			executor.submit(this);
			while(true){				
			}
		}
		
	}

}
