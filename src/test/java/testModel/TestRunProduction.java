package testModel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import it.polimi.ingsw.GC_04.server.controller.Initializer;
import it.polimi.ingsw.GC_04.server.model.ActionSpace;
import it.polimi.ingsw.GC_04.server.model.Player;
import it.polimi.ingsw.GC_04.server.model.Production;
import it.polimi.ingsw.GC_04.server.model.action.RunProduction;
import it.polimi.ingsw.GC_04.server.model.effect.CouncilPrivilege;
import it.polimi.ingsw.GC_04.server.model.effect.Effect;
import it.polimi.ingsw.GC_04.server.model.effect.SimpleResourceEffect;
import it.polimi.ingsw.GC_04.server.model.resource.Woods;

public class TestRunProduction extends TestAction{

	private List<ActionSpace> productionArea;
	private RunProduction runProduction1;
	private RunProduction runProduction2;
	private RunProduction runProduction3;
	
	@Before
	public void inizializer(){
		super.inizializer();
		productionArea = model.getProduction().getASpaces();
		runProduction1 = new RunProduction(model, player1, fMemberNeutralP1, servants1);
		runProduction2 = new RunProduction(model, player1, fMemberNeutralP1, servants2);
		runProduction3 = new RunProduction(model, player1, fMemberNeutralP1, servants3);		
		
	}
	
	@Test 
	public void testIsApplicable() {
		assertFalse(runProduction1.isApplicable());
		assertTrue(runProduction2.isApplicable());
		assertFalse(runProduction3.isApplicable());
		
		runProduction2.apply();
		assertFalse(runProduction2.isApplicable());
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
		
		productionArea = model.getProduction().getASpaces();
		int size = productionArea.size();
		runProduction1.createNewASpace();
		
		assertEquals(size+1, productionArea.size());
		assertEquals(model.getProduction().getActionSpaceDefault(), model.getProduction().getASpaces().get(size));
	
	}
	
	@Test
	public void testProductionEffects() {
		CouncilPrivilege cp = new CouncilPrivilege();
		cp.setCouncilPrivilege(new Woods(3));
		List<Effect> effects = new ArrayList<>();
		effects.add(cp);
		Production production = new Production(1, effects);
		player1.getProduction().add(production);
		runProduction2.checkExtraordinaryEffect();
		assertEquals(runProduction2.getCouncilPrivileges().get(0), cp);

		runProduction2.applyEffects();
		assertEquals(2+3,player1.getResource(new Woods()).getQuantity());
	
	
	}
	
}
