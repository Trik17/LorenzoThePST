package it.polimi.ingsw.GC_04.server.controller;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import it.polimi.ingsw.GC_04.server.model.ActionSpace;
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
	private List<ActionSpace> actionSpaces;
	private List<TerritoryCard> territoryCards;
	private List<CharacterCard> characterCards;
	private List<BuildingCard> buildingCards;
	private List<VentureCard> ventureCards;
	private List<LeaderCard> leaderCards;
	private List<ExcommunicationTile> excommunicationTiles;
	
	
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
			fileLC= new FileReader("src/main/resources/leaderCards.json"); 
			
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
			// TODO Auto-generated catch block
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
	
	public List<LeaderCard> getLeaderCards() {
		return leaderCards;
	}
	
	public VentureCard[] getVentureCardsArray(){
		return ventureCards.toArray(new VentureCard[0]);
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
	
	/*
	public static void main(String[] args) throws JsonMappingException, IOException {
		
		
		
		
		ObjectMapper mapper = new ObjectMapper();       //declare a new ObjectMapper variable         
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		
		//DevelopmentCard card=new BuildingCard(1, "forest", cost1);
				
		//String s = null;
		int w=0,a=0,b=0;
		
		try{		
			
			//mazzi di carte
			System.out.println("territory");
			FileReader fileT= new FileReader("src/main/resources/cards/territory.json"); 	
			TypeReference<List<TerritoryCard>> mapTypeT = new TypeReference<List<TerritoryCard>>() {};
			List<TerritoryCard> territoryCards=mapper.readValue(fileT,mapTypeT);	    	

	    	System.out.println("building");
	    	FileReader fileB= new FileReader("src/main/resources/cards/building.json"); 	
	    	TypeReference<List<BuildingCard>> mapTypeB = new TypeReference<List<BuildingCard>>() {};
	    	List<BuildingCard> buildingCards=mapper.readValue(fileB,mapTypeB);

	       	System.out.println("character");
	    	FileReader fileC= new FileReader("src/main/resources/cards/character.json"); 
	    	TypeReference<List<CharacterCard>> mapTypeC = new TypeReference<List<CharacterCard>>() {};

	    	List<CharacterCard> characterCards=mapper.readValue(fileC,mapTypeC);

	    	

	    	System.out.println("venture");

	    	FileReader fileV= new FileReader("src/main/resources/cards/venture.json"); 	
	    	TypeReference<List<VentureCard>> mapTypeV = new TypeReference<List<VentureCard>>() {};
	    	List<VentureCard> ventureCards=mapper.readValue(fileV,mapTypeV);

	    	territoryCards.toArray();
	    	
	    	
			//carte
			System.out.println("carte:");
			FileReader file= new FileReader("src/main/resources/card.json"); 
			
			//s = mapper.writeValueAsString(card);
			DevelopmentCard r=mapper.readValue(file, DevelopmentCard.class);
			w=r.getPeriod();
			System.out.println(w);
			System.out.println("null?  :");
			if(r.getCost2()==null)
				System.out.println("va a null");
			else if (r.getCost2()!=null)
						System.out.println("errore");			
			
			//ActionSpaces
			System.out.println("actionspace:");
	    	TypeReference<List<ActionSpace>> mapTypeAS = new TypeReference<List<ActionSpace>>() {};
			actionSpaces=mapper.readValue(fileAS,mapTypeAS);
	    	
			
			
			//MilitaryPoints:
			System.out.println("militaryPoints:");
			FileReader file1= new FileReader("src/main/resources/mp.json"); 
			MilitaryPoints m=mapper.readValue(file1, MilitaryPoints.class);
			
			System.out.println(m.getQuantity());
			System.out.println(m.getMalus());
		
			
			//TIMER:
			System.out.println("timer:");
			FileReader file2= new FileReader("src/main/resources/timer.json"); 
			a=TimerJson.getStartTimer();
			b=TimerJson.getActionTimer();
			System.out.println(a);
			System.out.println(b);
			System.out.println("dopo json:");
			TimerJson t=mapper.readValue(file2, TimerJson.class);			
			a=TimerJson.getStartTimer();
			b=TimerJson.getActionTimer();
			System.out.println(a);
			System.out.println(b);
	}catch(JsonParseException e){
		 e.printStackTrace();
	}
	}*/
}
