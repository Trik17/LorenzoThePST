package it.polimi.ingsw.GC_04;
import java.util.HashMap;

public class Effect {
	protected HashMap<ResourceType,Resource> effect;
	
	
	public Effect(){
		//inizializzare da file a seconda della carta
		
		
	
	}
	
	public void activateImmediateE(HashMap<ResourceType,Resource> effect,Player player){
		player.modifyResource(effect);
	}
}
