package it.polimi.ingsw.GC_04;

public abstract class TakeACard extends Action{
	
	//ora questa classe è astratta ed estende Action, aggiunto l'attributo card, metodo isColorAvailable
	

	private DevelopementCard card;
	
	
	public TakeACard(Player player, DevelopementCard card, ActionSpace aSpace, FamilyMember fMember,int servants){
		this.player = player;
		this.card = card;
		this.aSpace = aSpace;
		this.fMember = fMember;
		
	}
	
	public boolean isPBoardNotFull(){
		if 
	}

	public boolean isColorAvailable(Tower tower,FamilyMember fMember){
		return tower.isColorAvailable(fMember.getFamilyColor());
		
	}
	
}	

	
