package it.polimi.ingsw.GC_04.view;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

import it.polimi.ingsw.GC_04.Observable;
import it.polimi.ingsw.GC_04.Observer;
import it.polimi.ingsw.GC_04.model.ActionSpace;
import it.polimi.ingsw.GC_04.model.DiceColor;
import it.polimi.ingsw.GC_04.model.FamilyMember;
import it.polimi.ingsw.GC_04.model.Model;
import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.action.Action;
import it.polimi.ingsw.GC_04.model.action.GoToTheCouncilPalace;
import it.polimi.ingsw.GC_04.model.action.GoToTheMarket;
import it.polimi.ingsw.GC_04.model.action.RunHarvest;
import it.polimi.ingsw.GC_04.model.action.RunProduction;
import it.polimi.ingsw.GC_04.model.action.TakeTerritory;
import it.polimi.ingsw.GC_04.model.area.Area;
import it.polimi.ingsw.GC_04.model.area.BuildingTower;
import it.polimi.ingsw.GC_04.model.area.CharacterTower;
import it.polimi.ingsw.GC_04.model.area.CouncilPalaceArea;
import it.polimi.ingsw.GC_04.model.area.MarketArea;
import it.polimi.ingsw.GC_04.model.area.TerritoryTower;
import it.polimi.ingsw.GC_04.model.area.Tower;
import it.polimi.ingsw.GC_04.model.area.VentureTower;
import it.polimi.ingsw.GC_04.model.card.DevelopmentCard;
import it.polimi.ingsw.GC_04.model.effect.Effect;
import it.polimi.ingsw.GC_04.model.resource.*;


public abstract class View extends Observable<Action,Resource> implements Observer<Action, Resource>{
	
	private int turn;
	
	public View() {
		turn = 0;
	}
	
	public abstract void chooseAction();
	public abstract Resource setCouncilPrivilege();
	public abstract int[] setRequestedAuthorizationEffects(List<Effect> effects);
	public abstract int[] setFurtherCheckNeededEffect(Effect effect);
	public abstract Resource setDiscount(Resource rawMaterial);
	
	private void nextPlayer() {//perché è qua???? ATTENZIONE
		int nrOfPlayer = Model.getPlayers().length;
		if (turn < nrOfPlayer)
			turn ++;
		else
			turn = 0;
	}
	
	
	public void input(String tower,String nrOfCard, String diceColor, String nrOfServants, String cost){
		Action action;
		Tower realTower;
		ActionSpace realASpace;
		DevelopmentCard realCard;
		List<Resource> realCost = new ArrayList<Resource>();
		Player player = CouncilPalaceArea.getTurnOrder()[turn];
		
		diceColor = diceColor.toUpperCase();
		
		
		FamilyMember fMember = player.getFamilyMember(DiceColor.fromString(diceColor));
		int card = Integer.parseInt(nrOfCard); 
		int servants = Integer.parseInt(nrOfServants); 
		int chosenCost = Integer.parseInt(cost);
		
		if(tower.equals("1")) {
			realTower = TerritoryTower.instance();
		}
		if(tower.equals("2")) {
			realTower = CharacterTower.instance();
			
		}
		if(tower.equals("3")) {
			realTower = BuildingTower.instance();
		}
		else {
			realTower = VentureTower.instance();
			
		realCard = realTower.getCards()[card];
			
		if (chosenCost == 1)
			realCost = realCard.getCost1();
		if (chosenCost == 2)
			realCost = realCard.getCost2();
		realASpace = realTower.getASpaces().get(card);
		
		action = new TakeTerritory(player,realCard,realASpace,fMember,servants,realCost);
		this.notifyObserversA(action);
		}
		
	}
	
