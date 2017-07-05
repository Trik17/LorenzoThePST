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
import it.polimi.ingsw.GC_04.server.model.card.TerritoryCard;
import it.polimi.ingsw.GC_04.server.model.card.VentureCard;

public class Initializer {
	private int initialPosition = 0;
	private int finalPosition = 4;
	private int period = 1;
	
	private final TerritoryCard[] tCards;
	private final CharacterCard[] cCards;
	private final BuildingCard[] bCards;
	private final VentureCard[] vCards;
	private final List<ExcommunicationTile> eTiles;

	private Model model;
	private Player[] players;
										
	public Initializer(Player[] players,Model model) {
		JsonMapper jsonMapper=new JsonMapper();		
		
		this.model = model;
		int nrOfPlayers = players.length;
		
		this.players = players;
		
		this.tCards = jsonMapper.getTerritoryCardArray();
		this.cCards = jsonMapper.getCharacterCardArray();
		this.bCards = jsonMapper.getBuildingCardArray();
		this.vCards = jsonMapper.getVentureCardsArray();
		this.eTiles = jsonMapper.getExcommunicationTile();
		ExcommunicationTile[] excommunications = new ExcommunicationTile[3];
		
		Random rnd = new Random();
		for (int i = 0; i < 3; i++) {
			Object[] tiles = eTiles.stream().filter(tile -> tile.getPeriod() == period).toArray();
			int selected = rnd.nextInt(tiles.length);
			excommunications[i] = (ExcommunicationTile) tiles[selected];
			period++;
		}
		

		VaticanReport vaticanReport = new VaticanReport((ExcommunicationTile[]) excommunications);
		
		List<ActionSpace> aSpaces=jsonMapper.getActionSpaces();
		
		CouncilPalaceArea councilPalaceArea = new CouncilPalaceArea(players,aSpaces.get(20));
		TerritoryTower territoryTower = new TerritoryTower(Arrays.copyOfRange(tCards, initialPosition, finalPosition), aSpaces.subList(0,4));
		CharacterTower characterTower = new CharacterTower(Arrays.copyOfRange(cCards, initialPosition, finalPosition), aSpaces.subList(4,8));
		BuildingTower buildingTower = new BuildingTower(Arrays.copyOfRange(bCards, initialPosition, finalPosition), aSpaces.subList(8,12));
		VentureTower ventureTower = new VentureTower(Arrays.copyOfRange(vCards, initialPosition, finalPosition), aSpaces.subList(12,16));
		
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
		
		HarvestArea harvest = new HarvestArea();
		ProductionArea production = new ProductionArea();
		
		harvest.getASpaces().add(new ActionSpace(1, null));
		production.getASpaces().add(new ActionSpace(1, null));
		
		initialPosition = 4;
		finalPosition = 8;
		
		model.setAreas(territoryTower, characterTower, buildingTower, ventureTower, marketArea, councilPalaceArea, harvest, production, vaticanReport);
	}
	
	
	
	public void changeTurn() {
		model.getTower(new TerritoryCard()).reset(Arrays.copyOfRange(tCards, initialPosition, finalPosition));
		model.getTower(new CharacterCard()).reset(Arrays.copyOfRange(cCards, initialPosition, finalPosition));
		model.getTower(new BuildingCard()).reset(Arrays.copyOfRange(bCards, initialPosition, finalPosition));
		model.getTower(new VentureCard()).reset(Arrays.copyOfRange(vCards, initialPosition, finalPosition));
		
		model.getMarket().reset();
		model.getHarvest().reset();
		model.getProduction().reset();
		
		for(Player player:players) {
			for (int i = 0; i < player.getFamily().length; i++) {
				player.getFamily()[i].switchUsed();
			}
		}
		
		model.getCouncilPalace().setTurnOrder();
		
		initialPosition += 4;
		finalPosition += 4;
		
		
	}
	
	public List<DevelopmentCard> cardsOnTheTable() {
		List<DevelopmentCard> cardsOnTheTable = new ArrayList<DevelopmentCard>();
		cardsOnTheTable.addAll(Arrays.asList(model.getTower(new TerritoryCard()).getCards()));
		cardsOnTheTable.addAll(Arrays.asList(model.getTower(new CharacterCard()).getCards()));
		cardsOnTheTable.addAll(Arrays.asList(model.getTower(new BuildingCard()).getCards()));
		cardsOnTheTable.addAll(Arrays.asList(model.getTower(new VentureCard()).getCards()));
		
		return cardsOnTheTable;
	}
	
	
}
