package it.polimi.ingsw.GC_04;

public class TakeBuilding extends TakeACard{

	public TakeBuilding(Player player, DevelopementCard card, ActionSpace aSpace, FamilyMember fMember, int servants) {
		super(player, card, aSpace, fMember, servants);
		this.value = fMember.getDice().getValue() + servants + player.getExtraDice().getExtraBuilding();
	}

	@Override
	public boolean isApplicable() {
		// TODO Auto-generated method stub
		return false;
	}

}
