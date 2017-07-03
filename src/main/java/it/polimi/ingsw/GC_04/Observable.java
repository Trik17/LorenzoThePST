package it.polimi.ingsw.GC_04;

import java.util.ArrayList;
import java.util.List;



public abstract class Observable<A,R> {

	private List<Observer<A,R>> observers;

	public Observable() {

		observers = new ArrayList<Observer<A,R>>();
	}

	public void registerObserver(Observer<A,R> o) {
		observers.add(o);
	}

	public void unregisterObserver(Observer<A,R> o) {
		this.observers.remove(o);
	}


	public void notifyObserversA(A action) {
		for (Observer<A,R> o : this.observers) {
			o.update(action);
		}
	}
	public void notifyObserversR(A resource) {
		for (Observer<A,R> o : this.observers) {
			o.updateR(resource);
		}
	}
	
}
