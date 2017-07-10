package it.polimi.ingsw.GC_04.client.view.gui;

import java.io.IOException;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import it.polimi.ingsw.GC_04.server.model.Model;
/* 
 ObjectMapper mapper = new ObjectMapper();           
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		
		StateOfTheGame stateOfTheGame=new StateOfTheGame();
		stateOfTheGame.setStateCLI("prova stringa cli");
		StateOfTheGameGUI stateGUI=new StateOfTheGameGUI(this.model, player);
		stateOfTheGame.setStateGUI(stateGUI);
		
		String s;
		try {
			s = mapper.writeValueAsString(stateOfTheGame);
			System.out.println(s);

			StateOfTheGame stateOfTheGame2=mapper.readValue(s, StateOfTheGame.class);
			System.out.println(stateOfTheGame2.getStateCLI());
		} catch (IOException e) {
			e.printStackTrace();
		} 
 */
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
