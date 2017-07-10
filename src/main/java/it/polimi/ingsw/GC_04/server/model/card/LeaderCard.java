package it.polimi.ingsw.GC_04.server.model.card;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.polimi.ingsw.GC_04.server.model.Player;
import it.polimi.ingsw.GC_04.server.model.effect.BonusTurnResourcesEffect;
import it.polimi.ingsw.GC_04.server.model.effect.Effect;
import it.polimi.ingsw.GC_04.server.model.resource.Resource;

public class LeaderCard extends Card {
	private String name;
	private List<Resource> activationRequirementRes;
	private List<DevelopmentCard> activationRequirementCard;
	private Effect effect;
	private String image;
	private boolean activated;
	private String description;
	
	@JsonCreator
	public LeaderCard(@JsonProperty("name") String name,@JsonProperty("activationRequirementRes") List<Resource> activationRequirementRes,@JsonProperty("activationRequirementCard") List<DevelopmentCard> activationRequirementCard,@JsonProperty("effect") Effect effect,@JsonProperty("image") String image,@JsonProperty("description") String description) {
		this.name = name;
		this.activationRequirementRes = activationRequirementRes;
		this.activationRequirementCard = activationRequirementCard;
		this.effect = effect;
		this.image = image;
		this.description = description;
	}

	public List<Resource> getActivationRequirementRes() {
		return activationRequirementRes;
	}

	public void setActivationRequirementRes(List<Resource> activationRequirementRes) {
		this.activationRequirementRes = activationRequirementRes;
	}

	public List<DevelopmentCard> getActivationRequirementCard() {
		return activationRequirementCard;
	}

	public void setActivationRequirementCard(List<DevelopmentCard> activationRequirementCard) {
		this.activationRequirementCard = activationRequirementCard;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(Player player) {
		this.activated = true;
		effect.apply(player);
	}

	public void checkActivationLeaderCard(Player player) {
		List<Resource> playerRes = player.getResources();

		if (Resource.isAffordable(playerRes, activationRequirementRes) && DevelopmentCard.isAffordable(player, activationRequirementCard))
			setActivated(player);
			
	}
	
	
	/*it activates the effect when the leader card is activated for the first time
	 * the other times it is activate at the beginning of every period of the age
	*/
	public void applyEffectFirstTime(Player player) {
		if (effect instanceof BonusTurnResourcesEffect)
			((BonusTurnResourcesEffect) effect).applyFirstTime(player);
		
	}

	public String getDescription() {
		return description;
	}
	public String getImage() {
		return image;
	}


}
