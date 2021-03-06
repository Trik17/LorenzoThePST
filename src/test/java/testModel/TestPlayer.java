package testModel;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import it.polimi.ingsw.GC_04.server.model.Player;
import it.polimi.ingsw.GC_04.server.model.card.BuildingCard;
import it.polimi.ingsw.GC_04.server.model.card.CharacterCard;
import it.polimi.ingsw.GC_04.server.model.card.TerritoryCard;
import it.polimi.ingsw.GC_04.server.model.card.VentureCard;
import it.polimi.ingsw.GC_04.server.model.effect.Effect;
import it.polimi.ingsw.GC_04.server.model.effect.SimpleResourceEffect;
import it.polimi.ingsw.GC_04.server.model.resource.*;



public class TestPlayer {
	protected Player p1;
	protected Player p2;
	protected Player p3;
	protected Player p4;
	protected List<Player> players;
	protected List<Resource> res;
	protected List<Resource> cost;
	private int p1Turn=1;
	private int p2Turn=2;
	private int p3Turn=3;
	private int p4Turn=4;
	
	@Before
	public void inizializer(){
		p1=new Player("AndreaTest",p1Turn);
		p2=new Player("MiriamTest", p2Turn);
		p3=new Player("LuigiTest", p3Turn);
		p4=new Player("MartinTest", p4Turn);
		players=new ArrayList<Player>();
		players.add(p1);
		players.add(p2);
		players.add(p3);
		players.add(p4);
		cost=new ArrayList<>();
		cost.add(new Coins(1));
		cost.add(new Woods(1));
		
	}

	@Test
	public void testInitialResource() {
		for(Player p : players){
			res=p.getResources();
			for(Resource r:res){
				if(r.getClass().equals(Woods.class) || r.getClass().equals(Stones.class))
					assertEquals(2, r.getQuantity());
				else if(r.getClass().equals(Servants.class))
					assertEquals(3, r.getQuantity());
				else if(r.getClass().equals(Coins.class)){
					if(p.equals(p1))
						assertEquals(5, r.getQuantity());
					if(p.equals(p2))
						assertEquals(6, r.getQuantity());
					if(p.equals(p3))
						assertEquals(7, r.getQuantity());
					if(p.equals(p4))
						assertEquals(8, r.getQuantity());
				}else
					assertEquals(0, r.getQuantity());				
			}
		}		
	}
	
	@Test
	public void testIsAffordable(){
		assertTrue(Resource.isAffordable(p1.getResources(), cost));
		cost.add(new Coins(1));
		assertTrue(Resource.isAffordable(p1.getResources(), cost));
		cost.add(new Woods(50));
		assertFalse(Resource.isAffordable(p1.getResources(), cost));
	}
	
	@Test
	public void testSetEffects() {
		assertFalse(p1.isDeleteCardsEffectActive(new TerritoryCard()));
		assertFalse(p1.isDeleteCardsEffectActive(new CharacterCard()));
		assertFalse(p1.isDeleteCardsEffectActive(new BuildingCard()));
		assertFalse(p1.isDeleteCardsEffectActive(new VentureCard()));
		
		p1.setDeleteCardsEffectActive(new TerritoryCard());
		p1.setDeleteCardsEffectActive(new CharacterCard());
		p1.setDeleteCardsEffectActive(new BuildingCard());
		p1.setDeleteCardsEffectActive(new VentureCard());
		
		assertTrue(p1.isDeleteCardsEffectActive(new TerritoryCard()));
		assertTrue(p1.isDeleteCardsEffectActive(new CharacterCard()));
		assertTrue(p1.isDeleteCardsEffectActive(new BuildingCard()));
		assertTrue(p1.isDeleteCardsEffectActive(new VentureCard()));
		
		assertFalse(p1.isNotRequestedMilitaryPoints());
		p1.setNotRequestedMilitaryPoints();
		assertTrue(p1.isNotRequestedMilitaryPoints());
		
		List<Resource> resources = new ArrayList<>();
		resources.add(new Coins());
		Effect effect = new SimpleResourceEffect(resources);
		p1.setBonusAction(effect);
		assertEquals(effect, p1.getBonusAction().get(0));
		
		assertFalse(p1.getActionSpacePenality());
		p1.setActionSpacePenality();
		assertTrue(p1.getActionSpacePenality());
		
	}
	

}
