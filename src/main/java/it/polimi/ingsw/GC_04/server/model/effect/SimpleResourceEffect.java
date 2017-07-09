package it.polimi.ingsw.GC_04.server.model.effect;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.polimi.ingsw.GC_04.server.model.resource.Resource;

public class SimpleResourceEffect extends ResourceEffect {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6530815085475015190L;

	@JsonCreator
	public SimpleResourceEffect(@JsonProperty("effect") List<Resource> effect) {
		this.effect = effect;
	}

}
