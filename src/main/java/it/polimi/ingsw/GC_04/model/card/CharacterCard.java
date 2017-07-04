package it.polimi.ingsw.GC_04.model.card;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import it.polimi.ingsw.GC_04.model.ActionSpace;
import it.polimi.ingsw.GC_04.model.FamilyMember;
import it.polimi.ingsw.GC_04.model.Model;
import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.action.TakeACard;
import it.polimi.ingsw.GC_04.model.effect.Effect;
import it.polimi.ingsw.GC_04.model.resource.Resource;

public class CharacterCard extends DevelopmentCard {
	private static final long serialVersionUID = -4060758132158559318L;

	/**
	 * 
	 */
	private static final long serialVersionUID = 2788993308879115292L;

	public CharacterCard(@JsonProperty("period")int period,@JsonProperty("name") String name, @JsonProperty("image") String image,@JsonProperty("cost1") List<Resource> cost1,@JsonProperty("cost2") List<Resource> cost2,@JsonProperty("effects") List<Effect> effects) {
		super(period, name,image, cost1, cost2, effects);
		// TODO Auto-generated constructor stub
	}
	//constructor needed for Json
		public CharacterCard() {
			// TODO Auto-generated constructor stub
		}

	@Override
	public TakeACard takeCard(Model model, Player player,ActionSpace aSpace, FamilyMember fMember,int servants,List<Resource> cost) {
		return new TakeACard(model, player, this, aSpace, fMember,servants, cost);
		
//		if (check.isApplicable()){check.apply();}
		
	}
		
	

}
