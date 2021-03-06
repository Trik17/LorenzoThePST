package it.polimi.ingsw.GC_04.server.model;

import java.io.Serializable;

import it.polimi.ingsw.GC_04.server.model.area.VaticanReport;
import it.polimi.ingsw.GC_04.server.model.card.BuildingCard;
import it.polimi.ingsw.GC_04.server.model.card.CharacterCard;
import it.polimi.ingsw.GC_04.server.model.card.DevelopmentCard;
import it.polimi.ingsw.GC_04.server.model.card.TerritoryCard;
import it.polimi.ingsw.GC_04.server.model.card.VentureCard;
import it.polimi.ingsw.GC_04.server.model.resource.Coins;
import it.polimi.ingsw.GC_04.server.model.resource.Servants;
import it.polimi.ingsw.GC_04.server.model.resource.Stones;
import it.polimi.ingsw.GC_04.server.model.resource.Woods;

public class StateOfTheGameGUI implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1998515235150976420L;

	private String player;

	private String[] territoryCards;
	private String[] characterCards;
	private String[] buildingCards;
	private String[] ventureCards;

	private String[] territoryCardsBig;
	private String[] characterCardsBig;
	private String[] buildingCardsBig;
	private String[] ventureCardsBig;
	
	private String[] excommunicationTiles;
	
	private String[] mainLeaderCards;
	
	private String[] mainTCards;
	private String[] mainCCards;
	private String[] mainBCards;
	private String[] mainVCards;
	
	private String[] mainResources;
	private String[] dices;
	
	public StateOfTheGameGUI(){
	}
	
	public StateOfTheGameGUI(String player,  String[] excommunicationTiles,	String[] mainLeaderCards,String[] mainResources, String[] dices){
		this.player=player;
		this.excommunicationTiles=excommunicationTiles;
		this.mainLeaderCards=mainLeaderCards;
		this.mainResources=mainResources;
		this.dices=dices;		
	}
	
	
	public StateOfTheGameGUI(Model model, String player) {
		this.player = player;
		
		TerritoryCard[] tCards = (TerritoryCard[]) model.getTower(new TerritoryCard()).getCards();
		CharacterCard[] cCards = (CharacterCard[]) model.getTower(new CharacterCard()).getCards();
		BuildingCard[] bCards = (BuildingCard[]) model.getTower(new BuildingCard()).getCards();
		VentureCard[] vCards = (VentureCard[]) model.getTower(new VentureCard()).getCards();
		
		territoryCards = new String[tCards.length];
		characterCards = new String[cCards.length];
		buildingCards = new String[bCards.length];
		ventureCards = new String[vCards.length];
		
		for (int i = 0; i < territoryCards.length; i++) {
			if (tCards[i] != null)
				territoryCards[i] = tCards[i].getImageResized();
		}
		for (int i = 0; i < characterCards.length; i++) {
			if (cCards[i] != null)
				characterCards[i] = cCards[i].getImageResized();
		}
		for (int i = 0; i < buildingCards.length; i++) {
			if (bCards[i] != null)
				buildingCards[i] = bCards[i].getImageResized();
		}
		for (int i = 0; i < ventureCards.length; i++) {
			if (vCards[i] != null)
				ventureCards[i] = vCards[i].getImageResized();
		}
		
		territoryCardsBig = new String[tCards.length];
		characterCardsBig = new String[cCards.length];
		buildingCardsBig = new String[bCards.length];
		ventureCardsBig = new String[vCards.length];
		
		for (int i = 0; i < territoryCardsBig.length; i++) {
			if (tCards[i] != null)
				territoryCardsBig[i] = tCards[i].getImage();
		}
		for (int i = 0; i < characterCardsBig.length; i++) {
			if (cCards[i] != null)
				characterCardsBig[i] = cCards[i].getImage();
		}
		for (int i = 0; i < buildingCardsBig.length; i++) {
			if (bCards[i] != null)
				buildingCardsBig[i] = bCards[i].getImage();
		}
		for (int i = 0; i < ventureCardsBig.length; i++) {
			if (vCards[i] != null)
				ventureCardsBig[i] = vCards[i].getImage();
		}
		
		excommunicationTiles = new String[3];
		
		VaticanReport vaticanReport = model.getVaticanReport();
		
		for (int i = 0; i < excommunicationTiles.length; i++)
			excommunicationTiles[i] = vaticanReport.getExcommunication(i+1).getImage(); //getExcommunication take as parameter the period (1<=period<=3)
	
		mainLeaderCards = new String[5];
		
		int mLC = model.getPlayer(player).getLeaderCards().size();
		
		for (int i = 0; i < mLC; i++) {
			mainLeaderCards[i] = model.getPlayer(player).getLeaderCards().get(i).getImage();
		}
		
		for (int i = 0; i < mainLeaderCards.length; i++)
			if (mainLeaderCards[i] == null)
				mainLeaderCards[i] = "/LeaderCards/leaders_b_c_00.jpg";
		
		int num = model.getPlayer(player).getCards(new TerritoryCard()).size();		
		mainTCards = new String[num];
		for (int i = 0; i < mainTCards.length; i++)
			mainTCards[i] = model.getPlayer(player).getCards(new TerritoryCard()).get(i).getImageResized();
		
		num = model.getPlayer(player).getCards(new CharacterCard()).size();
		mainCCards = new String[num];
		for (int i = 0; i < mainCCards.length; i++)
			mainCCards[i] = model.getPlayer(player).getCards(new CharacterCard()).get(i).getImageResized();
		
		num = model.getPlayer(player).getCards(new BuildingCard()).size();
		mainBCards = new String[num];
		for (int i = 0; i < mainBCards.length; i++)
			mainBCards[i] = model.getPlayer(player).getCards(new BuildingCard()).get(i).getImageResized();
		
		num = model.getPlayer(player).getCards(new VentureCard()).size();
		mainVCards = new String[num];
		for (int i = 0; i < mainVCards.length; i++)
			mainVCards[i] = model.getPlayer(player).getCards(new VentureCard()).get(i).getImageResized();
		
		mainResources = new String[4];
		mainResources[0] = Integer.toString(model.getPlayer(player).getResource(new Coins()).getQuantity());
		mainResources[1] = Integer.toString(model.getPlayer(player).getResource(new Woods()).getQuantity());
		mainResources[2] = Integer.toString(model.getPlayer(player).getResource(new Stones()).getQuantity());
		mainResources[3] = Integer.toString(model.getPlayer(player).getResource(new Servants()).getQuantity());
		
		dices = new String[3];
		dices[0] = Integer.toString(model.getDice(DiceColor.BLACK).getValue());
		dices[1] = Integer.toString(model.getDice(DiceColor.WHITE).getValue());
		dices[2] = Integer.toString(model.getDice(DiceColor.ORANGE).getValue());
		
	}
	
	
	
	
	
	
	
	public String[] getTower(DevelopmentCard cardType) {
    	if (cardType instanceof TerritoryCard)
    		return territoryCards;
    	else if (cardType instanceof CharacterCard) 
    		return characterCards;
    	else if (cardType instanceof BuildingCard)
    		return buildingCards;
    	else 
    		return ventureCards;
		
	}
	public String[] getBigTower(DevelopmentCard cardType) {
		if (cardType instanceof TerritoryCard)
			return territoryCardsBig;
		else if (cardType instanceof CharacterCard) 
			return characterCardsBig;
		else if (cardType instanceof BuildingCard)
			return buildingCardsBig;
		else 
			return ventureCardsBig;
		
	}
	
	public String[] getPersonalBoard(DevelopmentCard cardType) {
		if (cardType instanceof TerritoryCard)
			return mainTCards;
		else if (cardType instanceof CharacterCard) 
			return mainCCards;
		else if (cardType instanceof BuildingCard)
			return mainBCards;
		else 
			return mainVCards;
		
	}
	
	public String[] getExcommunicationTiles() {
		return excommunicationTiles;
		
	}
	public String[] getMainLeaderCards() {
		return mainLeaderCards;
		
	}




	public String[] getMainResources() {
		return mainResources;
	}


	public String getPlayer() {
		return player;
	}

	public String[]	getDices() {
		return dices;
	}
	
}
