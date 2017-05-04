package Regole;

public class Player {
	
	public Game game;
	
	public FamilyColor color;
	public int turn;
	public PersonalBoard personalBoard;
	public MarkerDisc discV;
	public MarkerDisc discM;
	public MarkerDisc discF;
	public MarkerDisc discO;
	public FamilyMember fMemberB;
	public FamilyMember fMemberO;
	public FamilyMember fMemberW;
	public FamilyMember fMemberN;
	
	public Player(Game game, FamilyColor color, int turn){
		this.game = game;
		this.color = color;
		this.turn = turn;
		this.personalBoard = new PersonalBoard(turn);
		 
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
	
	public void takeACard(DevelopementCard card){
		if(card.type == CardType.TERRITORY){
			
			if(personalBoard.requestedMilitaryPoints <= discM.position){
				personalBoard.territory.add(card);
				//TODO: si prende gli effetti immediati
				if(personalBoard.territory.size() >= 2)
					personalBoard.requestedMilitaryPoints += personalBoard.territory.size() + 1;
			}else{
				System.out.println("Non puoi prendere la carta");
			}
		}else{
			//Controlla se hai abbastanza risorse
		}
		
	}
	
}
