package it.polimi.ingsw.GC_04;
import java.util.ArrayList;
import java.util.HashMap;
  
  
public class Effect {
	protected HashMap<ResourceType,Resource> effect; //non abbiamo fatto la new
	private int endVictoryP; //only for venture's card in the original game
	private ResourceType rT;
	private ArrayList<CouncilPrivilege> cP;
	
	
	public Effect(Card c){
		//inizializzare la mappa da file a seconda della carta
		
		
	// per ogni privilegio del consiglio ne crea uno e lo aggiunge alla lista
	}
	
	public void apply(HashMap<ResourceType,Resource> effect,Player player){
		addEndVictoryP(player);
		for(CouncilPrivilege c: cP) 	c.takeCP(rT, effect);
		player.modifyResource(effect);
		//manca azione/ harvest/production
	}
	
	
	private void addEndVictoryP(Player player){
		((VictoryPoints) player.getResources().get(ResourceType.VICTORYP)).addEndPoints(endVictoryP);
	}
	
	
	
} 
