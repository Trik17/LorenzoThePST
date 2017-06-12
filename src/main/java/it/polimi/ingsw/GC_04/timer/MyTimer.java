package it.polimi.ingsw.GC_04.timer;

import java.util.Timer;
import java.util.TimerTask;
import java.io.*;



public class MyTimer{//poi vanno fatti i metodi pure per gestire inizio partita
   
    TimerTask task = new TimerTask(){
    	
        public void run(){
        	System.out.println( "time out" );
        	try {
				throw new MyTimerException("tempo scaduto");
			} catch (MyTimerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
        }    
    };

    public void makeAction() throws MyTimerException
    {
        Timer timer = new Timer();
        timer.schedule( task, TimerJson.getActionTimer());
        System.out.println( "Make your action" );
        
        //far partire l'azione e quando finisce viene azzerato il timer

        timer.cancel();
     }

    public static void main( String[] args ) throws MyTimerException    {//questo main va cancellato e messo il codice nel controller
    	MyTimer myTimer=new MyTimer();
        try
        {
            myTimer.makeAction();
        }
        catch( MyTimerException e )
        {
            System.out.println( e );//qua va messo il codice per far perdere il turno al giocatore
        }
     }
}