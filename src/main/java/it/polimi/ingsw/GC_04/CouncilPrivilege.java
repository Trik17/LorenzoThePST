package it.polimi.ingsw.GC_04;

public class CouncilPrivilege extends Effect{
	
	public CouncilPrivilege(ResourceType rT){
		
		switch (rT){
		case WOOD:    //to take a stone and a wood: the constructor takes WOOD or STONE indifferently
		case STONE:
			effect.put(rT, new Woods(1));
			effect.put(rT, new Stones(1));
			break;
		case SERVANT:
			effect.put(rT, new Servants(2));
			break;
		case COIN:
			effect.put(rT, new Coins(2));
			break;
		case MILITARYP:
			effect.put(rT, new MilitaryPoints(2));
			break;
		case FAITHP:
			effect.put(rT, new FaithPoints(1));
			break;
		}
				
	}
	
	
}
