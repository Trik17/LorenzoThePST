package it.polimi.ingsw.GC_04.server.controller;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable<A> {

	private List<Observer<A>> observers;

	public Observable() {

		observers = new ArrayList<Observer<A>>();
	}

	public void registerObserver(Observer<A> o) {
		observers.add(o);
	}

	public void unregisterObserver(Observer<A> o) {
		this.observers.remove(o);
	}


	public void notifyObserversA(A action) {
		for (Observer<A> o : this.observers) {
			o.update(action);
			return;//TODO
		}
	}
	public void notifyObserversR(A resource) {
		for (Observer<A> o : this.observers) {
			o.updateR(resource);
			return;//TODO
		}
	}
	
}
