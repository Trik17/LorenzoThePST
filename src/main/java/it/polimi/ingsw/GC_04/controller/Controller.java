package it.polimi.ingsw.GC_04.controller;

import java.util.ArrayList;
import java.util.List;


import it.polimi.ingsw.GC_04.Observer;
import it.polimi.ingsw.GC_04.model.Model;
import it.polimi.ingsw.GC_04.model.action.Action;
import it.polimi.ingsw.GC_04.model.action.TakeACard;
import it.polimi.ingsw.GC_04.model.effect.CouncilPrivilege;
import it.polimi.ingsw.GC_04.model.effect.Effect;
import it.polimi.ingsw.GC_04.model.resource.*;
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
		List<Resource> privilege= new ArrayList<Resource>();
		for(Effect eff: effects) {
			if (eff.getClass().equals(CouncilPrivilege.class)){ //eff is a CouncilPriviege
				Resource res=view.askCouncilPrivilege();
				if (res.getClass().equals(RawMaterial.class)){
					privilege.add(new Woods(1));
					privilege.add(new Stones(1));
				}else{
					if(eff.getClass().equals(FaithPoints.class))
						res.addQuantity(1);
					else
						res.addQuantity(2);
					privilege.add(res);
				}					
				
				((CouncilPrivilege) eff).setCouncilPrivilege(privilege);
								
			}
		}
	}
}
