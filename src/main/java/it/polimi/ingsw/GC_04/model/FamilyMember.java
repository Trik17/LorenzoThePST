package it.polimi.ingsw.GC_04.model;



//aggiunto createFamily()
//eliminato metodi updateExtra(), updateValue() e attributi extraValue e value
//aggiunto metodo getDice()

public class FamilyMember {
	
	private FamilyColor familyColor;
	private Dice dice;
	
	public static FamilyMember[] createFamily(FamilyColor familyColor) {
		FamilyMember[] family = new FamilyMember[4];
		family[0] = new FamilyMember();
		family[1] = new FamilyMember(familyColor,Dice.getBlackDice());
		family[2] = new FamilyMember(familyColor,Dice.getWhiteDice());
		family[3] = new FamilyMember(familyColor,Dice.getOrangeDice());
		
		return family;
			
	}
	
	private FamilyMember(){ //it creates neutral family members
		this.familyColor = FamilyColor.NEUTRAL;
		this.dice = Dice.getNeutralDice();
	}
	
	private FamilyMember(FamilyColor familyColor, Dice dice){
		this.familyColor = familyColor;
		this.dice = dice;
		
	}
	
	public FamilyMember(Dice dice) {	//it is needed to initialize TakeACardEffect
		this.familyColor = FamilyColor.NEUTRAL;
		this.dice = dice;
	}
	
	
	public Dice getDice(){
		return dice;
	}
	
	public FamilyColor getFamilyColor(){
		return familyColor;
	}
}