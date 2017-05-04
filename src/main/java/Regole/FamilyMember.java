package Regole;

public class FamilyMember {
	
	public FamilyColor familyColor;
	public Dice dice;
	private int value;
	private int extra;
	
	
	public FamilyMember(){
		this.familyColor = FamilyColor.NEUTRAL;
		this.dice = new Dice(DiceColor.NONE);
	}
	
	public FamilyMember(FamilyColor familyColor, Dice dice){
		this.familyColor = familyColor;
		this.dice = dice;
		this.value = dice.value;
		
	}
	
	public void updateValue(){
		this.value = dice.value + extra;
	}
	
	public void updateExtra(int extraValue){ //bonus/malus for permanent effects
		this.extra += extraValue;
	}
}