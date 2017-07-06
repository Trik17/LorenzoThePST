package it.polimi.ingsw.GC_04.server.controller;

public interface Observer<A> {
	
	public void update(A action);

	public void updateR(A resource);

}
