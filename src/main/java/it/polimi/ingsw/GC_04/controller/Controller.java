package it.polimi.ingsw.GC_04.controller;

import it.polimi.ingsw.GC_04.Observer;
import it.polimi.ingsw.GC_04.model.Model;
import it.polimi.ingsw.GC_04.model.action.Action;
import it.polimi.ingsw.GC_04.view.View;

public class Controller implements Observer<Action> {
	private Model model;

	public Controller(Model game, View view) {
		this.model = game;
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
