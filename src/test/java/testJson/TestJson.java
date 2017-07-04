package testJson;

import static org.junit.Assert.*;

import java.io.FileReader;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.JsonMappingException;

import it.polimi.ingsw.GC_04.JsonMapper;
import it.polimi.ingsw.GC_04.model.card.BuildingCard;
import it.polimi.ingsw.GC_04.model.card.CharacterCard;
import it.polimi.ingsw.GC_04.model.card.DevelopmentCard;
import it.polimi.ingsw.GC_04.model.card.TerritoryCard;
import it.polimi.ingsw.GC_04.model.card.VentureCard;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import it.polimi.ingsw.GC_04.model.resource.MilitaryPoints;
import it.polimi.ingsw.GC_04.timer.TimerJson;



public class TestJson {
	protected JsonMapper jsonMapper;
	protected ObjectMapper mapper;
	private  TerritoryCard[] tCards;
	private  CharacterCard[] cCards;
	private  BuildingCard[] bCards;
	private  VentureCard[] vCards;
	
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
		this.tCards = jsonMapper.getTerritoryCardArray();
		this.cCards = jsonMapper.getCharacterCardArray();
		this.bCards = jsonMapper.getBuildingCardArray();
		this.vCards = jsonMapper.getVentureCardsArray();		
		assertEquals(TerritoryCard[].class, tCards.getClass());
		assertEquals(CharacterCard[].class, cCards.getClass());
		assertEquals(BuildingCard[].class, bCards.getClass());
		assertEquals(VentureCard[].class, vCards.getClass());
		
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
			assertEquals(0, TimerJson.getStartTimer());
			assertEquals(0, TimerJson.getInputTimer());
			JsonMapper.TimerFromJson();
			
//			assertEquals(METTI VALORE FINALE, TimerJson.getStartTimer());
//			assertEquals(METTI VALORE FINALE, TimerJson.getInputTimer());
//			assertEquals(METTI VALORE FINALE, TimerJson.getActionTimer());
			
	}catch(JsonParseException e){
		fail("failed for an exception of Json");
		e.printStackTrace();
	}
		
		
	}

}
