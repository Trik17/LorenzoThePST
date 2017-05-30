package it.polimi.ingsw.GC_04.controller;

import java.util.ArrayList;

import it.polimi.ingsw.GC_04.model.Game;
import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.card.BuildingCard;
import it.polimi.ingsw.GC_04.model.card.CharacterCard;
import it.polimi.ingsw.GC_04.model.card.TerritoryCard;
import it.polimi.ingsw.GC_04.model.card.VentureCard;

public class Inizializer {
	
	private final ArrayList<TerritoryCard> tCards;
	private final ArrayList<BuildingCard> bCards;
	private final ArrayList<CharacterCard> cCards;
	private final ArrayList<VentureCard> vCards;

	
	public Inizializer() {
		tCards = new ArrayList<TerritoryCard>();
		bCards = new ArrayList<BuildingCard>();
		cCards = new ArrayList<CharacterCard>();
		vCards = new ArrayList<VentureCard>();
		// TODO: far prendere gli array da file
		
		//Game game = new Game(Player);
	}
}
