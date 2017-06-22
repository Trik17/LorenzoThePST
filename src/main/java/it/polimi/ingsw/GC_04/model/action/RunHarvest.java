package it.polimi.ingsw.GC_04.model.action;

import java.util.List;

import it.polimi.ingsw.GC_04.model.ActionSpace;
import it.polimi.ingsw.GC_04.model.FamilyMember;
import it.polimi.ingsw.GC_04.model.Harvest;
import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.area.CouncilPalaceArea;
import it.polimi.ingsw.GC_04.model.area.HarvestArea;
import it.polimi.ingsw.GC_04.model.effect.CouncilPrivilege;
import it.polimi.ingsw.GC_04.model.effect.Effect;


public class RunHarvest extends Action{
	 private static final int HARVPENALITY = 3; 
	  private int harvValue; 
	   
	  public RunHarvest(Player player, FamilyMember fMember, int servants) { 
	    super(player, fMember, servants); 
	    this.area = HarvestArea.instance(); 
	    aSpace = area.getASpaces().get(area.getASpaces().size()-1);
	     
	    if (HarvestArea.instance().getASpaces().size() < 2) 
	    	harvValue = value; 
	    else 
	    	harvValue = value - HARVPENALITY; 
	  } 
	
	@Override
	public void checkExtraordinaryEffect(){
		
		List<Harvest> harvest=player.getHarvest();
		
		for (Harvest harv:harvest) {
			if (harv.getDiceValue() <= harvValue) {
				List<Effect> effects = harv.getEffects();
				for (Effect eff:effects) {
					if (eff.getClass().equals(CouncilPrivilege.class))
						councilPrivileges.add((CouncilPrivilege) eff);
					if (eff.isAuthorizationRequested())
						requestedAuthorizationEffects.add(eff);
				}
				
			}
		}
	}
	@Override
	public void applyEffects() {
		super.applyEffects();
		
		List<Harvest> harvest=player.getHarvest();
		
		for (Harvest harv:harvest) {
			if (harv.getDiceValue() <= harvValue) {
				List<Effect> effects = harv.getEffects();
				for (Effect eff:effects) {
					if (!eff.isAuthorizationRequested() && !eff.getClass().equals(CouncilPrivilege.class))
						eff.apply(player);
				}
			}
		}
		
		
		
	}
	
	@Override
	public boolean isApplicable() {
		return isColorAvailable() &&
				isValueEnough() &&
				isAvailable();
	}

	public void createNewASpace() {
		if(CouncilPalaceArea.getTurnOrder().length < 3)
			HarvestArea.instance().getASpaces().add(new ActionSpace(1, null));
	}

	
	@Override
	public void apply() {
		applyEffects();
		applyPlayerChanges();
		createNewASpace();
	}
	

}
