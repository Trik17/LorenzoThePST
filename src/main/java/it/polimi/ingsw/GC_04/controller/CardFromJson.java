package it.polimi.ingsw.GC_04.controller;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.lang.model.type.NullType;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import it.polimi.ingsw.GC_04.model.Card.BuildingCard;
import it.polimi.ingsw.GC_04.model.Card.DevelopmentCard;
import it.polimi.ingsw.GC_04.model.Resource.Coins;
import it.polimi.ingsw.GC_04.model.Resource.FaithPoints;
import it.polimi.ingsw.GC_04.model.Resource.MilitaryPoints;
import it.polimi.ingsw.GC_04.model.Resource.Resource;
import it.polimi.ingsw.GC_04.model.Resource.Servants;
import it.polimi.ingsw.GC_04.model.Resource.Stones;
import it.polimi.ingsw.GC_04.model.Resource.Woods;

public class CardFromJson { //classe di prova per serializzazione / deserializzazione carte json
	public CardFromJson(){
		
	}
	
	
	public static void main(String[] args) throws JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();       //declare a new ObjectMapper variable         
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		
		Resource r1=new Coins(3);
		Resource r2=new Woods(99);
		Resource r3=new FaithPoints(4);
		Resource r4=new MilitaryPoints(0);
		Resource r5=new Stones(22);
		Resource r6=new Servants(1);
		/*
		Coins r1=new Coins(3);
		Woods r2=new Woods(99);
		FaithPoints r3=new FaithPoints(4);
		MilitaryPoints r4=new MilitaryPoints(0);
		Stones r5=new Stones(22);
		Servants r6=new Servants(1);*/
		
		/*
		ResourceArray c=new ResourceArray();
		c.getL().add(r1);
		c.getL().add(r2);
		c.getL().add(r3);
		c.getL().add(r4);
		c.getL().add(r5);
		c.getL().add(r6);*/
		
		ArrayList<Resource> cost=new ArrayList<Resource>();
		cost.add(r1);
		cost.add(r2);
		cost.add(r3);
		cost.add(r4);
		cost.add(r5);
		cost.add(r6);
		
		
		//DevelopmentCard card=new BuildingCard(1, "forest", cost);
		
		
		String s = null;
		int w=0;
		
		try{
			FileReader file= new FileReader("src/main/resources/card.json"); 
			//s = mapper.writeValueAsString(card);
			DevelopmentCard r=mapper.readValue(file, DevelopmentCard.class);  
			
			w=r.getPeriod();
		}catch(JsonParseException e){
			 e.printStackTrace();
		}	
		System.out.println(w);
	}	
}// per l'array doveva essere fatto in classe a parte:
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
