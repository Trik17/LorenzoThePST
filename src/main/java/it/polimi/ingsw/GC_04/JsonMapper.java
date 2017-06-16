package it.polimi.ingsw.GC_04;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import it.polimi.ingsw.GC_04.model.card.BuildingCard;
import it.polimi.ingsw.GC_04.model.card.CharacterCard;
import it.polimi.ingsw.GC_04.model.card.DevelopmentCard;
import it.polimi.ingsw.GC_04.model.card.TerritoryCard;
import it.polimi.ingsw.GC_04.model.card.VentureCard;
import it.polimi.ingsw.GC_04.model.resource.MilitaryPoints;
import it.polimi.ingsw.GC_04.timer.TimerJson;

public class JsonMapper { 
	FileReader fileT= new FileReader("src/main/resources/cards/territory.json");
	FileReader fileC= new FileReader("src/main/resources/cards/character.json"); 
	FileReader fileB= new FileReader("src/main/resources/cards/building.json"); 
	FileReader fileV= new FileReader("src/main/resources/cards/venture.json"); 	
	List<TerritoryCard> territoryCards;
	List<CharacterCard> characterCards;
	List<BuildingCard> buildingCards;
	List<VentureCard> ventureCards;
	
	public JsonMapper() throws JsonMappingException, IOException{	
		ObjectMapper mapper = new ObjectMapper();       //declare a new ObjectMapper variable         
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
				
		try{		
			//mazzi di carte
			TypeReference<List<TerritoryCard>> mapTypeT = new TypeReference<List<TerritoryCard>>() {};
			territoryCards=mapper.readValue(fileT,mapTypeT);	

	    	TypeReference<List<CharacterCard>> mapTypeC = new TypeReference<List<CharacterCard>>() {};
	    	characterCards=mapper.readValue(fileC,mapTypeC);

	    	TypeReference<List<BuildingCard>> mapTypeB = new TypeReference<List<BuildingCard>>() {};
	    	buildingCards=mapper.readValue(fileB,mapTypeB);

	    	TypeReference<List<VentureCard>> mapTypeV = new TypeReference<List<VentureCard>>() {};
	    	ventureCards=mapper.readValue(fileV,mapTypeV);
	    	
		}catch(JsonParseException e){
			 e.printStackTrace();
		}	
		
	}
	
	public TerritoryCard[] getTerritoryCards(){
		return (TerritoryCard[]) territoryCards.toArray();
	}
	
	public CharacterCard[] getCharacterCard(){
		return (CharacterCard[]) characterCards.toArray();
	}
	
	public BuildingCard[] getBuildingCard(){
		return (BuildingCard[]) buildingCards.toArray();
	}
	
	public VentureCard[] getVentureCards(){
		return (VentureCard[]) ventureCards.toArray();
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
			System.out.println("MAZZI DI CARTE FINALI PER IL GIOCO");
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
