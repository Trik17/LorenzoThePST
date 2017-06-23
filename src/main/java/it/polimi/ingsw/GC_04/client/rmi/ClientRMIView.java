package it.polimi.ingsw.GC_04.client.rmi;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.sun.corba.se.spi.activation.Server;

import it.polimi.ingsw.GC_04.model.Dice;
import it.polimi.ingsw.GC_04.model.FamilyMember;
import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.action.Action;
import it.polimi.ingsw.GC_04.model.action.GoToTheCouncilPalace;
import it.polimi.ingsw.GC_04.model.action.TakeACard;
import it.polimi.ingsw.GC_04.model.resource.Coins;
import it.polimi.ingsw.GC_04.model.resource.Resource;
import it.polimi.ingsw.GC_04.view.ServerRMIViewRemote;
//implements ClientViewRemote interface
public class ClientRMIView extends UnicastRemoteObject implements ClientViewRemote, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9164262648865618843L;
	private final String username; 
	private ViewClient view;
	private ServerRMIViewRemote serverStub;
//mi manca qua il serverstub!!
	
	
	protected ClientRMIView(String username) throws RemoteException {
		super();
		this.username=username;
		this.view=new ViewCLI();
	}
	public void addServerstub(ServerRMIViewRemote serverStub)throws RemoteException{
		this.serverStub=serverStub;
	}
	@Override
	public void askSomething(String a) throws RemoteException{
		System.out.println("0000");
		if (a.equalsIgnoreCase("ciao"))
			System.out.println("mi hai salutato");
		else
			System.out.println("chi sa che cosa hai scritto");
		//la view non ha il Player!! devo darglielo per facilitare le cose
		System.out.println("proviamo a fare la notify al controller che osserva rmiView:");
		try{
//			FamilyMember fm=new FamilyMember(new Dice(1));
//			Action action=new GoToTheCouncilPalace(new Player("and", 3), fm, 1);
			Resource c=new Coins(3);
			System.out.println("provo acion");
			serverStub.notifyObserversRremote(c);
			
		}catch (Exception e){
			e.printStackTrace();
		}
		
		
		
	}
	@Override
	public String getUsername() throws RemoteException {
		return this.username;		
	}
	
	

}