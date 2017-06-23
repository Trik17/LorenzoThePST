package it.polimi.ingsw.GC_04;

public interface Observer<A,R> {
	
	public void update(A action);

	public void updateR(R resource);
}
