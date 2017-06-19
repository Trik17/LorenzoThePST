package it.polimi.ingsw.GC_04.timer;

import java.util.Timer;
import java.util.TimerTask;
import java.io.*;
//NON VA


public class MyTimer{//poi vanno fatti i metodi pure per gestire inizio partita
   
    TimerTask task = new TimerTask(){
    	
        public void run(){
        	System.out.println( "time out" );
        	//fai qualcosa quando scatta il timer
				
        }    
    };
// variabile tipo promise con i future-> ma è difficile
    public void makeAction()    {
        Timer timer = new Timer();
        timer.schedule( task, TimerJson.getActionTimer());
        System.out.println( "Make your action" );
        
        //far partire l'azione e quando finisce viene azzerato il timer

        timer.cancel();
     }
    

    public static void main( String[] args ) {//questo main va cancellato e messo il codice nel controller
    	MyTimer myTimer=new MyTimer();
       
            myTimer.makeAction();
  
     }
}