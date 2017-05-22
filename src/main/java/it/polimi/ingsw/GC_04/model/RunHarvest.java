package it.polimi.ingsw.GC_04.model;

public class RunHarvest extends Action{
	private static final int harvPenality = 3;
	private int harvValue;
	
	public RunHarvest(Player player, FamilyMember fMember, int servants) {
		this.player = player;
		this.fMember = fMember;
		
		if (Production.getASpace().size() < 1) harvValue = value;
		else harvValue = value - harvPenality;
	}
	
	public boolean isColorAvailable() {
		return isColorAvailable(Production.instance(),fMember);
	}
	
	
	@Override
	public boolean isApplicable() {
		return isColorAvailable() &&
				isValueEnough() &&
				isPlaceAvailable();
	}
	

}
