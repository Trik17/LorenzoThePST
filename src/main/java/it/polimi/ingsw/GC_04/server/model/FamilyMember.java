package it.polimi.ingsw.GC_04.server.model;

import java.io.Serializable;

public class FamilyMember implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6793943971429482018L;
	private FamilyColor familyColor;
	private Dice dice;
	private boolean used;
	
	public static FamilyMember[] createFamily(FamilyColor familyColor,Model model) {
		FamilyMember[] family = new FamilyMember[4];
		family[0] = new FamilyMember();
		family[1] = new FamilyMember(familyColor,model.getDice(DiceColor.BLACK));
		family[2] = new FamilyMember(familyColor,model.getDice(DiceColor.ORANGE));
		family[3] = new FamilyMember(familyColor,model.getDice(DiceColor.WHITE));
		
		return family;
			
	}
	
	private FamilyMember(){ //it creates neutral family members
		this.familyColor = FamilyColor.NEUTRAL;
		this.dice = new Dice(0);
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
	public void switchUsed() {
		used = !used;
		
	}

	public static void changeValue(FamilyMember[] family, int value, boolean valueAdded, boolean onlyNeutralMember) {
		if (valueAdded) {
			if (onlyNeutralMember)
				family[0].dice = new Dice(value);
			
			else {
				for (int i = 1; i < family.length; i++) {
					int newValue = family[i].getDice().getValue() + value;
					family[i].dice = new Dice(newValue);
				}
			}
		}else{
			for (int i = 1; i < family.length; i++) {
				family[i].dice = new Dice(value);
			}
		}
	}
	
}