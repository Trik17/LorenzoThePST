package it.polimi.ingsw.GC_04.model.effect;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.polimi.ingsw.GC_04.model.resource.Resource;

public class SimpleResourceEffect extends ResourceEffect {

	@JsonCreator
	public SimpleResourceEffect(@JsonProperty("effect") List<Resource> effect) {
		this.effect = effect;
	}

}
