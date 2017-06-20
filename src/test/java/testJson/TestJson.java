package testJson;

import static org.junit.Assert.*;

import java.io.FileReader;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.JsonMappingException;

import it.polimi.ingsw.GC_04.JsonMapper;
import it.polimi.ingsw.GC_04.model.card.DevelopmentCard;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import it.polimi.ingsw.GC_04.model.resource.MilitaryPoints;
import it.polimi.ingsw.GC_04.timer.TimerJson;



public class TestJson {
	protected JsonMapper jsonMapper;
	protected ObjectMapper mapper;
	
	@Before
	public void Initialize() throws JsonMappingException, IOException{
		jsonMapper=new JsonMapper();
		mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
			
	}

	@Test
	public void testGetJson() throws JsonMappingException, IOException {
		//actionSpaces
		jsonMapper.getActionSpaces();
		//cards
		jsonMapper.getTerritoryCardArray();
		jsonMapper.getBuildingCardArray();
		jsonMapper.getVentureCardsArray();
		jsonMapper.getCharacterCardArray();
		
		try{		
	    	
			//carte
			
			FileReader file= new FileReader("src/main/resources/card.json"); 
			DevelopmentCard r=mapper.readValue(file, DevelopmentCard.class);
			//null and !null
			assertNotEquals(null, r.getCost1());
			assertEquals(null, r.getCost2());
			
			//MilitaryPoints:
			FileReader file1= new FileReader("src/main/resources/mp.json"); 
			MilitaryPoints m=mapper.readValue(file1, MilitaryPoints.class);
			assertEquals(3, m.getQuantity());
			assertEquals(2, m.getMalus());
			
			//TIMER:
			FileReader file2= new FileReader("src/main/resources/timer.json"); 
			assertEquals(0, TimerJson.getStartTimer());
			assertEquals(0, TimerJson.getActionTimer());
			@SuppressWarnings("unused")
			TimerJson t=mapper.readValue(file2, TimerJson.class);			
			assertEquals(30000, TimerJson.getStartTimer());
			assertEquals(600000, TimerJson.getActionTimer());
			
	}catch(JsonParseException e){
		fail("failed for an exception of Json");
		e.printStackTrace();
	}
		
		
	}

}
