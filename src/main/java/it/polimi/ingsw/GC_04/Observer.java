package it.polimi.ingsw.GC_04;

public interface Observer<A,R> {
	public void update();
	public void updateAction(A action);
	public void updateResource(R resource);
}
