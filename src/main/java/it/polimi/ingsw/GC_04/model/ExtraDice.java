package it.polimi.ingsw.GC_04.model;

import it.polimi.ingsw.GC_04.model.card.BuildingCard;
import it.polimi.ingsw.GC_04.model.card.CharacterCard;
import it.polimi.ingsw.GC_04.model.card.DevelopmentCard;
import it.polimi.ingsw.GC_04.model.card.TerritoryCard;
import it.polimi.ingsw.GC_04.model.card.VentureCard;

public class ExtraDice {
	private int extraTerritory;
	private int extraBuilding;
	private int extraVenture;
	private int extraCharacter;
	private int extraPrduction;
	private int extraHarvest;
	
	
	
	public int getCardExtra(DevelopmentCard cardType) {
		if (cardType instanceof TerritoryCard) return extraTerritory;
		if (cardType instanceof BuildingCard) return extraBuilding;
		if (cardType instanceof VentureCard) return extraVenture;
		else return extraCharacter;

	} 
	
	public int getProductionExtra() {
		return extraPrduction;
	}
	public int getHarvestExtra() {
		return extraHarvest;
	}
	
	public void setProductionExtra(int extra) {
		extraPrduction += extra;
	}
	
	public void setHarvestExtra(int extra) {
		extraHarvest += extra;
	}
	
	
	
	public void setCardExtra(DevelopmentCard cardType, int extra) {
		if (cardType instanceof TerritoryCard) extraTerritory += extra;
		if (cardType instanceof BuildingCard) extraBuilding += extra;
		if (cardType instanceof VentureCard) extraVenture += extra;
		if (cardType instanceof CharacterCard) extraCharacter += extra;
		
	}
}