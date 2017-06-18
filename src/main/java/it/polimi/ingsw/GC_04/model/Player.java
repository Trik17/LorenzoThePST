package it.polimi.ingsw.GC_04.model;

import java.util.ArrayList;
import java.util.List;

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
import it.polimi.ingsw.GC_04.model.resource.VictoryPoints;
import it.polimi.ingsw.GC_04.model.resource.Woods;

public class Player {
	private String name;
	private int id;
	private Model game;
	private FamilyMember[] family;
	private ExtraDice extraDice;
	private Discount discount;	
	private List<DevelopmentCard> tCards;
	private List<DevelopmentCard> vCards;
	private List<DevelopmentCard> bCards;
	private List<DevelopmentCard> cCards;
	private List<Resource> resources;
	private boolean actionSpacePenality;
	
	private List<Harvest> harvestList;
	private List<Production> productionList;
	
	public int getId(){
		return this.id;
	}
	
	
	public Player(String name, FamilyColor color, int turn, int id){
		// 1<=turn<=4 only for initial coins
		// 0<=id<=4
		this.name = name;
		this.id=id;
		
		resources = new ArrayList<Resource>();
		
		resources.add(new Woods(2));
		resources.add(new Stones(2));
		resources.add(new Servants(3));
		resources.add(new MilitaryPoints(0));
		resources.add(new VictoryPoints(0));
		resources.add(new FaithPoints(0));
		resources.add(new Coins(turn+4));
		
		family = FamilyMember.createFamily(color);
		this.extraDice = new ExtraDice();
		harvestList = new ArrayList<Harvest>();
		productionList = new ArrayList<Production>();
		
	}
	
	public Discount getDiscount(){
		return discount;
	}
	
	public boolean getActionSpacePenality() {
		return actionSpacePenality;
		
	}
	
	public void setActionSpacePenality() {
		actionSpacePenality = true;
		
	}
	
	public FamilyMember getFamilyMember(DiceColor diceColor) {
		if (diceColor == DiceColor.BLACK)
			return family[1];
		if (diceColor == DiceColor.WHITE) 
			return family[2];
		if (diceColor == DiceColor.ORANGE)
			return family[3];
		else
			return family[0];
		
		
	}
	public ExtraDice getExtraDice(){
		return extraDice;
	}

	
	public List<DevelopmentCard> getCards(DevelopmentCard dC){
		if (dC instanceof TerritoryCard) return tCards;
		if (dC instanceof BuildingCard) return bCards;
		if (dC instanceof VentureCard) return vCards;
		if (dC instanceof CharacterCard) return cCards;
		else return null;
	}
	
	
	public List<Resource> getResources(){
		return resources;
	}
	
	public String getName() {
		return name;
		
	}
	
	
	/*public void takeACard(DevelopmentCard card,ActionSpace aSpace, FamilyMember fMember, int servants,List<Resource> cost){
		card.takeCard(this,aSpace,fMember,servants,cost);
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
	
	*/
	
	
	
	
}
