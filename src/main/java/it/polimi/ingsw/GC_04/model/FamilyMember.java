package it.polimi.ingsw.GC_04.model;



//aggiunto createFamily()
//eliminato metodi updateExtra(), updateValue() e attributi extraValue e value
//aggiunto metodo getDice()

public class FamilyMember {
	
	private FamilyColor familyColor;
	private Dice dice;
	private boolean used;
	
	public static FamilyMember[] createFamily(FamilyColor familyColor) {
		FamilyMember[] family = new FamilyMember[4];
		family[0] = new FamilyMember();
		family[1] = new FamilyMember(familyColor,Dice.getDice(DiceColor.BLACK));
		family[2] = new FamilyMember(familyColor,Dice.getDice(DiceColor.WHITE));
		family[3] = new FamilyMember(familyColor,Dice.getDice(DiceColor.ORANGE));
		
		return family;
			
	}
	
	private FamilyMember(){ //it creates neutral family members
		this.familyColor = FamilyColor.NEUTRAL;
		this.dice = Dice.getDice(DiceColor.NEUTRAL);
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
	
	public boolean isUsed() {
		return used;
		
	}
}