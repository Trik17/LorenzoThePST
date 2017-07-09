package it.polimi.ingsw.GC_04.server.controller;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import it.polimi.ingsw.GC_04.server.model.ActionSpace;
import it.polimi.ingsw.GC_04.server.model.PersonalBonusTile;
import it.polimi.ingsw.GC_04.server.model.card.BuildingCard;
import it.polimi.ingsw.GC_04.server.model.card.CharacterCard;
import it.polimi.ingsw.GC_04.server.model.card.ExcommunicationTile;
import it.polimi.ingsw.GC_04.server.model.card.LeaderCard;
import it.polimi.ingsw.GC_04.server.model.card.TerritoryCard;
import it.polimi.ingsw.GC_04.server.model.card.VentureCard;
import it.polimi.ingsw.GC_04.server.timer.TimerJson;

public class JsonMapper { 
	private FileReader fileT;
	private FileReader fileC;
	private FileReader fileB;
	private FileReader fileV;
	private FileReader fileAS;
	private FileReader fileET;
	private FileReader fileLC;
	private FileReader filePBT;
	private List<ActionSpace> actionSpaces;
	private List<TerritoryCard> territoryCards;
	private List<CharacterCard> characterCards;
	private List<BuildingCard> buildingCards;
	private List<VentureCard> ventureCards;
	private List<LeaderCard> leaderCards;
	private List<ExcommunicationTile> excommunicationTiles;
	private List<PersonalBonusTile> personalBonusTiles;
	
	
	public JsonMapper() {	
		ObjectMapper mapper = new ObjectMapper();       //declare a new ObjectMapper variable         
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
				
		try{	
			fileT= new FileReader("src/main/resources/cards/territory.json");
			fileC= new FileReader("src/main/resources/cards/character.json"); 
			fileB= new FileReader("src/main/resources/cards/building.json"); 
			fileV= new FileReader("src/main/resources/cards/venture.json"); 	
			fileAS= new FileReader("src/main/resources/actionSpace.json"); 
			fileET= new FileReader("src/main/resources/excommunicationTiles.json"); 
			fileLC= new FileReader("src/main/resources/cards/leaderCards.json"); 
			filePBT= new FileReader("src/main/resources/personalBonusTile.json"); 
			
			//PersonalBonusTiles
			TypeReference<List<PersonalBonusTile>> mapTypePBT = new TypeReference<List<PersonalBonusTile>>() {};
			personalBonusTiles=mapper.readValue(filePBT,mapTypePBT);
			
			//LeaderCards
			TypeReference<List<LeaderCard>> mapTypeL = new TypeReference<List<LeaderCard>>() {};
			leaderCards=mapper.readValue(fileLC,mapTypeL);
			
			//Cards
			TypeReference<List<TerritoryCard>> mapTypeT = new TypeReference<List<TerritoryCard>>() {};
			territoryCards=mapper.readValue(fileT,mapTypeT);	
			
			TypeReference<List<CharacterCard>> mapTypeC = new TypeReference<List<CharacterCard>>() {};
	    	characterCards=mapper.readValue(fileC,mapTypeC);
	    	
	    	TypeReference<List<BuildingCard>> mapTypeB = new TypeReference<List<BuildingCard>>() {};
	    	buildingCards=mapper.readValue(fileB,mapTypeB);
	    	
	    	TypeReference<List<VentureCard>> mapTypeV = new TypeReference<List<VentureCard>>() {};
	    	ventureCards=mapper.readValue(fileV,mapTypeV);
	    
	    	//ActionSpaces
	    	TypeReference<List<ActionSpace>> mapTypeAS = new TypeReference<List<ActionSpace>>() {};
			actionSpaces=mapper.readValue(fileAS,mapTypeAS);
			
			//excommunicationTiles
			TypeReference<List<ExcommunicationTile>> mapTypeET = new TypeReference<List<ExcommunicationTile>>() {};
			excommunicationTiles=mapper.readValue(fileET,mapTypeET);
	    	
		} catch (IOException e) {
			System.out.println("error .json files");
			e.printStackTrace();
		} 
		
	}
	
	public TerritoryCard[] getTerritoryCardArray(){
		return territoryCards.toArray(new TerritoryCard[0]);
	}
	
	public CharacterCard[] getCharacterCardArray(){
		return characterCards.toArray(new CharacterCard[0]);
	}
	
	public BuildingCard[] getBuildingCardArray(){
		return buildingCards.toArray(new BuildingCard[0]);
	}
	
	public LeaderCard[] getLeaderCards() {
		return leaderCards.toArray(new LeaderCard[0]);
	}
	
	public VentureCard[] getVentureCardsArray(){
		return ventureCards.toArray(new VentureCard[0]);
	}
	
	public PersonalBonusTile[] getPersonalBonusTiles() {
		return personalBonusTiles.toArray(new PersonalBonusTile[0]);
	}
	
	public List<ActionSpace> getActionSpaces(){
		return actionSpaces;
	}
	
	public List<ExcommunicationTile> getExcommunicationTile(){
		return excommunicationTiles;
	}
	
	public static void TimerFromJson()  {		
		try{	
			ObjectMapper mapper = new ObjectMapper();       //declare a new ObjectMapper variable         
			mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
			FileReader fileTimer= new FileReader("src/main/resources/timer.json"); 
			/*TimerJson t=*/mapper.readValue(fileTimer, TimerJson.class);		
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
