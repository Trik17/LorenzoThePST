package it.polimi.ingsw.GC_04.client.rmi;

import java.util.List;
import java.rmi.RemoteException;
import java.util.ArrayList;

import it.polimi.ingsw.GC_04.Observable;
import it.polimi.ingsw.GC_04.Observer;
import it.polimi.ingsw.GC_04.controller.SupportFunctions;
import it.polimi.ingsw.GC_04.model.ActionSpace;
import it.polimi.ingsw.GC_04.model.DiceColor;
import it.polimi.ingsw.GC_04.model.FamilyMember;
import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.action.Action;
import it.polimi.ingsw.GC_04.model.action.GoToTheCouncilPalace;
import it.polimi.ingsw.GC_04.model.action.GoToTheMarket;
import it.polimi.ingsw.GC_04.model.action.RunHarvest;
import it.polimi.ingsw.GC_04.model.action.RunProduction;
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
import it.polimi.ingsw.GC_04.view.ServerRMIViewRemote;


public abstract class ViewClient {
	private ServerRMIViewRemote serverStub;
	private int turn;
	
	public ViewClient() {
		turn = 0;
	}
	
	public void addServerstub(ServerRMIViewRemote serverStub){
		this.serverStub=serverStub;
		
	}
	
	public abstract void chooseAction();
	public abstract Resource setCouncilPrivilege();
	public abstract int[] setRequestedAuthorizationEffects(List<Effect> effects);
	public abstract int[] setFurtherCheckNeededEffect(Effect effect);
	public abstract Resource setDiscount(Resource rawMaterial);
	
	public void input(String tower,String nrOfCard, String diceColor, String nrOfServants, String cost){
		Action action;
		Tower realTower;
		ActionSpace realASpace;
		DevelopmentCard realCard;
		List<Resource> realCost = new ArrayList<>();
		Player player = CouncilPalaceArea.getTurnOrder()[turn];
		
		FamilyMember fMember = player.getFamilyMember(DiceColor.fromString(diceColor));
	
		int card = Integer.parseInt(nrOfCard)-1; 
		int servants = Integer.parseInt(nrOfServants); 
		
		if("1".equals(tower)) {
			realTower = TerritoryTower.instance();
		}
		else if("2".equals(tower)) {
			realTower = CharacterTower.instance();
		}
		else if("3".equals(tower)) {
			realTower = BuildingTower.instance();
		}
		else 
			realTower = VentureTower.instance();
			
		realCard = realTower.getCards()[card];
		
		if (realCard.getCost1() == null && realCard.getCost2() == null)
			realCost = null;
		else if (realCard.getCost2() == null)
			realCost = realCard.getCost1();
		else {
			if (!SupportFunctions.isInputValid(cost, 1, 2)) {
				chooseAction();
				return;
			}
			else{
				int chosenCost = Integer.parseInt(cost);
			
				if (chosenCost == 1)
					realCost = realCard.getCost1();
				if (chosenCost == 2)
					realCost = realCard.getCost2();
			}
		}
		realASpace = realTower.getASpaces().get(card);
		
		action = realCard.takeCard(player, realASpace, fMember, servants, realCost);
		
		try {
			serverStub.notifyObserversA(action);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void input(String area, String diceColor, String actSpace, String nrOfServants) {
		Player player = CouncilPalaceArea.getTurnOrder()[turn];
		ActionSpace realASpace;
		Area realArea;
		Action action;
		
		FamilyMember fMember = player.getFamilyMember(DiceColor.fromString(diceColor));
		int aSpace = Integer.parseInt(actSpace)-1; 
		int servants = Integer.parseInt(nrOfServants); 
		
		realArea = MarketArea.instance();
		realASpace = realArea.getASpaces().get(aSpace);
		action = new GoToTheMarket(player, fMember, servants, realASpace);
		try {
			this.serverStub.notifyObserversA(action);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
	
	public void input(String area, String diceColor, String nrOfServants) {
		Player player = CouncilPalaceArea.getTurnOrder()[turn];
		Action action;
		
		
		FamilyMember fMember = player.getFamilyMember(DiceColor.fromString(diceColor));
		int servants = Integer.parseInt(nrOfServants);
		
		if ("3".equals(area)) 
			action = new RunProduction(player, fMember, servants);
		else if ("4".equals(area))
			action = new RunHarvest(player, fMember, servants);
		else
			action = new GoToTheCouncilPalace(player, fMember, servants);
			
		try {
			this.serverStub.notifyObserversA(action);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public Resource input(String privilege) {
		
		Resource resource;
		
		if ("1".equals(privilege))
			resource = new RawMaterial(1);
		else if ("2".equals(privilege))
			resource = new Servants(2);
		else if ("3".equals(privilege))
			resource = new Coins(2);
		else if ("4".equals(privilege))
			resource = new MilitaryPoints(2);
		else
			resource = new FaithPoints(1);
		
		return resource;
			
	}
	
}
