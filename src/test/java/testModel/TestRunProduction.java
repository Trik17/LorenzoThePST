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
import it.polimi.ingsw.GC_04.server.model.effect.ExchangeResourcesEffect;
import it.polimi.ingsw.GC_04.server.model.effect.ResourceEffect;
import it.polimi.ingsw.GC_04.server.model.effect.SimpleResourceEffect;
import it.polimi.ingsw.GC_04.server.model.resource.FaithPoints;
import it.polimi.ingsw.GC_04.server.model.resource.RawMaterial;
import it.polimi.ingsw.GC_04.server.model.resource.Resource;
import it.polimi.ingsw.GC_04.server.model.resource.Stones;
import it.polimi.ingsw.GC_04.server.model.resource.VictoryPoints;
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
		CouncilPrivilege cp1 = new CouncilPrivilege();
		cp1.setCouncilPrivilege(new VictoryPoints(3));
		
		CouncilPrivilege cp2 = new CouncilPrivilege();
		cp2.setCouncilPrivilege(new RawMaterial(3));
		
		List<Resource> cost = new ArrayList<>();
		cost.add(new Stones(1));
		
		List<Resource> eff2 = new ArrayList<>();
		eff2.add(new FaithPoints(4));
		
		List<ResourceEffect> eff1 = new ArrayList<>();
		eff1.add(new SimpleResourceEffect(eff2));
		
		ExchangeResourcesEffect ere = new ExchangeResourcesEffect(eff1, cost, null, null);
		ere.setEffect(eff1, cost);
		
		List<Effect> effects = new ArrayList<>();
		effects.add(cp1);
		effects.add(ere);
		effects.add(cp2);
		
		Production production = new Production(1, effects);
		player1.getProduction().add(production);
		
		runProduction2.checkExtraordinaryEffect();
		
		assertEquals(runProduction2.getCouncilPrivileges().get(0), cp1);
		assertEquals(runProduction2.getCouncilPrivileges().get(1), cp2);

		runProduction2.applyEffects();
		
		assertEquals(0+3,player1.getResource(new VictoryPoints()).getQuantity());
		assertEquals(2-1+3,player1.getResource(new Stones()).getQuantity());
		assertEquals(2+3,player1.getResource(new Woods()).getQuantity());
		assertEquals(0+4,player1.getResource(new FaithPoints()).getQuantity());
	
	
	}
	
}
