package it.polimi.ingsw.GC_04;

import java.util.ArrayList;

public class Player {
	
	private Game game;
	private FamilyColor color;
	private FamilyMember fMemberB;
	private FamilyMember fMemberO;
	private FamilyMember fMemberW;
	private FamilyMember fMemberN;
	private ArrayList<Effect> permanentEffects;
	private Coins coins;
	private Woods woods;
	private Stones stones;
	private Servants servants;
	private FaithPoints faithPoints;
	private MilitaryPoints militaryPoints;
	private VictoryPoints victoryPoints;
	
	
	
	public void modifyResource(Coins coins, Woods woods, Stones stones,Servants servants,FaithPoints fp,MilitaryPoints mp,VictoryPoints vp ){
		this.coins.modifyQuantity(coins.getQuantity());
		this.woods.modifyQuantity(woods.getQuantity());
		this.stones.modifyQuantity(stones.getQuantity());
		this.servants.modifyQuantity(servants.getQuantity());
		this.faithPoints.modifyQuantity(fp.getQuantity());
		this.militaryPoints.modifyQuantity(mp.getQuantity());
		this.victoryPoints.modifyQuantity(vp.getQuantity());
		
	}
	
	/* per bonus e malus permanenti dati da scomuniche o carte:
	 * metto degli attributi private che registrano questi bonus/malus
	 * e metodi pubblici per visualizzarli e un' altri metodi publici per editarli
	 */
	
	//caso dei bonus /malus dadi:  deve avere in ingresso il tipo di azione come enum
	public void extraValueDice(DiceAction action){
		
	}// diventa troppo grossa come funzione?

	
	
	public Player(Game game, FamilyColor color){
		this.game = game;
		this.color = color;
		
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
