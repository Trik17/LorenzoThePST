package it.polimi.ingsw.GC_04.server.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import it.polimi.ingsw.GC_04.server.model.card.BuildingCard;
import it.polimi.ingsw.GC_04.server.model.card.CharacterCard;
import it.polimi.ingsw.GC_04.server.model.card.DevelopmentCard;
import it.polimi.ingsw.GC_04.server.model.card.TerritoryCard;
import it.polimi.ingsw.GC_04.server.model.card.VentureCard;
import it.polimi.ingsw.GC_04.server.model.resource.*;

//se c'è raw material il controller deve chiedere quale delle due cose vuole che si scontino
//occhio a non fare andare il costo sotto zero
//in takeACard fai agire il controller prima di tutto
public class Discount implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5187252200864714932L;
	private List<Resource> territoryDiscount;
	private List<Resource> buildingDiscount;
	private List<Resource> ventureDiscount;
	private List<Resource> characterDiscount;
	private Resource chosenRawMaterial;
	
	public Discount() {
		territoryDiscount = new ArrayList<>();
		buildingDiscount = new ArrayList<>();
		ventureDiscount = new ArrayList<>();
		characterDiscount = new ArrayList<>();
	}
	
	public List<Resource> getDiscount(DevelopmentCard cardType){
		if (cardType instanceof TerritoryCard)
			return territoryDiscount;
		else if (cardType instanceof BuildingCard)
			return buildingDiscount;
		else if (cardType instanceof VentureCard)
			return ventureDiscount;
		else if (cardType instanceof CharacterCard)
			return characterDiscount;
		return null;
	}
	
	public void setDiscount(DevelopmentCard cardType, List<Resource> discount){
		if (cardType instanceof TerritoryCard)
			Resource.addResource(territoryDiscount, discount);
		else if (cardType instanceof BuildingCard)
			Resource.addResource(buildingDiscount, discount);
		else if (cardType instanceof VentureCard)
			Resource.addResource(ventureDiscount, discount);
		else if (cardType instanceof CharacterCard)
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

