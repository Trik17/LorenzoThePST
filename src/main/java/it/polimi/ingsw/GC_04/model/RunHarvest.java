package it.polimi.ingsw.GC_04.model;

//eliminata isColor

public class RunHarvest extends Action{
	private static final int harvPenality = 3;
	private int harvValue;
	
	public RunHarvest(Player player, FamilyMember fMember, int servants) {
		super(player, fMember, servants);
		this.area = Harvest.instance();
		
		if (Production.getASpace().size() < 1) harvValue = value;
		else harvValue = value - harvPenality;
	}
	
	@Override
	public boolean isApplicable() {
		return isColorAvailable() &&
				isValueEnough() &&
				isPlaceAvailable();
	}

	@Override
	public void apply() {
		// TODO Auto-generated method stub
		
	}
	

}
