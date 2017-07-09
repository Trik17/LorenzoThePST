package it.polimi.ingsw.GC_04.server.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonalBonusTile {//manca il codice per mischiarle e darle ai player
	private Production production;
	private Harvest harvest;
	
	@JsonCreator	
	public PersonalBonusTile(@JsonProperty("production") Production production,@JsonProperty("harvest") Harvest harvest) {
		this.production=production;
		this.harvest=harvest;
	}
	public Production getProduction() {
		return production;
	}
	public Harvest getHarvest() {
		return harvest;
	}

}
