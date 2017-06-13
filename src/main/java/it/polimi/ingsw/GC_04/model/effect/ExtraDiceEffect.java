package it.polimi.ingsw.GC_04.model.effect;

public abstract class ExtraDiceEffect extends Effect {

	protected int extra;

	public ExtraDiceEffect(int extra) {
		this.extra = extra;
	}
}
