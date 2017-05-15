package it.polimi.ingsw.GC_04;

public abstract class TakeACard extends Action{
	
	//ora questa classe è astratta ed estende Action, aggiunto l'attributo card, metodo isColorAvailable
	

	private DevelopementCard card;
	protected CardType cT;
	
	
	public boolean isTheCostCovered(){ //fallo
		return false;
		
	}
				
	public TakeACard(Player player, DevelopementCard card, ActionSpace aSpace, FamilyMember fMember,int servants){
		this.player = player;
		this.card = card;
		this.aSpace = aSpace;
		this.fMember = fMember;
		
	}
	
	public boolean isPBoardNotFull(){
		final int maxSize = 6;
		int size = 0;

		switch(cT){
		case TERRITORY: size = player.getCards(CardType.TERRITORY).size();
			break;
		case BUILDING: size = player.getCards(CardType.BUILDING).size();
			break;
		case VENTURE: size = player.getCards(CardType.VENTURE).size();
			break;
		case CHARACTER: size = player.getCards(CardType.CHARACTER).size();
			break;
		}
		
		if(size < maxSize) return true;
		return false;
		
	}

	public boolean isColorAvailable(Tower tower,FamilyMember fMember){
		return tower.isColorAvailable(fMember.getFamilyColor());
		
	}
	
	public boolean isApplicable(){
		
		return isPBoardNotFull() &&
				isValueEnough() && 
				isTheCostCovered() && 
				isColorAvailable(player.game.TerritoryTower, fMember.getFamilyColor()) &&
				aSpace.isAvailable();
	}
}	

	
