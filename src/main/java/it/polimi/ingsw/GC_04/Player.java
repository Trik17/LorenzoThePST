package it.polimi.ingsw.GC_04;

public class Player {
	
	private Game game;
	private FamilyColor color;
	//private int turn;// classe a parte?!
	private PersonalBoard pBoard;
	/*private MarkerDisc discV;
	private MarkerDisc discM;
	private MarkerDisc discF;
	private MarkerDisc discO;*/
	private FamilyMember fMemberB;
	private FamilyMember fMemberO;
	private FamilyMember fMemberW;
	private FamilyMember fMemberN;
	private Action actions;
	/* per bonus e malus permanenti dati da scomuniche o carte:
	 * metto degli attributi private che registrano questi bonus/malus
	 * e metodi pubblici per visualizzarli e un' altri metodi publici per editarli
	 */
	
	//caso dei bonus /malus dadi:  deve avere in ingresso il tipo di azione come enum
	public int extraValueDice(DiceAction action){
		
	}// diventa troppo grossa come funzione?

	
	
	public Player(Game game, FamilyColor color, int turn){
		this.game = game;
		this.color = color;
		this.turn = turn;
		this.pBoard = new PersonalBoard(turn);
		 
		this.discV = new MarkerDisc(color,game.victoryTrack);
		this.discM = new MarkerDisc(color,game.militaryTrack);
		this.discF = new MarkerDisc(color,game.faithTrack);
		this.discO = new MarkerDisc(color,game.orderTrack);
		discO.position = turn;
		
		this.fMemberB = new FamilyMember(color, game.blackDice);
		this.fMemberO = new FamilyMember(color, game.orangeDice);
		this.fMemberW = new FamilyMember(color, game.whiteDice);
		this.fMemberN = new FamilyMember();
	}
	
	
		
		
	public void refreshFMemberValue(){
		fMemberB.updateValue();
		fMemberW.updateValue();
		fMemberO.updateValue();
		
	}
	
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
	
	
	public void runProduction(FamilyMember fMember, ActionSpace aSpace, PersonalBoard pBoard){
		
		result= this.rProduction.make(FamilyMember fMember, ActionSpace aSpace, PersonalBoard personalBoard);
	}
	
}
