package it.polimi.ingsw.GC_04;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import it.polimi.ingsw.GC_04.model.ActionSpace;
import it.polimi.ingsw.GC_04.model.card.BuildingCard;
import it.polimi.ingsw.GC_04.model.card.CharacterCard;
import it.polimi.ingsw.GC_04.model.card.DevelopmentCard;
import it.polimi.ingsw.GC_04.model.card.TerritoryCard;
import it.polimi.ingsw.GC_04.model.card.VentureCard;
import it.polimi.ingsw.GC_04.model.resource.MilitaryPoints;
import it.polimi.ingsw.GC_04.timer.TimerJson;

public class JsonMapper { 
	private FileReader fileT= new FileReader("src/main/resources/cards/territory.json");
	private FileReader fileC= new FileReader("src/main/resources/cards/character.json"); 
	private FileReader fileB= new FileReader("src/main/resources/cards/building.json"); 
	private FileReader fileV= new FileReader("src/main/resources/cards/venture.json"); 	
	private FileReader fileAS= new FileReader("src/main/resources/actionSpace.json"); 	
	private List<ActionSpace> actionSpaces;
	private List<TerritoryCard> territoryCards;
	private List<CharacterCard> characterCards;
	private List<BuildingCard> buildingCards;
	private List<VentureCard> ventureCards;
	
	
	public JsonMapper() throws JsonMappingException, IOException{	
		ObjectMapper mapper = new ObjectMapper();       //declare a new ObjectMapper variable         
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
				
		try{		
			//Cards
			System.out.println("territory: ");//CANCELAAAAAA
			TypeReference<List<TerritoryCard>> mapTypeT = new TypeReference<List<TerritoryCard>>() {};
			territoryCards=mapper.readValue(fileT,mapTypeT);	
			
			System.out.println("caracter");//CANCELAAAAAA
	    	TypeReference<List<CharacterCard>> mapTypeC = new TypeReference<List<CharacterCard>>() {};
	    	characterCards=mapper.readValue(fileC,mapTypeC);
	    	
	    	System.out.println("buiding");//CANCELAAAAAA
	    	TypeReference<List<BuildingCard>> mapTypeB = new TypeReference<List<BuildingCard>>() {};
	    	buildingCards=mapper.readValue(fileB,mapTypeB);
	    	
	    	System.out.println("ventur");//CANCELAAAAAA
	    	TypeReference<List<VentureCard>> mapTypeV = new TypeReference<List<VentureCard>>() {};
	    	ventureCards=mapper.readValue(fileV,mapTypeV);
	    	
	    	System.out.println("actionspace");//CANCELAAAAAA
	    	//ActionSpaces
	    	TypeReference<List<ActionSpace>> mapTypeAS = new TypeReference<List<ActionSpace>>() {};
			actionSpaces=mapper.readValue(fileAS,mapTypeAS);
	    	
		}catch(JsonParseException e){
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
	
	public VentureCard[] getVentureCardsArray(){
		return ventureCards.toArray(new VentureCard[0]);
	}
	
	public List<ActionSpace> getActionSpaces(){
		return actionSpaces;
	}
	
	
	
	public static void main(String[] args) throws JsonMappingException, IOException {
		System.out.println("start");
		JsonMapper jsonMapper=new JsonMapper();
		System.out.println("vero start");
		jsonMapper.getActionSpaces();
		
		jsonMapper.getTerritoryCardArray();
		System.out.println("territory: ok");
		
		jsonMapper.getBuildingCardArray();
		System.out.println("building: ok");
		jsonMapper.getVentureCardsArray();
		System.out.println("venture: ok");
		
		jsonMapper.getCharacterCardArray();
		System.out.println("character: ok");
		
		
		/*
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
	}*/
	}
}
