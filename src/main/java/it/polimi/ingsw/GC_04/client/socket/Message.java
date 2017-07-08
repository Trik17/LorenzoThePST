package it.polimi.ingsw.GC_04.client.socket;

import com.fasterxml.jackson.annotation.JsonCreator;

//message used by socket connection parsed into a Json string
public class Message {
	public String username;
	
	@JsonCreator 
	public Message() {
		// TODO Auto-generated constructor stub
	}
	//TODO http://www.davismol.net/2015/03/02/json-deserializzare-una-lista-di-oggetti-di-sottoclassi-di-una-classe-astratta-con-jackson/
}

/*
ObjectMapper mapper = new ObjectMapper();
mapper.configure(SerializationFeature.INDENT_OUTPUT, true);

string = mapper.writeValueAsString(c);

oggetto = mapper.readValue(STRING, ClientObject.class);
*/