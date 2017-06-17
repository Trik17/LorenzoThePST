package it.polimi.ingsw.GC_04.controller;

import java.util.List;

import it.polimi.ingsw.GC_04.Observer;
import it.polimi.ingsw.GC_04.model.Model;
import it.polimi.ingsw.GC_04.model.action.Action;
import it.polimi.ingsw.GC_04.model.action.TakeACard;
import it.polimi.ingsw.GC_04.model.effect.CouncilPrivilege;
import it.polimi.ingsw.GC_04.model.effect.Effect;
import it.polimi.ingsw.GC_04.model.resource.Resource;
import it.polimi.ingsw.GC_04.view.View;

public class Controller implements Observer<Action> {
	private Model model;
	private View view;

	public Controller(Model game, View view) {
		this.model = game;
		view.registerObserver(this);
		
	}

	@Override
	public void update(Action action) {
		if (action instanceof TakeACard){
			if(((TakeACard) action).isCouncilPrivilegePresent()){
				setCouncilPrivilege(action);				
			}				
		}
		if(action.isApplicable())
			action.apply();
		else 
			System.out.println("Non puoi fare questa mossa");
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	private void setCouncilPrivilege(Action action){
		List<Effect> effects=((TakeACard) action).getCard().getEffects();
		for(Effect eff: effects) {
			if (eff.getClass().equals(CouncilPrivilege.class)){
				Resource res=view.askCouncilPrivilege();
				
				
				
			}
		}
	}

}
