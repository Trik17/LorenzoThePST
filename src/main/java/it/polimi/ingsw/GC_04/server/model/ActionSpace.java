package it.polimi.ingsw.GC_04.server.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.polimi.ingsw.GC_04.server.model.effect.CouncilPrivilege;
import it.polimi.ingsw.GC_04.server.model.effect.Effect;

public class ActionSpace implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1257106955389829311L;
	private int activationCost;//necessary dice's value
	private List<Effect> effect;
	private FamilyMember fMember;
	
	@JsonCreator
	public ActionSpace(@JsonProperty("activationCost") int activationCost,@JsonProperty("effect") List<Effect> effect){
		
		this.effect = effect;
		if(activationCost<0)
			this.activationCost=0;
		else
			this.activationCost = activationCost;
	}
	
	public void setFamilyMember(FamilyMember fMember) {
		this.fMember = fMember;
	}
	
	public void reset() {
		this.fMember = null;
	}
	public int getActivationCost(){
		return activationCost;
	}
	
	public List<Effect> getEffect() {
		return effect;
	}
	public void applyEffects(Player player) {
		if (effect == null)
			return;
		effect.forEach(eff -> {if (!eff.isAuthorizationRequested() && !(eff instanceof CouncilPrivilege)) 
			eff.apply(player);});
		
	}
	public FamilyColor getPresentColor(){
		if (fMember == null) return null;
		return this.fMember.getFamilyColor();
	}
	
	public boolean isAvailable(){
		if(fMember == null) return true;
		return false;
	}
}
