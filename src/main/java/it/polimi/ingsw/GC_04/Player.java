package it.polimi.ingsw.GC_04;

import java.util.ArrayList;
import java.util.HashMap;

public class Player {
	
	private Game game;
	private FamilyColor color;
	private FamilyMember fMemberB;
	private FamilyMember fMemberO;
	private FamilyMember fMemberW;
	private FamilyMember fMemberN;
	private ArrayList<Effect> permanentEffects;
	private HashMap<ResourceType, Resource> resources;
	
	
	
	public void modifyResource(HashMap<ResourceType, Resource> resources){
		
		//per ogni coppia nome-risorsa presente nel parametro, prende la quantità di quella risorsa
		//e la aggiunge/sottrae alla corrispettiva risorsa del player
		
		resources.forEach((resType,res)-> this.resources.get(resType).modifyQuantity(resources.get(resType).getQuantity()));
		
	}
	
	
	
	
		
	
	/* per bonus e malus permanenti dati da scomuniche o carte:
	 * metto degli attributi private che registrano questi bonus/malus
	 * e metodi pubblici per visualizzarli e un' altri metodi publici per editarli
	 */
	
	//caso dei bonus /malus dadi:  deve avere in ingresso il tipo di azione come enum
	public void extraValueDice(DiceAction action){
		
	}// diventa troppo grossa come funzione?

	
	
	public Player(FamilyColor color){

		this.color = color;
		resources.put(ResourceType.COIN, new Coins(5));//questo è da modificare perché non hanno tutti 5 monete
		resources.put(ResourceType.WOOD, new Woods(2));
		resources.put(ResourceType.STONE, new Stones(2));
		resources.put(ResourceType.SERVANT, new Servants(3));
		resources.put(ResourceType.MILITARYP, new MilitaryPoints(0));
		resources.put(ResourceType.VICTORYP, new VictoryPoints(0));
		resources.put(ResourceType.FAITHP, new FaithPoints(0));
		
		this.fMemberB = new FamilyMember(color, game.blackDice());
		this.fMemberO = new FamilyMember(color, game.orangeDice);
		this.fMemberW = new FamilyMember(color, game.whiteDice);
		this.fMemberN = new FamilyMember();
	}
	
	public void takeATerritory(){
		
		
		
		/*final CommandFactory cf = CommandFactory.init();
		
		cf.executeCommand("Light on");*/
		
	}
		
		
	public void refreshFMemberValue(){
		fMemberB.updateValue();
		fMemberW.updateValue();
		fMemberO.updateValue();
		
	}
	
	
	
	public void runProduction(){}
	public void runHarvest(){}
	public void takeACard(){}
	public void goToTheMarket(){}
	public void getExcommunication(){}
	public void goToTheCouncilPalace(){}
	
	
	
	/*public void takeACard(DevelopementCard card){
		if(card.type == CardType.TERRITORY){
			
			if(pBoard.requestedMilitaryPoints <= discM.position){
				pBoard.territory.add(card);
				//TODO: si prende gli effetti immediati
				if(pBoard.territory.size() >= 2)
					pBoard.requestedMilitaryPoints += pBoard.territory.size() + 1;
			}else{
				System.out.println("Non puoi prendere la carta");
			}
		}else{
			//Controlla se hai abbastanza risorse
		}
		
	}*/
	
	
	
	
}
