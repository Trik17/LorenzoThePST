package it.polimi.ingsw.GC_04;

public class FamilyMember {
	
	private FamilyColor familyColor;
	private Dice dice;
	private int value;
	private int extra;
	
	
	public FamilyMember(){
		this.familyColor = FamilyColor.NEUTRAL;
		this.dice = new Dice(DiceColor.NONE);
	}
	
	public FamilyMember(FamilyColor familyColor, Dice dice){
		this.familyColor = familyColor;
		this.dice = dice;
		this.value = dice.getValue();
		
	}
	
	public void updateValue(){
		this.value = dice.getValue() + extra;
	}
	
	public void updateExtra(int extraValue){ //bonus/malus for permanent effects
		this.extra += extraValue;
	}
	
	public int getValue(){
		return value;
	}
	
	public FamilyColor getFamilyColor(){
		return familyColor;
	}
}