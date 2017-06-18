package it.polimi.ingsw.GC_04.controller;

import java.util.ArrayList;
import java.util.List;

import it.polimi.ingsw.GC_04.Observer;
import it.polimi.ingsw.GC_04.model.Model;
import it.polimi.ingsw.GC_04.model.action.Action;
import it.polimi.ingsw.GC_04.model.effect.Effect;
import it.polimi.ingsw.GC_04.model.effect.ExchangeResourcesEffect;
import it.polimi.ingsw.GC_04.model.resource.*;
import it.polimi.ingsw.GC_04.view.View;

public class Controller implements Observer<Action,Resource> {
	private Model model;
	private View[] views;
	private static int turn = 0;

	public Controller(Model model) {
		this.model = model;		
	}
	
	public void setViews(View[] views){
		this.views = views;
		for(View view : views)
			view.registerObserver(this);
	}
	
	public void startGame(){
		views[turn].chooseAction();
	}

	@Override
	public void updateAction(Action action) {
		
		action.checkExtraordinaryEffect();
		Resource privilege;
		while(!action.getCouncilPrivileges().isEmpty()) {
			privilege = views[turn].setCouncilPrivilege();
			action.setCouncilPrivilege(privilege);
		}
		List<Effect> requestedAuthorizationEffects = action.getRequestedAuthorizationEffects();
		requestedAuthorizationEffects = organizeRequestedAuthorizationEffects(requestedAuthorizationEffects);
		views[turn].setRequestedAuthorizationEffects(requestedAuthorizationEffects);
		
		
								
//		if(action.isApplicable())
//			requestedAuthorizationEffects = action.apply(); //continuare da qui
//		else 
//			System.out.println("Non puoi fare questa mossa");
		
	}
	
	public List<Effect> organizeRequestedAuthorizationEffects(List<Effect> requestedAuthorizationEffects) {
		List<Effect> rAE =  new ArrayList<Effect>();
		for (Effect eff:requestedAuthorizationEffects) {
			if (eff instanceof ExchangeResourcesEffect)
				if (((ExchangeResourcesEffect) eff).getCost2() == null) {
					((ExchangeResourcesEffect) eff).setEffect(((ExchangeResourcesEffect) eff).getEffect1(), ((ExchangeResourcesEffect) eff).getCost1());
				}else { 
					rAE.add(eff);
					requestedAuthorizationEffects.remove(eff);
				}
			
		}
		requestedAuthorizationEffects.addAll(rAE);
		return requestedAuthorizationEffects;
		
	}

	
	
	

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	/*
	private void setCouncilPrivilege(Action action){
		List<Effect> effects=((TakeACard) action).getCard().getEffects();
		List<Resource> privilege= new ArrayList<Resource>();
		for(Effect eff: effects) {
			if (eff.getClass().equals(CouncilPrivilege.class)){ //eff is a CouncilPriviege
				Resource res=views.askCouncilPrivilege();
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
	}*/

	@Override
	public void updateResource(Resource resource) {
		// TODO Auto-generated method stub
		
	}
}
