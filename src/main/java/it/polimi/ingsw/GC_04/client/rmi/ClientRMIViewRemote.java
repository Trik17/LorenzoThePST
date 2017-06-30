package it.polimi.ingsw.GC_04.client.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import it.polimi.ingsw.GC_04.model.Dice;
import it.polimi.ingsw.GC_04.model.Model;
import it.polimi.ingsw.GC_04.model.card.DevelopmentCard;
import it.polimi.ingsw.GC_04.model.card.ExcommunicationTile;
import it.polimi.ingsw.GC_04.model.effect.Effect;
import it.polimi.ingsw.GC_04.model.resource.Resource;
import it.polimi.ingsw.GC_04.view.ServerRMIViewRemote;


//is the remote interface of the client to receive and show data from the server through RMI.
public interface ClientRMIViewRemote extends Remote {
	
	public String getUsername() throws RemoteException;

	public void askSomething(String string) throws RemoteException;
	public void addServerstub(ServerRMIViewRemote serverStub) throws RemoteException;

	public void chooseAction()throws RemoteException;

	public int[] setFurtherCheckNeededEffect(Effect effect)throws RemoteException;

	public Resource setCouncilPrivilege()throws RemoteException;

	public int[] setRequestedAuthorizationEffects(List<Effect> requestedAuthorizationEffects)throws RemoteException;

	public Resource setDiscount(Resource res)throws RemoteException;
	
	public ServerRMIViewRemote getServerStub() throws RemoteException;

	public void stateOfTheGame(Model model, DevelopmentCard[] tCards, DevelopmentCard[] cCards, DevelopmentCard[] bCards,
			DevelopmentCard[] vCards, Dice black, Dice orange, Dice white) throws RemoteException;

	public void excommunicationManagement(String description)throws RemoteException;
	
	
}