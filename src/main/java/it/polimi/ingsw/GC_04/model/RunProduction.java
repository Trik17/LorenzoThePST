package it.polimi.ingsw.GC_04.model;

public class RunProduction extends Action {
	
	private static final int prodPenality = 3;
	private int prodValue;
	
	public RunProduction(Player player, FamilyMember fMember, int servants) {
		this.player = player;
		this.fMember = fMember;
		
		if (Production.getASpace().size() < 1) prodValue = value;
		else prodValue = value - prodPenality;
	}
	
	public boolean isColorAvailable() {
		return isColorAvailable(Production.instance(),fMember);
	}
	
	
	@Override
	public boolean isApplicable() {
		return isColorAvailable() &&
				isValueEnough();
	}
	
	
	
	
	

	
}

