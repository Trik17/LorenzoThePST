package it.polimi.ingsw.GC_04;

public class ActionSpace {
	
	private Area areaName;
	private int activationCost;//valore necessario del dado
	//private effettoo immediato con fantomatica classe cost
	private FamilyMember fMember;
	
	
	public ActionSpace(Area areaName, int activationCost, //effetto immediato){
		this.areaName = areaName;
		this.activationCost = activationCost;
		//l'altro
	}
}
