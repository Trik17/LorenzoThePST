package it.polimi.ingsw.GC_04;

public class TakeTerritory implements Action {
	private int extraDice;
	
	public boolean tTerritory(FamilyMember fMember, ActionSpace aSpace){
		if(pBoard.requestedMilitaryPoints <= discM.position){
			pBoard.territory.add(card);
			//TODO: si prende gli effetti immediati
			if(pBoard.territory.size() >= 2)
				pBoard.requestedMilitaryPoints += pBoard.territory.size() + 1;
		}else{
			System.out.println("Non puoi prendere la carta");
			return false;
		}
		
		
		
	}

}
