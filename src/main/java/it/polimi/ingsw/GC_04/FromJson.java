package it.polimi.ingsw.GC_04;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.lang.model.type.NullType;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import it.polimi.ingsw.GC_04.model.card.BuildingCard;
import it.polimi.ingsw.GC_04.model.card.CharacterCard;
import it.polimi.ingsw.GC_04.model.card.DevelopmentCard;
import it.polimi.ingsw.GC_04.model.card.TerritoryCard;
import it.polimi.ingsw.GC_04.model.card.VentureCard;
import it.polimi.ingsw.GC_04.model.resource.Coins;
import it.polimi.ingsw.GC_04.model.resource.FaithPoints;
import it.polimi.ingsw.GC_04.model.resource.MilitaryPoints;
import it.polimi.ingsw.GC_04.model.resource.Resource;
import it.polimi.ingsw.GC_04.model.resource.Servants;
import it.polimi.ingsw.GC_04.model.resource.Stones;
import it.polimi.ingsw.GC_04.model.resource.Woods;
import it.polimi.ingsw.GC_04.timer.TimerJson;

public class FromJson { //classe di prova per serializzazione / deserializzazione carte json
	public FromJson(){		//servirà, sistemata, per caricare carte e timer
	}
	
	//ORA DA ERRORE, PROBABILMENTE PERCHè MANCANO @JSONCREATOR E @JSON PROPERTY AI COSTRUTTORI DI EFFECT E HARVEST E PRODUCTION E ANCHE I COSTRUTTORI DI DEFAULT VUOTI DA METTERE PER JSON
	public static void main(String[] args) throws JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();       //declare a new ObjectMapper variable         
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		
		/*
		Resource r1=new Coins(3);
		Resource r2=new Woods(99);
		Resource r3=new FaithPoints(4);
		Resource r4=new MilitaryPoints(0,0);
		Resource r5=new Stones(22);
		Resource r6=new Servants(1);
		*/
		
		/*
		ResourceArray c=new ResourceArray();
		c.getL().add(r1);
		c.getL().add(r2);
		c.getL().add(r3);
		c.getL().add(r4);
		c.getL().add(r5);
		c.getL().add(r6);*/
		
		/*ArrayList<Resource> cost=new ArrayList<Resource>();
		cost.add(r1);
		cost.add(r2);
		cost.add(r3);
		cost.add(r4);
		cost.add(r5);
		cost.add(r6);
		*/
		
		//DevelopmentCard card=new BuildingCard(1, "forest", cost1);
		
		
		//String s = null;
		int w=0,a=0,b=0;
		
		try{
				
			
		
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
		
	}	
}



// per l'array doveva essere fatto in classe a parte:
/*
 package it.polimi.ingsw.GC_04.model;

import java.util.ArrayList;
import java.util.List;

public class ResourceArray {//per Json
	
	private List<Resource> l;

    public ResourceArray(List<Resource> pl) {
        this.l = pl;
    }

    public ResourceArray() {
        this.l = new ArrayList<Resource>();
    }

    public List<Resource> getL() {
        return this.l;
    }

    public void setL(List<Resource> l) {
        this.l = l;
    }
}*/
