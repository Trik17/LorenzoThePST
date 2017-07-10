package it.polimi.ingsw.GC_04.client.view.gui;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StateOfTheGame implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5822094209304225603L;
	private String stateCLI;
	private StateOfTheGameGUI stateGUI;

	
	public StateOfTheGame() {
	}
	@JsonCreator
	public StateOfTheGame(@JsonProperty("stateCLI") String stateCLI, @JsonProperty("stateGUI") StateOfTheGameGUI stateGUI) {
		this.stateCLI=stateCLI;
		this.stateGUI=stateGUI;
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
