package it.polimi.ingsw.GC_04;

import java.rmi.RemoteException;

public interface Observer<A,R> {
	
	public void update(A action)throws RemoteException;;

//	public void updateR(R resource);
}
