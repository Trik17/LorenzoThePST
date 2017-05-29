package it.polimi.ingsw.GC_04.model;

//cambiata funzione RunProduction
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.polimi.ingsw.GC_04.model.Action.GoToTheCouncilPalace;
import it.polimi.ingsw.GC_04.model.Action.GoToTheMarket;
import it.polimi.ingsw.GC_04.model.Action.RunHarvest;
import it.polimi.ingsw.GC_04.model.Action.RunProduction;
import it.polimi.ingsw.GC_04.model.Card.BuildingCard;
import it.polimi.ingsw.GC_04.model.Card.CharacterCard;
import it.polimi.ingsw.GC_04.model.Card.DevelopmentCard;
import it.polimi.ingsw.GC_04.model.Card.TerritoryCard;
import it.polimi.ingsw.GC_04.model.Card.VentureCard;
import it.polimi.ingsw.GC_04.model.Resource.Resource;



public class Player {
	
	private Game game;
	private FamilyColor color;
	private FamilyMember fMemberB;
	private FamilyMember fMemberO;
	private FamilyMember fMemberW;
	private FamilyMember fMemberN;
	private ExtraDice extraDice;
	// per ora li prendiamo da carte: private ArrayList<Effect> permanentEffects;
	private List<TerritoryCard> tCards;
	private List<VentureCard> vCards;
	private List<BuildingCard> bCards;
	private List<CharacterCard> cCards;
	private List<Resource> resources;
	
	
	//TODO costruttore
	/*public Player(FamilyColor color){

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
	}*/
	
	
	public ExtraDice getExtraDice(){
		return extraDice;
	}

	
	public List<? extends DevelopmentCard> getCards(DevelopmentCard dC){
		if (dC instanceof TerritoryCard) return (List<TerritoryCard>) tCards;
		if (dC instanceof BuildingCard) return (List<BuildingCard>) bCards;
		if (dC instanceof VentureCard) return (List<VentureCard>) vCards;
		if (dC instanceof CharacterCard) return (List<CharacterCard>) cCards;
		else return null;
	}
	
	
	public ArrayList <Resource> getResources(){
		return (ArrayList<Resource>) resources;
	}
	
	public void modifyResource(List<Resource> cost){
		//for each resource in input it take the correspondent resource in player and modify it
		cost.forEach(r->this.resources.forEach(tr->{if(tr.getClass().equals(r.getClass())){tr.modifyQuantity(r.getQuantity());}}));
	}
	
	
	public void takeACard(DevelopmentCard card,ActionSpace aSpace, FamilyMember fMember, int servants){
		card.takeCard(this,aSpace,fMember,servants);
	}
	public void runProduction(FamilyMember fMember, int servants){
		RunProduction check = new RunProduction(this, fMember, servants);
		if (check.isApplicable()) check.apply();
		
	}
	public void runHarvest(FamilyMember fMember, int servants){
		RunHarvest check = new RunHarvest(this, fMember, servants);
		if (check.isApplicable()) check.apply();
	}
	
	public void goToTheMarket(FamilyMember fMember, int servants,ActionSpace aSpace){
		GoToTheMarket check = new GoToTheMarket(this, fMember, servants, aSpace);
		if (check.isApplicable()) check.apply();
	}
	
	public void goToTheCouncilPalace(FamilyMember fMember, int servants){
		GoToTheCouncilPalace check = new GoToTheCouncilPalace(this, fMember, servants);
		if (check.isApplicable()) check.apply();
	}
	
	public void getExcommunication(){}
	
	
	
	
	
	
}
