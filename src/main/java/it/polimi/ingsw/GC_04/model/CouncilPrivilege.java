package it.polimi.ingsw.GC_04.model;

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
				
	}
	}
	
	private ResourceType choosePrivilege(){
		//cerca interazione con giocatore per decidere rT
		return rT;
	}
	
	
} 
