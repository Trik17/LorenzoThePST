package testEffect;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


import it.polimi.ingsw.GC_04.server.model.ActionSpace;
import it.polimi.ingsw.GC_04.server.model.Dice;
import it.polimi.ingsw.GC_04.server.model.FamilyMember;
import it.polimi.ingsw.GC_04.server.model.Model;
import it.polimi.ingsw.GC_04.server.model.Player;
import it.polimi.ingsw.GC_04.server.model.action.*;
import it.polimi.ingsw.GC_04.server.model.card.CharacterCard;
import it.polimi.ingsw.GC_04.server.model.card.DevelopmentCard;
import it.polimi.ingsw.GC_04.server.model.card.VentureCard;
import it.polimi.ingsw.GC_04.server.model.resource.Coins;
import it.polimi.ingsw.GC_04.server.model.resource.Resource;
import it.polimi.ingsw.GC_04.server.model.resource.Woods;

public class TestCardEffect extends InizializeTest {
	
	
	private DevelopmentCard c1;
	private DevelopmentCard c2;
	private List<Resource> cost;
	private List<Resource> costHigh;
	private List<Resource> discount;
	private Action a1;
	private Action a2;
	private ActionSpace as;
	private FamilyMember fm;
	private Dice dice;
	
	@Before
	public void inizialize(){
		cost=new ArrayList<>();
		costHigh=new ArrayList<>();
		discount=new ArrayList<>();
		dice=new Dice(3);
		fm=new FamilyMember(dice);
		as=new ActionSpace(1, null);
		discount.add(new Woods());
		cost.add(new Coins(1));
		cost.add(new Woods(1));
		costHigh.add(new Coins(50));
		c1=new VentureCard(1, "prova", null,null, costHigh, null, null);
		c2=new CharacterCard(1, "prova", null,null, cost, null, null);
		a1=new TakeACard(model, p1, c1, as, fm, 0, c1.getCost1());
		a2=new TakeACard(model, p1, c2, as, fm, 0, c1.getCost1());
		a1.setDiscount(discount);
		a2.setDiscount(discount);
	}

	@Test
	public void testCost() {
		//se ne possono aggiungere tanti altri qua
		assertFalse(a1.isApplicable());
		assertTrue(a2.isValueEnough());
		
	}

}