	public void input(String area, String diceColor, String actSpace, String nrOfServants) {
		Player player = CouncilPalaceArea.getTurnOrder()[turn];
		ActionSpace realASpace;
		Area realArea;
		Action action;
		
		FamilyMember fMember = player.getFamilyMember(DiceColor.fromString(diceColor));
		int aSpace = Integer.parseInt(actSpace); 
		int servants = Integer.parseInt(nrOfServants); 
		
		realArea = MarketArea.instance();
		realASpace = realArea.getASpaces().get(aSpace);
		action = new GoToTheMarket(player, fMember, servants, realASpace);
		
		this.notifyObserversA(action);
	
	}
	
	
	
	public void input(String area, String diceColor, String nrOfServants) {
		Player player = CouncilPalaceArea.getTurnOrder()[turn];
		Action action;
		
		
		FamilyMember fMember = player.getFamilyMember(DiceColor.fromString(diceColor));
		int servants = Integer.parseInt(nrOfServants);
		
		if (area.equals("3")) {
			action = new RunProduction(player, fMember, servants);
		}
		
		if (area.equals("4")) {
			action = new RunHarvest(player, fMember, servants);
		}else{
			action = new GoToTheCouncilPalace(player, fMember, servants);
			
			this.notifyObserversA(action);
		}
	}
	
	public Resource input(String privilege) {
		
		Resource resource;
		
		if (privilege.equals("1"))
			resource = new RawMaterial(1);
		if (privilege.equals("2"))
			resource = new Servants(2);
		if (privilege.equals("3"))
			resource = new Coins(2);
		if (privilege.equals("4"))
			resource = new MilitaryPoints(2);
		else
			resource = new FaithPoints(1);
		
		return resource;
			
	}

	
	/*
	public static void main(String[] args) {
		CouncilPrivilege cp=new CouncilPrivilege();
		Resource st=new Stones(1);
		Resource wo=new Woods(1);
		Resource co=new Coins(1);
		Resource co2=new Coins(2);
		Resource mp=new MilitaryPoints(1);
		Resource vp= new VictoryPoints(1);
		List<Resource> resources=new ArrayList<Resource>();
		List<Resource> resources2=new ArrayList<Resource>();
		resources.add(co);
		resources.add(mp);
		resources2.add(co2);
		resources2.add(vp);
		
		ResourceEffect simple=new SimpleResourceEffect(resources);
		ResourceEffect simple2=new SimpleResourceEffect(resources2);
		
		List<Resource> cost1=new ArrayList<Resource>();
		List<ResourceEffect> eff1=new ArrayList<ResourceEffect>();
		List<ResourceEffect> eff2=new ArrayList<ResourceEffect>();
		cost1.add(st);
		cost1.add(wo);
		eff1.add(cp);
		eff1.add(simple);
		eff2.add(simple2);
		ExchangeResourcesEffect ere1=new ExchangeResourcesEffect(eff1,cost1,null,null);
		ExchangeResourcesEffect ere2=new ExchangeResourcesEffect(eff2,cost1,null,null);
		
		List<Effect> ereList=new ArrayList<Effect>();
		List<Effect> ereList2=new ArrayList<Effect>();
		ereList.add(ere1);
		ereList.add(ere2);
		
		ExchangeResourcesEffect ere3=new ExchangeResourcesEffect(eff1,cost1,eff2,cost1);
		ereList.add(ere3);
		DevelopmentCard card=new BuildingCard(2,"miriamTheCraziest",null,cost1,null,ereList,null);
		
		
		Dice dice=new Dice(5);
		Effect take= new TakeACardEffect(null,dice , null);
		Effect take2= new TakeACardEffect(card,dice , cost1);
		
		ereList.add(take);
		ereList2.add(take);
		ereList.add(take2);
		ereList.add(take2);
		ereList.add(take2);
		
		ViewCLI viewCLI=new ViewCLI();
		Model model=new Model();
		Controller controller =new Controller(model);
		controller.organizeRequestedAuthorizationEffects(ereList);
		int[] rrrr = viewCLI.setRequestedAuthorizationEffects(ereList);
		for (int i = 0; i < rrrr.length; i++) {
			System.out.println(rrrr[i]);
		}
	}*/
	
}
