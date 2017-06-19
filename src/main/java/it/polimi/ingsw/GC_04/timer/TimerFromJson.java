package it.polimi.ingsw.GC_04.timer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class TimerFromJson {
	
public TimerFromJson() throws JsonMappingException, IOException {
	ObjectMapper mapper = new ObjectMapper();       //declare a new ObjectMapper variable         
	mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
	
	try{
		
		FileReader file2= new FileReader("src/main/resources/timer.json"); 
		//int a=TimerJson.getStartTimer();
		TimerJson t=mapper.readValue(file2, TimerJson.class);		
	}catch (JsonParseException e) {
		// TODO: handle exception
	}
}

}
