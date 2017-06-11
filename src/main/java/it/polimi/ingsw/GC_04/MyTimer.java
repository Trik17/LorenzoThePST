package it.polimi.ingsw.GC_04;

import java.util.Timer;
import java.util.TimerTask;
import java.io.*;


//PROVA A USARE SOLO TIMER SENZA TIMER TASK , SI PUò? COSA FA SE SCADE IL TIMER? lancia un eccezione o altro?
public class MyTimer{//PER ORA COPIATA DA INTERNET
    private String str = "";

    TimerTask task = new TimerTask(){
    	
        public void run(){
        	System.out.println( "time out" );
            System.exit( 0 );        	
        }    
    };

    public void getInput() throws Exception
    {
        Timer timer = new Timer();
        timer.schedule( task, TimerJson.getActionTimer());
        System.out.println( "Input a string within 10 seconds: " );
        BufferedReader in = new BufferedReader(
        new InputStreamReader( System.in ) );
        str = in.readLine();

        timer.cancel();
        System.out.println( "you have entered: "+ str ); 
    }

    public static void main( String[] args )
    {
    	MyTimer myTimer=new MyTimer();
        try
        {
            myTimer.getInput();
        }
        catch( Exception e )
        {
            System.out.println( e );
        }
        System.out.println( "main exit..." );
    }
}