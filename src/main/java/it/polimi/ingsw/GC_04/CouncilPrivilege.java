package it.polimi.ingsw.GC_04;
import java.util.HashMap;
import java.util.Map;

public class CouncilPrivilege {
	
	public CouncilPrivilege(){
				
		}
		
	public void takeCP(ResourceType rT, HashMap<ResourceType,Resource> effect){
	
		switch (rT){
		case WOOD:    //to take a stone and a wood: the constructor takes WOOD or STONE indifferently
		case STONE:
			effect.get(ResourceType.WOOD).modifyQuantity(1);			
			effect.get(ResourceType.STONE).modifyQuantity(1);			
			break;
		case SERVANT:
			effect.get(ResourceType.SERVANT).modifyQuantity(2);
			break;
		case COIN:
			effect.get(ResourceType.COIN).modifyQuantity(2);
			break;
		case MILITARYP:
			effect.get(ResourceType.MILITARYP).modifyQuantity(2);
			break;
		case FAITHP:
			effect.get(ResourceType.FAITHP).modifyQuantity(1);
			break;
				
	}
	}
	
	
} 
