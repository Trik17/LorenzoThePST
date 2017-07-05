package it.polimi.ingsw.GC_04.server.timer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TimerJson{
	private static int start=0;//timeout from json in milliseconds
	private static int input=0;
	private static int action=0;
	
	@JsonCreator
	public TimerJson(@JsonProperty("start") int start,@JsonProperty("input") int input,@JsonProperty("action") int action){
		TimerJson.start=start;
		TimerJson.input=input;
		TimerJson.action=action;
	}
	public TimerJson(){//for json		
	}
	
	public static int getStartTimer(){
		return TimerJson.start;
	}
	
	public static int getInputTimer(){
		return TimerJson.input;
	}
	
	public static int getActionTimer(){
		return TimerJson.action;
	}
	
	
	
	
}
