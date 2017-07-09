package it.polimi.ingsw.GC_04.server.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import it.polimi.ingsw.GC_04.server.model.ActionSpace;
import it.polimi.ingsw.GC_04.server.model.FamilyColor;
import it.polimi.ingsw.GC_04.server.model.FamilyMember;
import it.polimi.ingsw.GC_04.server.model.Model;
import it.polimi.ingsw.GC_04.server.model.Player;
import it.polimi.ingsw.GC_04.server.model.area.BuildingTower;
import it.polimi.ingsw.GC_04.server.model.area.CharacterTower;
import it.polimi.ingsw.GC_04.server.model.area.CouncilPalaceArea;
import it.polimi.ingsw.GC_04.server.model.area.HarvestArea;
import it.polimi.ingsw.GC_04.server.model.area.MarketArea;
import it.polimi.ingsw.GC_04.server.model.area.ProductionArea;
import it.polimi.ingsw.GC_04.server.model.area.TerritoryTower;
import it.polimi.ingsw.GC_04.server.model.area.VaticanReport;
import it.polimi.ingsw.GC_04.server.model.area.VentureTower;
import it.polimi.ingsw.GC_04.server.model.card.BuildingCard;
import it.polimi.ingsw.GC_04.server.model.card.CharacterCard;
import it.polimi.ingsw.GC_04.server.model.card.DevelopmentCard;
import it.polimi.ingsw.GC_04.server.model.card.ExcommunicationTile;
import it.polimi.ingsw.GC_04.server.model.card.LeaderCard;
import it.polimi.ingsw.GC_04.server.model.card.TerritoryCard;
import it.polimi.ingsw.GC_04.server.model.card.VentureCard;

public class Initializer {
	private static final int INITIALPOSITION = 0;
	private static final int HALFPOSITION = 4;
	private static final int FINALPOSITION = 8;
	
	private int firstOfTheAge = 0;
	private int lastOfTheAge = 8;
	
	private int period = 1;
	
	private final TerritoryCard[] tCards;
	private final CharacterCard[] cCards;
	private final BuildingCard[] bCards;
	private final VentureCard[] vCards;
	
	private TerritoryCard[] territoryCards;
	private CharacterCard[] characterCards;
	private BuildingCard[] buildingCards;
	private VentureCard[] ventureCards;
	
	private final List<ExcommunicationTile> eTiles;
	private List<LeaderCard> leaderCards;

	private Model model;
	private Player[] players;
										
	public Initializer(Player[] players,Model model) {
		JsonMapper jsonMapper=new JsonMapper();		
		leaderCards=new ArrayList<>();
		this.model = model;
		int nrOfPlayers = players.length;
		
		this.players = players;
		
		this.tCards = jsonMapper.getTerritoryCardArray();
		this.cCards = jsonMapper.getCharacterCardArray();
		this.bCards = jsonMapper.getBuildingCardArray();
		this.vCards = jsonMapper.getVentureCardsArray();
		this.eTiles = jsonMapper.getExcommunicationTile();
		
		ExcommunicationTile[] excommunications = new ExcommunicationTile[3];
		
		LeaderCard[] leaderCardsArray=jsonMapper.getLeaderCards();
		
		SupportFunctions.shuffleArray(leaderCardsArray);
		
		for (int i = 0; i < leaderCardsArray.length; i++) {
			this.leaderCards.add(leaderCardsArray[i]);
		}
		
		
		Random rnd = new Random();
		for (int i = 0; i < 3; i++) {
			Object[] tiles = eTiles.stream().filter(tile -> tile.getPeriod() == period).toArray();
			int selected = rnd.nextInt(tiles.length);
			excommunications[i] = (ExcommunicationTile) tiles[selected];
			period++;
		}
		

		VaticanReport vaticanReport = new VaticanReport((ExcommunicationTile[]) excommunications);
		
		List<ActionSpace> aSpaces=jsonMapper.getActionSpaces();
		
		territoryCards = Arrays.copyOfRange(tCards, firstOfTheAge, lastOfTheAge);
		characterCards = Arrays.copyOfRange(cCards, firstOfTheAge, lastOfTheAge);
		buildingCards = Arrays.copyOfRange(bCards, firstOfTheAge, lastOfTheAge);
		ventureCards = Arrays.copyOfRange(vCards, firstOfTheAge, lastOfTheAge);
		
		SupportFunctions.shuffleArray(territoryCards);
		SupportFunctions.shuffleArray(characterCards);
		SupportFunctions.shuffleArray(buildingCards);
		SupportFunctions.shuffleArray(ventureCards);
		
		TerritoryCard[] currentTerritoryCards = Arrays.copyOfRange(territoryCards, INITIALPOSITION, HALFPOSITION);
		CharacterCard[] currentCharacterCards = Arrays.copyOfRange(characterCards, INITIALPOSITION, HALFPOSITION);
		BuildingCard[] currentBuildingCards = Arrays.copyOfRange(buildingCards, INITIALPOSITION, HALFPOSITION);
		VentureCard[] currentVentureCards = Arrays.copyOfRange(ventureCards, INITIALPOSITION, HALFPOSITION);
		
		CouncilPalaceArea councilPalaceArea = new CouncilPalaceArea(players,aSpaces.get(20));
		TerritoryTower territoryTower = new TerritoryTower(currentTerritoryCards, aSpaces.subList(0,4));
		CharacterTower characterTower = new CharacterTower(currentCharacterCards, aSpaces.subList(4,8));
		BuildingTower buildingTower = new BuildingTower(currentBuildingCards, aSpaces.subList(8,12));
		VentureTower ventureTower = new VentureTower(currentVentureCards, aSpaces.subList(12,16));
				
		MarketArea marketArea;
		if (nrOfPlayers < 4)
			marketArea = new MarketArea(aSpaces.subList(16, aSpaces.size()-2)); 
		else
			marketArea = new MarketArea(aSpaces.subList(16, aSpaces.size()));
		
		switch (nrOfPlayers) {
		case 4:
			players[3].setFamily(FamilyMember.createFamily(FamilyColor.BLUE,model));
		case 3:
			players[2].setFamily(FamilyMember.createFamily(FamilyColor.RED,model));
		default:
			players[1].setFamily(FamilyMember.createFamily(FamilyColor.GREEN,model));
			players[0].setFamily(FamilyMember.createFamily(FamilyColor.YELLOW,model));

		}
		
		int numLeader=leaderCards.size();
		int leaderPerPlayer = numLeader/nrOfPlayers;
		int index = 0;
		
		for (int j = 0; j < players.length; j++) {
			int cont = leaderPerPlayer;
			while(cont > 0) {
				players[j].setLeaderCards(leaderCards.get(index));
				index++;
				cont--;
			}
		}
		
		HarvestArea harvest = new HarvestArea();
		ProductionArea production = new ProductionArea();
		
		harvest.getASpaces().add(new ActionSpace(1, null));
		production.getASpaces().add(new ActionSpace(1, null));
		
		firstOfTheAge = 8;
		lastOfTheAge = 16;
		
		model.setAreas(territoryTower, characterTower, buildingTower, ventureTower, marketArea, councilPalaceArea, harvest, production, vaticanReport);
	}
	
	
	
