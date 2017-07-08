package testJson;

import static org.junit.Assert.*;

import java.io.FileReader;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import it.polimi.ingsw.GC_04.server.controller.JsonMapper;
import it.polimi.ingsw.GC_04.server.model.card.BuildingCard;
import it.polimi.ingsw.GC_04.server.model.card.CharacterCard;
import it.polimi.ingsw.GC_04.server.model.card.DevelopmentCard;
import it.polimi.ingsw.GC_04.server.model.card.LeaderCard;
import it.polimi.ingsw.GC_04.server.model.card.TerritoryCard;
import it.polimi.ingsw.GC_04.server.model.card.VentureCard;
import it.polimi.ingsw.GC_04.server.model.resource.MilitaryPoints;
import it.polimi.ingsw.GC_04.server.timer.TimerJson;



public class TestJson {
	protected JsonMapper jsonMapper;
	protected ObjectMapper mapper;
	private  TerritoryCard[] tCards;
	private  CharacterCard[] cCards;
	private  BuildingCard[] bCards;
	private  VentureCard[] vCards;
	private  LeaderCard[] leaderCards;
	
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
		this.leaderCards = jsonMapper.getLeaderCards();		
		assertEquals(TerritoryCard[].class, tCards.getClass());
		assertEquals(CharacterCard[].class, cCards.getClass());
		assertEquals(BuildingCard[].class, bCards.getClass());
		assertEquals(VentureCard[].class, vCards.getClass());
		assertEquals(LeaderCard[].class, leaderCards.getClass());
		
		
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
			JsonMapper.TimerFromJson();
			//TODO
//			assertEquals(METTI VALORE FINALE, TimerJson.getStartTimer());
//			assertEquals(METTI VALORE FINALE, TimerJson.getInputTimer());
//			assertEquals(METTI VALORE FINALE, TimerJson.getActionTimer());
			
	}catch(JsonParseException e){
		fail("failed for an exception of Json");
		e.printStackTrace();
	}
		
		
	}

}
