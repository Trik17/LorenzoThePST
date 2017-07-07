package it.polimi.ingsw.GC_04.server.model.action;


import java.util.List;

import it.polimi.ingsw.GC_04.server.controller.SupportFunctions;
import it.polimi.ingsw.GC_04.server.model.ActionSpace;
import it.polimi.ingsw.GC_04.server.model.FamilyMember;
import it.polimi.ingsw.GC_04.server.model.Model;
import it.polimi.ingsw.GC_04.server.model.Player;
import it.polimi.ingsw.GC_04.server.model.Production;
import it.polimi.ingsw.GC_04.server.model.effect.CouncilPrivilege;
import it.polimi.ingsw.GC_04.server.model.effect.Effect;

public class RunProduction extends Action {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 6346263748191041273L;
	private static final int PRODPENALITY = 3; 
	  private int prodValue; 
	   
	  public RunProduction(Model model,Player player, FamilyMember fMember, int servants) { 
	    super(model, player, fMember, servants); 
	    this.area = model.getProduction(); 
	    System.out.println(area.getASpaces().size());
	    aSpace = area.getASpaces().get(area.getASpaces().size()-1);
	     
	    if (model.getProduction().getASpace().isEmpty()) prodValue = value; 
	    else prodValue = value - PRODPENALITY; 
	  } 
	
	@Override
	public void checkExtraordinaryEffect(){
		super.checkExtraordinaryEffect();
			
		List<Production> productions=player.getProduction();
			
		for (Production prod:productions) {
			if (prod.getDiceValue() <= prodValue) {
				List<Effect> effects = prod.getEffects();
				
				//it put in councilPrivileges all the council privilege in effects and in requestedAuthorizationEffects all the effects that have AuthorizationRequested=true 
				SupportFunctions.addExtraordinaryEffects(councilPrivileges, requestedAuthorizationEffects, effects);
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
		
		if(model.getCouncilPalace().getTurnOrder().length < 3)
			area.getASpaces().add(new ActionSpace(1, null));
	}


	@Override
	public void apply() {
		applyEffects();
		applyPlayerChanges();
		createNewASpace();
		checkLeaderCards();
	}
	//TODO: fai chiedere al controller cosa attivare
	
	
	

	
}

