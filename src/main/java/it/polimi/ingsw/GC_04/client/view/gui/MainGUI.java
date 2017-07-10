package it.polimi.ingsw.GC_04.client.view.gui;

import java.io.IOException;

import it.polimi.ingsw.GC_04.server.controller.Initializer;
import it.polimi.ingsw.GC_04.server.model.Model;
import it.polimi.ingsw.GC_04.server.model.Player;

public class MainGUI {

	public static void main(String[] args) {
		Model model = new Model();
		Player player1 = new Player("mi", 1);
		Player player2 = new Player("lu", 2);
		Player[] players = new Player[2];
		players[0] = player1;
		players[1] = player2;
		
		model.setPlayers(players);
		
		Initializer initializer = new Initializer(players, model);
		StateOfTheGame state = new StateOfTheGame();
		
		StateOfTheGameGUI stateOfTheGameGUI = new StateOfTheGameGUI(model,player1.getName());
		state.setStateGUI(stateOfTheGameGUI);
		try {
			GameBoardGUI gameBoardGUI = new GameBoardGUI();
			gameBoardGUI.setState(state);
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
		
	}
}
