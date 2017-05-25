package it.polimi.ingsw.GC_04.model;

//aggiunto createFamily()
//eliminato metodi updateExtra(), updateValue() e attributi extraValue e value
//aggiunto metodo getDice()

public class FamilyMember {
	
	private FamilyColor familyColor;
	private Dice dice;
	
	public FamilyMember[] createFamily(FamilyColor familyColor) {
		FamilyMember[] family = new FamilyMember[4];
		family[0] = new FamilyMember();
		family[1] = new FamilyMember(familyColor,dice.getBlackDice());
		family[2] = new FamilyMember(familyColor,dice.getWhiteDice());
		family[3] = new FamilyMember(familyColor,dice.getOrangeDice());
		
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
	
	
	public Dice getDice(){
		return dice;
	}
	
	public FamilyColor getFamilyColor(){
		return familyColor;
	}
}