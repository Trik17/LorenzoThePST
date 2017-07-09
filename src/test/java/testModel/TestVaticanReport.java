package testModel;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import it.polimi.ingsw.GC_04.server.model.Player;
import it.polimi.ingsw.GC_04.server.model.area.VaticanReport;
import it.polimi.ingsw.GC_04.server.model.card.ExcommunicationTile;
import it.polimi.ingsw.GC_04.server.model.effect.Effect;
import it.polimi.ingsw.GC_04.server.model.effect.SimpleResourceEffect;
import it.polimi.ingsw.GC_04.server.model.resource.FaithPoints;
import it.polimi.ingsw.GC_04.server.model.resource.Resource;
import it.polimi.ingsw.GC_04.server.model.resource.VictoryPoints;

public class TestVaticanReport {
	private Player p1;
	private Player p2;
	private Player p3;
	private ExcommunicationTile[] excommunications;
	private Effect eff;
	private List<Resource> res;
	private VaticanReport vatican;
	
	
	@Before
	public void inizialize(){
		p1=new Player("AndreaTest",1);
		p2=new Player("MiriamTest", 1);
		p3=new Player("LuigiTest", 1);
		excommunications=new ExcommunicationTile[3];
		res=new ArrayList<>();
		res.add(new VictoryPoints(3));
		eff=new SimpleResourceEffect(res);
		excommunications[0]=new ExcommunicationTile(1, null, "test description", eff);
		excommunications[1]=new ExcommunicationTile(2, null, "test description", eff);
		excommunications[2]=new ExcommunicationTile(3, null, "test description", eff);
		vatican=new VaticanReport(excommunications);
		
		
	}
	
	@Test
	public void testVatican(){
		assertTrue(excommunications[0].equals(vatican.getExcommunication(1)));
		assertTrue(excommunications[1].equals(vatican.getExcommunication(2)));
		assertTrue(excommunications[2].equals(vatican.getExcommunication(3)));
		
		assertTrue(VaticanReport.isUnderThreshold(p1, 1));
		assertTrue(VaticanReport.isUnderThreshold(p2, 2));
		assertTrue(VaticanReport.isUnderThreshold(p3, 3));
		
		p1.getResource(new FaithPoints()).addQuantity(VaticanReport.getThreshold(1));
		p2.getResource(new FaithPoints()).addQuantity(VaticanReport.getThreshold(2));
		p3.getResource(new FaithPoints()).addQuantity(VaticanReport.getThreshold(5));
				
		assertFalse(VaticanReport.isUnderThreshold(p1, 1));
		assertFalse(VaticanReport.isUnderThreshold(p2, 2));
		assertFalse(VaticanReport.isUnderThreshold(p3, 3));
		
		VaticanReport.addFaithPointsScore(p3);
		assertEquals(VaticanReport.getThreshold(5), p3.getResource(new VictoryPoints()).getQuantity());
		p3.getResource(new VictoryPoints()).addQuantity(-VaticanReport.getThreshold(5));
		
		p3.getResource(new FaithPoints()).addQuantity(3);
		VaticanReport.addFaithPointsScore(p3);
		assertEquals(11, p3.getResource(new VictoryPoints()).getQuantity());
		p3.getResource(new VictoryPoints()).addQuantity(-11);
		
		p3.getResource(new FaithPoints()).addQuantity(6);
		VaticanReport.addFaithPointsScore(p3);
		assertEquals(25, p3.getResource(new VictoryPoints()).getQuantity());
		p3.getResource(new VictoryPoints()).addQuantity(-25);
		
		p3.getResource(new FaithPoints()).addQuantity(1);
		VaticanReport.addFaithPointsScore(p3);
		assertEquals(30, p3.getResource(new VictoryPoints()).getQuantity());
		
	}
	
	@Test
	public void testEndVictoryPoints(){
		
	}

}
