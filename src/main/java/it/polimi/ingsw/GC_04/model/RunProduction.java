package it.polimi.ingsw.GC_04.model;

//eliminata isColorAvail
public class RunProduction extends Action {
	
	private static final int prodPenality = 3;
	private int prodValue;
	
	public RunProduction(Player player, FamilyMember fMember, int servants) {
		super(player, fMember, servants);
		this.area = Production.instance();
		
		if (Production.getASpace().size() < 1) prodValue = value;
		else prodValue = value - prodPenality;
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

