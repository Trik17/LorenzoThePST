package it.polimi.ingsw.GC_04.client.rmi;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import it.polimi.ingsw.GC_04.client.ViewCLI;
import it.polimi.ingsw.GC_04.controller.StateOfTheGameCLI;
import it.polimi.ingsw.GC_04.model.Dice;
import it.polimi.ingsw.GC_04.model.Model;
import it.polimi.ingsw.GC_04.model.card.DevelopmentCard;
import it.polimi.ingsw.GC_04.model.card.ExcommunicationTile;
import it.polimi.ingsw.GC_04.model.effect.Effect;
import it.polimi.ingsw.GC_04.model.resource.Coins;
import it.polimi.ingsw.GC_04.model.resource.Resource;
import it.polimi.ingsw.GC_04.view.ServerRMIViewRemote;
//implements ClientViewRemote interface
public class ClientRMIView extends UnicastRemoteObject implements ClientRMIViewRemote, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9164262648865618843L;
	private final String username; 
	private ViewCLI view;
	private ServerRMIViewRemote serverStub;
	private ExecutorService executor;
//mi manca qua il serverstub!!
	
	
	protected ClientRMIView(String username) throws RemoteException {
		super();
		this.username=username;
		this.view=new ViewCLI();
		this.executor = Executors.newCachedThreadPool();
	}
	public void addServerstub(ServerRMIViewRemote serverStub)throws RemoteException{
		this.serverStub=serverStub;
		this.view.addServerstub(serverStub);
	}
	@Override//da cancellare
	public void askSomething(String a) throws RemoteException{
		System.out.println("0000");
		/*Scanner in = new Scanner(System.in);
		in.nextLine();
		in.close();*/
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
//			serverStub.notifyObserversRremote(c);
			
		}catch (Exception e){
			e.printStackTrace();
		}
		
		
		
	}
	@Override
	public String getUsername() throws RemoteException {
		return this.username;		
	}
	@Override
	public void chooseAction() throws RemoteException{
		executor.submit(view);
		return;		
	}
	@Override
	public int[] setFurtherCheckNeededEffect(Effect effect) throws RemoteException{
		return view.setFurtherCheckNeededEffect(effect);
	}
	@Override
	public Resource setCouncilPrivilege() throws RemoteException{
		return view.setCouncilPrivilege();
	}
	@Override
	public int[] setRequestedAuthorizationEffects(List<Effect> requestedAuthorizationEffects) throws RemoteException{
		return view.setRequestedAuthorizationEffects(requestedAuthorizationEffects);
	}
	@Override
	public Resource setDiscount(Resource res) throws RemoteException{
		return view.setDiscount(res);
	}
	@Override
	public ServerRMIViewRemote getServerStub() throws RemoteException{
		return this.serverStub;
	}

	@Override
	public void excommunicationManagement(String description) throws RemoteException {
		//TODO: INVENTARE LA FUNZIONE VERA SULLA VIEW
		
	}
	@Override
	public void stateOfTheGame(String state) throws RemoteException {
		view.printStateOfTheGame(state);
		
	}
	
	@Override
	public void setState(String stateCLI) throws RemoteException {
		view.setState(stateCLI);
		
	}
	
	
	
	

}