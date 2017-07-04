package it.polimi.ingsw.GC_04.client;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Set;

import it.polimi.ingsw.GC_04.model.effect.Effect;
import it.polimi.ingsw.GC_04.model.resource.Resource;
import it.polimi.ingsw.GC_04.view.ServerRMIViewRemote;


//is the remote interface of the client to receive and show data from the server through RMI.
public interface ClientRMIViewRemote extends Remote {
	
	public String getUsername() throws RemoteException;

	public void addServerstub(ServerRMIViewRemote serverStub) throws RemoteException;

	public void chooseAction()throws RemoteException;

	public void setFurtherCheckNeededEffect(List<Effect> requestedAuthorizationEffects, int[] furtherCheckNeeded)throws RemoteException;

	public void setCouncilPrivilege(int nrOfPrivileges)throws RemoteException;

	public void setRequestedAuthorizationEffects(List<Effect> requestedAuthorizationEffects)throws RemoteException;

	public void setDiscount(List<Resource> rawMaterials)throws RemoteException;
	
	public ServerRMIViewRemote getServerStub() throws RemoteException;

	public void stateOfTheGame(String state) throws RemoteException;

	public void excommunicationManagement(String description)throws RemoteException;

	public void setState(String stateCLI)throws RemoteException;

	public void print(String username)  throws RemoteException;

	public void notifyReconnection(String username) throws RemoteException;
	
	public void changeUsername(Set<String> set) throws RemoteException;
}