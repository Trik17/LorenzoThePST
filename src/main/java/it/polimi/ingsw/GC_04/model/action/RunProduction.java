package it.polimi.ingsw.GC_04.model.action;


import java.util.List;

import it.polimi.ingsw.GC_04.model.ActionSpace;
import it.polimi.ingsw.GC_04.model.FamilyMember;
import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.Production;
import it.polimi.ingsw.GC_04.model.area.CouncilPalaceArea;
import it.polimi.ingsw.GC_04.model.area.ProductionArea;
import it.polimi.ingsw.GC_04.model.effect.CouncilPrivilege;
import it.polimi.ingsw.GC_04.model.effect.Effect;

public class RunProduction extends Action {
	 private static final int PRODPENALITY = 3; 
	  private int prodValue; 
	   
	  public RunProduction(Player player, FamilyMember fMember, int servants) { 
	    super(player, fMember, servants); 
	    this.area = ProductionArea.instance(); 
	    System.out.println(area.getASpaces().size());
	    aSpace = area.getASpaces().get(area.getASpaces().size()-1);
	     
	    if (ProductionArea.instance().getASpace().isEmpty()) prodValue = value; 
	    else prodValue = value - PRODPENALITY; 
	  } 
	
	@Override
	public void checkExtraordinaryEffect(){
			
		List<Production> productions=player.getProduction();
			
		for (Production prod:productions) {
			if (prod.getDiceValue() <= prodValue) {
				List<Effect> effects = prod.getEffects();
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
			
		List<Production> productions=player.getProduction();
		
		for (Production prod:productions) {
			if (prod.getDiceValue() <= prodValue) {
				List<Effect> effects = prod.getEffects();
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
			ProductionArea.instance().getASpaces().add(new ActionSpace(1, null));
	}


	@Override
	public void apply() {
		applyEffects();
		applyPlayerChanges();
		createNewASpace();
	}
	//TODO: fai chiedere al controller cosa attivare
	
	
	

	
}

