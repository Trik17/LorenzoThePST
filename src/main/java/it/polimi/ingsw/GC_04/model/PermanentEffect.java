package it.polimi.ingsw.GC_04.model;

public class PermanentEffect extends Effect {


	public PermanentEffect(Card c) {
		super();
		// TODO Auto-generated constructor stub
	}

	public void apply(){
		// fare questa e in caso annullare :isApplicable(); -> e va pure definita
		//o la mettiamo in effect in generale e la definiamo per tutti?
		
		
		//o usiamo dei listener collegati a certe azioni
		// o come extra dice collegati a certe azioni come attributi o del player o family member o classe a parte o qui
	}

	@Override
	public void apply(Player player) {
		// TODO Auto-generated method stub
		
	}
}
