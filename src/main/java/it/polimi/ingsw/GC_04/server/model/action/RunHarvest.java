package it.polimi.ingsw.GC_04.server.model.action;

import java.util.List;

import it.polimi.ingsw.GC_04.server.model.ActionSpace;
import it.polimi.ingsw.GC_04.server.model.FamilyMember;
import it.polimi.ingsw.GC_04.server.model.Harvest;
import it.polimi.ingsw.GC_04.server.model.Model;
import it.polimi.ingsw.GC_04.server.model.Player;
import it.polimi.ingsw.GC_04.server.model.effect.CouncilPrivilege;
import it.polimi.ingsw.GC_04.server.model.effect.Effect;

//TODO se ci sono meno giocatori non si puo avere tutto il raccolto
public class RunHarvest extends Action{
	 /**
	 * 
	 */
	private static final long serialVersionUID = -4903615777627741577L;
	private static final int HARVPENALITY = 3; 
	  private int harvValue; 
	   
	  public RunHarvest(Model model, Player player, FamilyMember fMember, int servants) { 
	    super(model, player, fMember, servants); 
	    this.area = model.getHarvest(); 
	    aSpace = area.getASpaces().get(area.getASpaces().size()-1);
	     
	    if (area.getASpaces().size() < 2) 
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
		if(model.getCouncilPalace().getTurnOrder().length < 3)
			area.getASpaces().add(new ActionSpace(1, null));
	}

	
	@Override
	public void apply() {
		applyEffects();
		applyPlayerChanges();
		createNewASpace();
	}
	

}
