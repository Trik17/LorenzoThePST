package Regole;

public class Player {
	
	public Game game;
	
	public FamilyColor color;
	public int turn;
	public PersonalBoard board;
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
		this.board = new PersonalBoard(turn);
		 
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
		
		
			
	
	//non so bene dove andrà questa funzione ancora
	public void RollTheDice(){
		Dice black = new Dice(DiceColor.BLACK);
		game.blackDice = black;
		Dice white = new Dice(DiceColor.WHITE);
		game.whiteDice = white;
		Dice orange = new Dice(DiceColor.ORANGE);
		game.orangeDice = orange;
			
	}
	
	public void takeACard(DevelopementCard card){
		if(card.type == CardType.TERRITORY){
			
			if(board.requestedMilitaryPoints <= discM.position){
				board.territory.add(card);
				//TODO: si prende gli effetti immediati
				if(board.territory.size() >= 3)
					board.requestedMilitaryPoints += board.territory.size();
			}else{
				System.out.println("Non puoi prendere la carta");
			}
		}else{
			//Controlla se hai abbastanza risorse
		}
		
	}
	
}
