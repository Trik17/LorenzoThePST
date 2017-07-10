package testJson;

import static org.junit.Assert.*;

import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import it.polimi.ingsw.GC_04.server.controller.JsonMapper;
import it.polimi.ingsw.GC_04.server.model.card.BuildingCard;
import it.polimi.ingsw.GC_04.server.model.card.CharacterCard;
import it.polimi.ingsw.GC_04.server.model.card.LeaderCard;
import it.polimi.ingsw.GC_04.server.model.card.TerritoryCard;
import it.polimi.ingsw.GC_04.server.model.card.VentureCard;
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
	public void Initialize() {
		try{
			jsonMapper=new JsonMapper();
			mapper = new ObjectMapper();
			mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	
			
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
		
		
		//TIMER: 
		JsonMapper.timerFromJson();
		
		//change these tests if you want to change timer value over these limits
		assertTrue(0<=TimerJson.getStartTimer() && TimerJson.getStartTimer()<9999999);
		assertTrue(1<=TimerJson.getInputTimer() && TimerJson.getInputTimer()<TimerJson.getActionTimer());
		
		
	}

}
