package it.polimi.ingsw.GC_04.view;

import java.util.List;

import it.polimi.ingsw.GC_04.Observable;
import it.polimi.ingsw.GC_04.Observer;
import it.polimi.ingsw.GC_04.client.rmi.ClientViewRemote;
import it.polimi.ingsw.GC_04.model.action.Action;
import it.polimi.ingsw.GC_04.model.effect.Effect;
import it.polimi.ingsw.GC_04.model.resource.Resource;

public class ViewHandler extends Observable<Action, Resource> implements Observer<Action,Resource>{
	private String username;
	private ClientViewRemote client;
	private boolean gui=false; //settarlo da quanlche parte se sceglie gui
	
	public ViewHandler(String username, ClientViewRemote client) {
		this.username=username;
		this.client=client;
	}
	
	public String getUsername(){
		return this.username;
	}
	
	public boolean isGUI(){
		return this.gui;
	}
	
	public ClientViewRemote getView(){
		return this.client;
	}

	@Override
	public void update(Action action) {
		// TODO Auto-generated method stub
		
	}

	public void chooseAction() {
		// TODO Auto-generated method stub
		
	}

	public int[] setFurtherCheckNeededEffect(Effect effect) {
		// TODO Auto-generated method stub
		return null;
	}

	public Resource setCouncilPrivilege() {
		// TODO Auto-generated method stub
		return null;
	}

	public int[] setRequestedAuthorizationEffects(List<Effect> requestedAuthorizationEffects) {
		// TODO Auto-generated method stub
		return null;
	}

	public Resource setDiscount(Resource res) {
		// TODO Auto-generated method stub
		return null;
	}
}
