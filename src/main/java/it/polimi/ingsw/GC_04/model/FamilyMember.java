package it.polimi.ingsw.GC_04.model;

//eliminato metodi updateExtra(), updateValue() e attributi extraValue e value
//aggiunto metodo getDice()

public class FamilyMember {
	
	private FamilyColor familyColor;
	private Dice dice;
	
	
	public FamilyMember(){
		this.familyColor = FamilyColor.NEUTRAL;
		this.dice = new Dice(DiceColor.NONE);
	}
	
	public FamilyMember(FamilyColor familyColor, Dice dice){
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