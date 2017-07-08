package it.polimi.ingsw.GC_04.server.model.card;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import it.polimi.ingsw.GC_04.server.model.ActionSpace;
import it.polimi.ingsw.GC_04.server.model.FamilyMember;
import it.polimi.ingsw.GC_04.server.model.Model;
import it.polimi.ingsw.GC_04.server.model.Player;
import it.polimi.ingsw.GC_04.server.model.action.TakeACard;
import it.polimi.ingsw.GC_04.server.model.effect.Effect;
import it.polimi.ingsw.GC_04.server.model.resource.Resource;

public class CharacterCard extends DevelopmentCard {
	private static final long serialVersionUID = -4060758132158559318L;

	public CharacterCard(@JsonProperty("period")int period,@JsonProperty("name") String name, @JsonProperty("image") String image,@JsonProperty("imageResized") String imageResized,@JsonProperty("cost1") List<Resource> cost1,@JsonProperty("cost2") List<Resource> cost2,@JsonProperty("effects") List<Effect> effects) {
		super(period, name,image,imageResized, cost1, cost2, effects);
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
