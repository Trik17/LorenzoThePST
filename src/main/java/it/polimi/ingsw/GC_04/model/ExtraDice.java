package it.polimi.ingsw.GC_04.model;

import it.polimi.ingsw.GC_04.model.Card.BuildingCard;
import it.polimi.ingsw.GC_04.model.Card.CharacterCard;
import it.polimi.ingsw.GC_04.model.Card.DevelopmentCard;
import it.polimi.ingsw.GC_04.model.Card.TerritoryCard;
import it.polimi.ingsw.GC_04.model.Card.VentureCard;

public class ExtraDice {
	private int extraTerritory;
	private int extraBuilding;
	private int extraVenture;
	private int extraCharacter;
	
	
	public int getExtra(DevelopmentCard cardType) {
		if (cardType instanceof TerritoryCard) return extraTerritory;
		if (cardType instanceof BuildingCard) return extraBuilding;
		if (cardType instanceof VentureCard) return extraVenture;
		else return extraCharacter;

	} 
	
	public void setExtra(DevelopmentCard cardType, int extra) {
		if (cardType instanceof TerritoryCard) extraTerritory += extra;
		if (cardType instanceof BuildingCard) extraBuilding += extra;
		if (cardType instanceof VentureCard) extraVenture += extra;
		if (cardType instanceof CharacterCard) extraCharacter += extra;
		
	}
}