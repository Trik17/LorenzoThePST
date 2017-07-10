package testModel;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.polimi.ingsw.GC_04.server.model.FinalScore;
import it.polimi.ingsw.GC_04.server.model.Player;
import it.polimi.ingsw.GC_04.server.model.resource.Coins;
import it.polimi.ingsw.GC_04.server.model.resource.FaithPoints;
import it.polimi.ingsw.GC_04.server.model.resource.VictoryPoints;

public class TestFinalScore {
	private Player p1;
	private Player p2;
	private Player[] players;
	private Player[] playersF;
	
	
	@Before
	public void inizialize(){
		p1=new Player("AndreaTest",1);
		p2=new Player("MiriamTest", 2);
		players=new Player[2];
		playersF=new Player[2];
		
	}
	
	@Test
	public void testEndOfTheGame(){
		p2.getResource(new Coins()).addQuantity(10);
		p2.getResource(new FaithPoints()).addQuantity(10);
		p2.getResource(new VictoryPoints()).addQuantity(10);
		assertTrue(FinalScore.calculateFinalScore(p1)<FinalScore.calculateFinalScore(p2));
		players[0]=p1;
		players[1]=p2;
		playersF=FinalScore.getRanking(players);
		
		assertTrue(playersF[0].equals(p2));
		assertTrue(playersF[1].equals(p1));

		
		
	}
	
	

}
