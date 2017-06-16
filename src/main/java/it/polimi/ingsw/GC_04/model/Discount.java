package it.polimi.ingsw.GC_04.model;

import java.util.ArrayList;
import java.util.List;

import it.polimi.ingsw.GC_04.model.card.BuildingCard;
import it.polimi.ingsw.GC_04.model.card.CharacterCard;
import it.polimi.ingsw.GC_04.model.card.DevelopmentCard;
import it.polimi.ingsw.GC_04.model.card.TerritoryCard;
import it.polimi.ingsw.GC_04.model.card.VentureCard;
import it.polimi.ingsw.GC_04.model.resource.*;

//se c'è raw material il controller deve chiedere quale delle due cose vuole che si scontino
//occhio a non fare andare il costo sotto zero
//in takeACard fai agire il controller prima di tutto
public class Discount {
	private List<Resource> territoryDiscount;
	private List<Resource> buildingDiscount;
	private List<Resource> ventureDiscount;
	private List<Resource> characterDiscount;
	private Resource chosenRawMaterial;
	
	public Discount() {
		territoryDiscount = new ArrayList<Resource>();
		buildingDiscount = new ArrayList<Resource>();
		ventureDiscount = new ArrayList<Resource>();
		characterDiscount = new ArrayList<Resource>();
	}
	
	public List<Resource> getDiscount(DevelopmentCard cardType){
		if (cardType instanceof TerritoryCard)
			return territoryDiscount;
		if (cardType instanceof BuildingCard)
			return buildingDiscount;
		if (cardType instanceof VentureCard)
			return ventureDiscount;
		if (cardType instanceof CharacterCard)
			return characterDiscount;
		return null;
	}
	
	public void setDiscount(DevelopmentCard cardType, List<Resource> discount){
		if (cardType instanceof TerritoryCard)
			Resource.addResource(territoryDiscount, discount);
		if (cardType instanceof BuildingCard)
			Resource.addResource(buildingDiscount, discount);
		if (cardType instanceof VentureCard)
			Resource.addResource(ventureDiscount, discount);
		if (cardType instanceof CharacterCard)
			Resource.addResource(characterDiscount, discount);
		return;
	}

	public Resource getChosenRawMaterial() {
		return chosenRawMaterial;
	}

	public void setChosenRawMaterial(Resource chosenRawMaterial) {
		this.chosenRawMaterial = chosenRawMaterial;
	}
}