	public void changeTurn() {
		
		TerritoryCard[] nextTCards;
		CharacterCard[] nextCCards;
		BuildingCard[] nextBCards;
		VentureCard[] nextVCards;
		
		if (model.isLastPeriod()) {
			
			territoryCards = Arrays.copyOfRange(tCards, firstOfTheAge, lastOfTheAge);
			characterCards = Arrays.copyOfRange(cCards, firstOfTheAge, lastOfTheAge);
			buildingCards = Arrays.copyOfRange(bCards, firstOfTheAge, lastOfTheAge);
			ventureCards = Arrays.copyOfRange(vCards, firstOfTheAge, lastOfTheAge);
			
			SupportFunctions.shuffleArray(territoryCards);
			SupportFunctions.shuffleArray(characterCards);
			SupportFunctions.shuffleArray(buildingCards);
			SupportFunctions.shuffleArray(ventureCards);
			
			nextTCards = Arrays.copyOfRange(territoryCards, INITIALPOSITION, HALFPOSITION);
			nextCCards = Arrays.copyOfRange(characterCards, INITIALPOSITION, HALFPOSITION);
			nextBCards = Arrays.copyOfRange(buildingCards, INITIALPOSITION, HALFPOSITION);
			nextVCards = Arrays.copyOfRange(ventureCards, INITIALPOSITION, HALFPOSITION);
		
			firstOfTheAge = 16;
			lastOfTheAge = 24;
			
		}else {
			
			nextTCards = Arrays.copyOfRange(territoryCards, HALFPOSITION, FINALPOSITION);
			nextCCards = Arrays.copyOfRange(characterCards, HALFPOSITION, FINALPOSITION);
			nextBCards = Arrays.copyOfRange(buildingCards, HALFPOSITION, FINALPOSITION);
			nextVCards = Arrays.copyOfRange(ventureCards, HALFPOSITION, FINALPOSITION);
		}
		
		model.getTower(new TerritoryCard()).reset(nextTCards);
		model.getTower(new CharacterCard()).reset(nextCCards);
		model.getTower(new BuildingCard()).reset(nextBCards);
		model.getTower(new VentureCard()).reset(nextVCards);
		
		model.getMarket().reset();
		model.getHarvest().reset();
		model.getProduction().reset();
		
		for(Player player:players) {
			for (int i = 0; i < player.getFamily().length; i++) {
				player.getFamily()[i].switchUsed();
			}
		}
		
		model.getCouncilPalace().setTurnOrder();
		
		
	}
	
	public List<DevelopmentCard> cardsOnTheTable() {
		List<DevelopmentCard> cardsOnTheTable = new ArrayList<>();
		cardsOnTheTable.addAll(Arrays.asList(model.getTower(new TerritoryCard()).getCards()));
		cardsOnTheTable.addAll(Arrays.asList(model.getTower(new CharacterCard()).getCards()));
		cardsOnTheTable.addAll(Arrays.asList(model.getTower(new BuildingCard()).getCards()));
		cardsOnTheTable.addAll(Arrays.asList(model.getTower(new VentureCard()).getCards()));
		
		return cardsOnTheTable;
	}
	
	
}
