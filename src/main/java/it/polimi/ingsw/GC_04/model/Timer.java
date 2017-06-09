package it.polimi.ingsw.GC_04.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Timer {
	private static int start;
	private static int action;
	
	@JsonCreator
	public Timer(@JsonProperty("start") int start,@JsonProperty("action") int action){
		Timer.start=start;
		Timer.action=action;
	}
	public Timer(){//for json
		
	}
	
	public static int getStartTimer(){
		return Timer.start;
	}
	
	public static int getActionTimer(){
		return Timer.action;
	}
}
