package it.polimi.ingsw.GC_04;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TimerJson {
	private static int start;//timeout from json in milliseconds
	private static int action;
	
	@JsonCreator
	public TimerJson(@JsonProperty("start") int start,@JsonProperty("action") int action){
		TimerJson.start=start;
		TimerJson.action=action;
	}
	public TimerJson(){//for json
		
	}
	
	public static int getStartTimer(){
		return TimerJson.start;
	}
	
	public static int getActionTimer(){
		return TimerJson.action;
	}
	
	
}
