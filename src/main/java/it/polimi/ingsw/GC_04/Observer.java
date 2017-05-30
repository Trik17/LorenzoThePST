package it.polimi.ingsw.GC_04;

public interface Observer<C> {
	public void update();
	public default void update(C change){
		System.out.println("I am the "+this.getClass().getSimpleName()+" I have been notified with the "+change.getClass().getSimpleName());
	}
}
