package it.polimi.ingsw.GC_04.client.view.gui;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
/*
 * json:
 * 
 * ObjectMapper mapper = new ObjectMapper();           
	mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
 * 
 * String s = mapper.writeValueAsString(stateOfTheGame);
 * 
 * StateOfTheGame stateOfTheGame=mapper.readValue(s, StateOfTheGame.class);
 */
public class StateOfTheGame {
	
	private String stateCLI;
	private StateOfTheGameGUI stateGUI;

	@JsonCreator
	public StateOfTheGame() {
	}

	public String getStateCLI() {
		return stateCLI;
	}

	public void setStateCLI(String stateCLI) {
		this.stateCLI = stateCLI;
	}

	public StateOfTheGameGUI getStateGUI() {
		return stateGUI;
	}

	public void setStateGUI(StateOfTheGameGUI stateGUI) {
		this.stateGUI = stateGUI;
	}

}
