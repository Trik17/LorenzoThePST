package it.polimi.ingsw.GC_04.model;

//cambiata funzione RunProduction
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {
	
	private Game game;
	private FamilyColor color;
	private FamilyMember fMemberB;
	private FamilyMember fMemberO;
	private FamilyMember fMemberW;
	private FamilyMember fMemberN;
	private ExtraDice extraDice;
	// per ora li prendiamo da carte: private ArrayList<Effect> permanentEffects;
	private ArrayList<DevelopementCard> tCards;
	private ArrayList<DevelopementCard> vCards;
	private ArrayList<DevelopementCard> bCards;
	private ArrayList<DevelopementCard> cCards;
	private List<Resource> resources;
	
	public Player(FamilyColor color){

		this.color = color;
		resources = new ArrayList<Resource>();
		resources.add(new Coins(5));//questo è da modificare perché non hanno tutti 5 monete
		resources.add(new Woods(2));
		resources.add(new Stones(2));
		resources.add(new Servants(3));
		resources.add(new MilitaryPoints(0));
		resources.add(new VictoryPoints(0));
		resources.add(new FaithPoints(0));
		
		this.fMemberB = new FamilyMember(color, game.blackDice);
		this.fMemberO = new FamilyMember(color, game.orangeDice);
		this.fMemberW = new FamilyMember(color, game.whiteDice);
		this.fMemberN = new FamilyMember();
		this.extraDice = new ExtraDice();
	}
	
	
	public ExtraDice getExtraDice(){
		return extraDice;
	}

	
	public ArrayList<DevelopementCard> getCards(DevelopementCard dC){
		if (dC instanceof TerritoryCard) return tCards;
		if (dC instanceof BuildingCard) return bCards;
		if (dC instanceof VentureCard) return vCards;
		if (dC instanceof CharacterCard) return cCards;
		else return null;
	}
	
	
	public ArrayList <Resource> getResources(){
		return (ArrayList<Resource>) resources;
	}
	
	public void modifyResource(ArrayList<Resource> resources){
		//for each resource in input it take the correspondent resource in player and modify it
		resources.forEach(r->this.resources.forEach(tr->{if(tr.getClass().equals(r.getClass())){tr.modifyQuantity(r.getQuantity());}}));
	}
	

	
	public void takeACard(DevelopementCard card,ActionSpace aSpace, FamilyMember fMember, int servants){
		card.takeCard(this,aSpace,fMember,servants);
	}
	public void runProduction(FamilyMember fMember, int servants){
		RunProduction check = new RunProduction(this, fMember, servants);
		
	}
	public void runHarvest(){}
	
	public void goToTheMarket(){}
	public void getExcommunication(){}
	public void goToTheCouncilPalace(){}
	
	
	
	
	
	
	
	
}
