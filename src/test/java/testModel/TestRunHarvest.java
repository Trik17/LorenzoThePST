package testModel;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import it.polimi.ingsw.GC_04.server.controller.Initializer;
import it.polimi.ingsw.GC_04.server.model.ActionSpace;
import it.polimi.ingsw.GC_04.server.model.Harvest;
import it.polimi.ingsw.GC_04.server.model.Player;
import it.polimi.ingsw.GC_04.server.model.Production;
import it.polimi.ingsw.GC_04.server.model.action.RunHarvest;
import it.polimi.ingsw.GC_04.server.model.effect.CouncilPrivilege;
import it.polimi.ingsw.GC_04.server.model.effect.Effect;
import it.polimi.ingsw.GC_04.server.model.resource.Woods;

public class TestRunHarvest extends TestAction{

	private List<ActionSpace> harvestArea;
	private RunHarvest runHarvest1;
	private RunHarvest runHarvest2;
	private RunHarvest runHarvest3;
	
	@Before
	public void inizializer(){
		super.inizializer();
		harvestArea = model.getHarvest().getASpaces();
		runHarvest1 = new RunHarvest(model, player1, fMemberNeutralP1, servants1);
		runHarvest2 = new RunHarvest(model, player1, fMemberNeutralP1, servants2);
		runHarvest3 = new RunHarvest(model, player1, fMemberNeutralP1, servants3);		
		
	}
	
	@Test 
	public void testIsApplicable() {
		assertFalse(runHarvest1.isApplicable());
		assertTrue(runHarvest2.isApplicable());
		assertFalse(runHarvest3.isApplicable());
		
		runHarvest2.apply();
		assertFalse(runHarvest2.isApplicable());
	}
	
	@Test
	public void testCreateNewAspace() {
		players = new Player[4];
		players[0] = player1;
		players[1] = player1;
		players[2] = player1;
		players[3] = player1;
		model.setPlayers(players);
		Initializer initializer = new Initializer(players, model);
		
		harvestArea = model.getHarvest().getASpaces();
		int size = harvestArea.size();
		runHarvest1.createNewASpace();
		
		assertEquals(size+1, harvestArea.size());
		assertEquals(model.getHarvest().getActionSpaceDefault(), model.getHarvest().getASpaces().get(size));
		
		
	}
	
	@Test
	public void testHarvestEffects() {
		CouncilPrivilege cp = new CouncilPrivilege();
		cp.setCouncilPrivilege(new Woods(3));
		List<Effect> effects = new ArrayList<>();
		effects.add(cp);
		Harvest harvest = new Harvest(1, effects);
		player1.getHarvest().add(harvest);
		runHarvest2.checkExtraordinaryEffect();
		assertEquals(runHarvest2.getCouncilPrivileges().get(0), cp);
		
		runHarvest2.applyEffects();
		assertEquals(2+3,player1.getResource(new Woods()).getQuantity());
	
	}
}
