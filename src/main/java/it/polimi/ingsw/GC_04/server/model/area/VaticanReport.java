package it.polimi.ingsw.GC_04.server.model.area;

import java.io.Serializable;
import it.polimi.ingsw.GC_04.server.model.Player;
import it.polimi.ingsw.GC_04.server.model.card.ExcommunicationTile;
import it.polimi.ingsw.GC_04.server.model.resource.FaithPoints;
import it.polimi.ingsw.GC_04.server.model.resource.VictoryPoints;

public class VaticanReport implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1801141987893666675L;
	private final ExcommunicationTile[] excommunications;
	//minimum number of faith points to avoid the excommunication
	private static final int THRESHOLD1 = 3;
	private static final int THRESHOLD2 = 4;
	private static final int THRESHOLD3 = 5;

	public VaticanReport(ExcommunicationTile[] excommunications) {
		this.excommunications = excommunications;
		
	}
	
	/*
	 * this function take in input a player a period and return true if 
	 * player's faith points are less than the threshold of the period 
	 * that permit to choose between support the church or be excommunicated
	 */
	public static boolean isUnderThreshold(Player player,int period) {
		if (player.getResource(new FaithPoints()).getQuantity() < getThreshold(period))
			return true;
		return false;
	}
	
	public ExcommunicationTile getExcommunication(int period) {
		return excommunications[period -1];
	}

	public static int getThreshold(int period) {
		switch (period) {
		case 1:
			return THRESHOLD1;
		case 2:
			return THRESHOLD2;
		default:
			return THRESHOLD3;
		}
	}
	/*
	 * it increments player's V according to the player position in the vatican report
	 * that is actually the number of his faithpoints
	 */
	public static void addFaithPointsScore(Player player) {
		int faithPointsScore = 0;
		int faithPoints = player.getResource(new FaithPoints()).getQuantity();
		
		for (int cont = 1; cont <= faithPoints; cont++) {
			if (cont < 6)
				faithPointsScore++;
			else if (cont >= 6 && cont < 13)
				faithPointsScore += 2;
			else if (cont >= 13 && cont < 15)
				faithPointsScore += 3;
			else
				faithPointsScore += 5;
		}
		
		player.getResource(new VictoryPoints()).addQuantity(faithPointsScore);
			
	}
}
