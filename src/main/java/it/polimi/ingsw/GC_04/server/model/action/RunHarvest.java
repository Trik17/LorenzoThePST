package it.polimi.ingsw.GC_04.server.model.action;

import java.util.List;

import it.polimi.ingsw.GC_04.server.controller.SupportFunctions;
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
	     
	    if (area.getASpaces().size() == 1) 
	    	harvValue = value; 
	    else 
	    	harvValue = value - HARVPENALITY; 
	  } 
	
	@Override
	public void checkExtraordinaryEffect(){
		super.checkExtraordinaryEffect();
		
		List<Harvest> harvest=player.getHarvest();
		
		for (Harvest harv:harvest) {
			if (harv.getDiceValue() <= harvValue) {
				List<Effect> effects = harv.getEffects();
				
				//it put in councilPrivileges all the council privilege in effects and in requestedAuthorizationEffects all the effects that have AuthorizationRequested=true 
				SupportFunctions.addExtraordinaryEffects(councilPrivileges, requestedAuthorizationEffects, effects);
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
	
	/*createNewASpace
	 * this method checks if there are more than 2 players:
	 * if it is the case, it will be impossible to run harvest for the two of them
	 * in the same row because the action space won't be created
	 */
	public void createNewASpace() {
		if(model.getPlayers().length > 2)
			area.getASpaces().add(model.getHarvest().getActionSpaceDefault());
	}
	
	
	@Override
	public boolean isAvailable() {
		int last = model.getHarvest().getASpaces().size() -1;
		return model.getHarvest().getASpaces().get(last).isAvailable() && !fMember.isUsed();
			
	}
	
	@Override
	public boolean isApplicable() {
		return isAvailable() &&
				isColorAvailable() &&
				isValueEnough();
	}

	
	

	
	@Override
	public void apply() {
		applyEffects();
		applyPlayerChanges();
		createNewASpace();
		checkLeaderCards();
	}
	

}
