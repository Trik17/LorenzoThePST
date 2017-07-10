/*package it.polimi.ingsw.GC_04.client.socket;

import com.fasterxml.jackson.annotation.JsonCreator;

//message used by socket connection parsed into a Json string
public class Message {
	public String username;
	
	@JsonCreator 
	public Message() {
		// TODO Auto-generated constructor stub
	}
	
}

/*
ObjectMapper mapper = new ObjectMapper();
mapper.configure(SerializationFeature.INDENT_OUTPUT, true);

string = mapper.writeValueAsString(c);

oggetto = mapper.readValue(STRING, ClientObject.class);
*/