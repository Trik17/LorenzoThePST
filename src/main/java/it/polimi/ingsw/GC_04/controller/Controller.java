package it.polimi.ingsw.GC_04.controller;

import it.polimi.ingsw.GC_04.Observer;
import it.polimi.ingsw.GC_04.model.Game;
import it.polimi.ingsw.GC_04.model.action.Action;
import it.polimi.ingsw.GC_04.viewCLI.ViewCLI;

public class Controller implements Observer<Action> {
	private Game game;

	public Controller(Game game, ViewCLI view) {
		this.game = game;
		view.registerObserver(this);
		
	}

	@Override
	public void update(Action action) {
		if(action.isApplicable())
			action.apply();
		else 
			System.out.println("Non puoi fare questa mossa");
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
