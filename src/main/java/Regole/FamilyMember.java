package Regole;

public class FamilyMember {
	
	public FamilyColor familyColor;
	public Dice dice;
	
	
	public FamilyMember(){
		this.familyColor = FamilyColor.NEUTRAL;
		this.dice = new Dice(DiceColor.NONE);
	}
	
	public FamilyMember(FamilyColor familyColor, Dice dice){
		this.familyColor = familyColor;
		this.dice = dice;
	}
}