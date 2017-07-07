package it.polimi.ingsw.GC_04.server.model.card;

import java.util.List;

import it.polimi.ingsw.GC_04.server.model.effect.Effect;
import it.polimi.ingsw.GC_04.server.model.resource.Resource;

public class LeaderCard extends Card {
	private String name;
	private Resource activationRequirementRes;
	private List<DevelopmentCard> activationRequirementCard;
	private Effect effect;
	private String image;
	
	public LeaderCard(String name, Resource activationRequirementRes,List<DevelopmentCard> activationRequirementCard,Effect effect,String image) {
		this.name = name;
		this.activationRequirementRes = activationRequirementRes;
		this.activationRequirementCard = activationRequirementCard;
		this.effect = effect;
		this.image = image;
	}

	public Resource getActivationRequirementRes() {
		return activationRequirementRes;
	}

	public void setActivationRequirementRes(Resource activationRequirementRes) {
		this.activationRequirementRes = activationRequirementRes;
	}

	public List<DevelopmentCard> getActivationRequirementCard() {
		return activationRequirementCard;
	}

	public void setActivationRequirementCard(List<DevelopmentCard> activationRequirementCard) {
		this.activationRequirementCard = activationRequirementCard;
	}

}
