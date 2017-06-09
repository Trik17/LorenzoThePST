package it.polimi.ingsw.GC_04.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Timer {
	private static int start;
	private static int action;
	
	public Timer(@JsonProperty("start") int start,@JsonProperty("action") int action){
		Timer.start=start;
		Timer.action=action;
	}
	
	public int getStartTimer(){
		return Timer.start;
	}
	
	public int getActionTimer(){
		return Timer.action;
	}
}
