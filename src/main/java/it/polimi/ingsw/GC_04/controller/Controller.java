package it.polimi.ingsw.GC_04.controller;

import java.util.ArrayList;
import java.util.List;

import com.sun.javafx.geom.Area;

import it.polimi.ingsw.GC_04.Observer;
import it.polimi.ingsw.GC_04.model.ActionSpace;
import it.polimi.ingsw.GC_04.model.Model;
import it.polimi.ingsw.GC_04.model.action.Action;
import it.polimi.ingsw.GC_04.model.area.BuildingTower;
import it.polimi.ingsw.GC_04.model.area.CharacterTower;
import it.polimi.ingsw.GC_04.model.area.TerritoryTower;
import it.polimi.ingsw.GC_04.model.area.Tower;
import it.polimi.ingsw.GC_04.model.area.VentureTower;
import it.polimi.ingsw.GC_04.model.card.DevelopmentCard;
import it.polimi.ingsw.GC_04.model.effect.Effect;
import it.polimi.ingsw.GC_04.model.effect.ExchangeResourcesEffect;
import it.polimi.ingsw.GC_04.model.effect.TakeACardEffect;
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
		int[] furtherCheckNeeded = new int[requestedAuthorizationEffects.size()-1];
		int cont = 0;
		for (int i = 0; i < requestedAuthorizationEffects.size(); i++) {
			if (requestedAuthorizationEffects.get(i) instanceof ExchangeResourcesEffect)
				if (!(((ExchangeResourcesEffect) requestedAuthorizationEffects.get(i)).getCost2() == null)) {
					furtherCheckNeeded[cont] = i;
					cont ++;
				}
		}
		for (int i = 0; i < requestedAuthorizationEffects.size(); i++) {
			if (requestedAuthorizationEffects.get(i) instanceof TakeACardEffect) {
				furtherCheckNeeded[cont] = i;
				cont ++;
				}
		}
		
		requestedAuthorizationEffects = organizeRequestedAuthorizationEffects(requestedAuthorizationEffects);
		int[] requestedEffects = views[turn].setRequestedAuthorizationEffects(requestedAuthorizationEffects);
		
		for (int i:furtherCheckNeeded) {
			for (int j: requestedEffects) {
				if (furtherCheckNeeded[i] == requestedEffects[j]) {
					Effect effect = requestedAuthorizationEffects.get(requestedEffects[j]);
					int[] choice = views[turn].setFurtherCheckNeededEffect(effect);
					if (effect instanceof ExchangeResourcesEffect) {
						if (choice[0] == 1)
							((ExchangeResourcesEffect) effect).setEffect(((ExchangeResourcesEffect) effect).getEffect1(), ((ExchangeResourcesEffect) effect).getCost1());
						else
							((ExchangeResourcesEffect) effect).setEffect(((ExchangeResourcesEffect) effect).getEffect2(), ((ExchangeResourcesEffect) effect).getCost2());		
					}
					else if (effect instanceof TakeACardEffect) {
						Tower tower;
						if (choice.length == 4) {
							
							switch (choice[0]) {
							case 1:
								tower = TerritoryTower.instance();
								break;
							case 2:
								tower = CharacterTower.instance();
								break;
							case 3:
								tower = BuildingTower.instance();
								break;
							default:
								tower = VentureTower.instance();
								break;
							}
						}else {
							tower = ((TakeACardEffect) effect).getCardType().getTower();
						}
						DevelopmentCard card = tower.getCards()[choice[1] -1];
						ActionSpace aSpace = tower.getASpaces().get(choice[1] -1);
						int servants = choice[2];
						List<Resource> cost = new ArrayList<Resource>();
						if (choice[3] == 1)
							cost = tower.getCards()[choice[1] -1].getCost1();
						else
							cost = tower.getCards()[choice[1] -1].getCost2();;
						((TakeACardEffect) action.getRequestedAuthorizationEffects().get(j)).setParameters(action.getPlayer(),card,aSpace,servants,cost);
					}
					//TODO: ora devi impostare i parametri di takeAcard e exchange bla bla
				}
			}
		}
							
		if(action.isApplicable())
			action.apply(); //continuare da qui
		else 
			System.out.println("Non puoi fare questa mossa");
		
	}
	
	public List<Effect> organizeRequestedAuthorizationEffects(List<Effect> requestedAuthorizationEffects) {
		
		for (Effect eff:requestedAuthorizationEffects) {
			if (eff instanceof ExchangeResourcesEffect)
				if (((ExchangeResourcesEffect) eff).getCost2() == null) {
					((ExchangeResourcesEffect) eff).setEffect(((ExchangeResourcesEffect) eff).getEffect1(), ((ExchangeResourcesEffect) eff).getCost1());
				}
		}
		return requestedAuthorizationEffects;
		
	}

	public void setFurtherCheckNeededEffect(List<Effect> effects,int index) {
		if (effects.get(index) instanceof ExchangeResourcesEffect) {
			
		}
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
