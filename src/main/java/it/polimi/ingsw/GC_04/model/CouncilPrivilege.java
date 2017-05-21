package it.polimi.ingsw.GC_04.model;

import java.util.ArrayList;
import java.util.HashMap;

public class CouncilPrivilege extends Effect {
	private ResourceType rT;
	
	public CouncilPrivilege(){
						
		}
	@Override
	public void apply(Player player){
		
		rT=choosePrivilege();
		
		switch (rT){
		case WOOD:    //to take a stone and a wood: the constructor takes WOOD or STONE indifferently
		case STONE:
			ArrayList<Resource> pRes=player.getResources();
			pRes.forEach(r ->{if(r instanceof Woods)	r.modifyQuantity(2);	});
			
			
			player.getResources().get(ResourceType.WOOD).modifyQuantity(1);			
			player.getResources().get(ResourceType.STONE).modifyQuantity(1);			
			break;
		case SERVANT:
			player.getResources().get(ResourceType.SERVANT).modifyQuantity(2);
			break;
		case COIN:
			player.getResources().get(ResourceType.COIN).modifyQuantity(2);
			break;
		case MILITARYP:
			player.getResources().get(ResourceType.MILITARYP).modifyQuantity(2);
			break;
		case FAITHP:
			player.getResources().get(ResourceType.FAITHP).modifyQuantity(1);
			break;
			/*public ArrayList<DevelopementCard> getCards(DevelopementCard dC){
			if (dC instanceof TerritoryCard) return tCards;
			if (dC instanceof BuildingCard) return bCards;
			if (dC instanceof VentureCard) return vCards;
			if (dC instanceof CharacterCard) return cCards;
			else return null;*/
		}
				
	}
	}
	
	private ResourceType choosePrivilege(){
		//cerca interazione con giocatore per decidere rT
		return rT;
	}
	
	
} 
