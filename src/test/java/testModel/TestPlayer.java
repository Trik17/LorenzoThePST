package testModel;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import it.polimi.ingsw.GC_04.model.FamilyColor;
import it.polimi.ingsw.GC_04.model.Player;
import it.polimi.ingsw.GC_04.model.resource.*;



public class TestPlayer {
	protected Player p1;
	protected Player p2;
	protected Player p3;
	protected Player p4;
	protected List<Player> players;
	protected List<Resource> res;
	private int p1Turn=1;
	private int p2Turn=2;
	private int p3Turn=3;
	private int p4Turn=4;
	
	@Before
	public void inizializer(){
		p1=new Player("AndreaTest",p1Turn ,null);
		p2=new Player("MiriamTest", p2Turn,null);
		p3=new Player("LuigiTest", p3Turn,null);
		p4=new Player("MartinTest", p4Turn,null);
		players=new ArrayList<Player>();
		players.add(p1);
		players.add(p2);
		players.add(p3);
		players.add(p4);
		
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
	
	

}
