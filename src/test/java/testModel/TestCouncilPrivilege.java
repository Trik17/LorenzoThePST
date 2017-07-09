package testModel;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import it.polimi.ingsw.GC_04.server.model.Player;
import it.polimi.ingsw.GC_04.server.model.effect.CouncilPrivilege;
import it.polimi.ingsw.GC_04.server.model.resource.Coins;
import it.polimi.ingsw.GC_04.server.model.resource.FaithPoints;
import it.polimi.ingsw.GC_04.server.model.resource.MilitaryPoints;
import it.polimi.ingsw.GC_04.server.model.resource.RawMaterial;
import it.polimi.ingsw.GC_04.server.model.resource.Resource;
import it.polimi.ingsw.GC_04.server.model.resource.Servants;
import it.polimi.ingsw.GC_04.server.model.resource.Stones;
import it.polimi.ingsw.GC_04.server.model.resource.Woods;



public class TestCouncilPrivilege {
	private CouncilPrivilege councilPrivilege;
	private CouncilPrivilege councilPrivilege2;
	private CouncilPrivilege councilPrivilege3;
	private CouncilPrivilege councilPrivilege4;
	private CouncilPrivilege councilPrivilege5;
	
	protected Player player1;
	protected Player player2;
	protected Player player3;
	protected Player player4;
	protected Player player5;
	protected List <Player> players;
	protected List<Resource> res;
	
	@Before
	public void inizializer(){
		player1=new Player("AndreaTest",1);
		player2=new Player("MiriamTest",1);
		player3=new Player("LuigiTest",1);
		player4=new Player("Test4",1);
		player5=new Player("Test5",1);
		players=new ArrayList<Player>();
		players.add(player1);
		players.add(player2);
		players.add(player3);
		players.add(player4);
		players.add(player5);
		councilPrivilege = new CouncilPrivilege();
		councilPrivilege2 = new CouncilPrivilege();
		councilPrivilege3 = new CouncilPrivilege();
		councilPrivilege4 = new CouncilPrivilege();
		councilPrivilege5 = new CouncilPrivilege();
		councilPrivilege.setCouncilPrivilege(new RawMaterial(1));
		councilPrivilege2.setCouncilPrivilege(new Coins(2));
		councilPrivilege3.setCouncilPrivilege(new FaithPoints(1));
		councilPrivilege4.setCouncilPrivilege(new MilitaryPoints(2));
		councilPrivilege5.setCouncilPrivilege(new Servants(2));
		councilPrivilege.apply(player1);
		councilPrivilege2.apply(player2);
		councilPrivilege3.apply(player3);
		councilPrivilege4.apply(player4);
		councilPrivilege5.apply(player5);
		}
	
	@Test
	public void testCheckNumberResource(){
		res=player1.getResources();
			
			for(Resource r:res){
				if(r.getClass().equals(FaithPoints.class))
					assertEquals(0, r.getQuantity());
				else if(r.getClass().equals(MilitaryPoints.class))
					assertEquals(0, r.getQuantity());
				else if(r.getClass().equals(Coins.class))
					assertEquals(5, r.getQuantity());
				else if(r.getClass().equals(Servants.class))
					assertEquals(3, r.getQuantity());
				else if(r.getClass().equals(Woods.class))
					assertEquals(3, r.getQuantity());
				else if(r.getClass().equals(Stones.class))
					assertEquals(3, r.getQuantity());
			}
			res=player2.getResources();
			
			for(Resource r:res){
				if(r.getClass().equals(FaithPoints.class))
					assertEquals(0, r.getQuantity());
				else if(r.getClass().equals(MilitaryPoints.class))
					assertEquals(0, r.getQuantity());
				else if(r.getClass().equals(Coins.class))
					assertEquals(7, r.getQuantity());
				else if(r.getClass().equals(Servants.class))
					assertEquals(3, r.getQuantity());
				else if(r.getClass().equals(Woods.class))
					assertEquals(2, r.getQuantity());
				else if(r.getClass().equals(Stones.class))
					assertEquals(2, r.getQuantity());
			}
			res=player3.getResources();
			for(Resource r:res){
				if(r.getClass().equals(FaithPoints.class))
					assertEquals(1, r.getQuantity());
				else if(r.getClass().equals(MilitaryPoints.class))
					assertEquals(0, r.getQuantity());
				else if(r.getClass().equals(Coins.class))
					assertEquals(5, r.getQuantity());
				else if(r.getClass().equals(Servants.class))
					assertEquals(3, r.getQuantity());
				else if(r.getClass().equals(Woods.class))
					assertEquals(2, r.getQuantity());
				else if(r.getClass().equals(Stones.class))
					assertEquals(2, r.getQuantity());
			}
			res=player4.getResources();
			for(Resource r:res){
				if(r.getClass().equals(FaithPoints.class))
					assertEquals(0, r.getQuantity());
				else if(r.getClass().equals(MilitaryPoints.class))
					assertEquals(2, r.getQuantity());
				else if(r.getClass().equals(Coins.class))
					assertEquals(5, r.getQuantity());
				else if(r.getClass().equals(Servants.class))
					assertEquals(3, r.getQuantity());
				else if(r.getClass().equals(Woods.class))
					assertEquals(2, r.getQuantity());
				else if(r.getClass().equals(Stones.class))
					assertEquals(2, r.getQuantity());
			}
			res=player5.getResources();
			for(Resource r:res){
				if(r.getClass().equals(FaithPoints.class))
					assertEquals(0, r.getQuantity());
				else if(r.getClass().equals(MilitaryPoints.class))
					assertEquals(0, r.getQuantity());
				else if(r.getClass().equals(Coins.class))
					assertEquals(5, r.getQuantity());
				else if(r.getClass().equals(Servants.class))
					assertEquals(5, r.getQuantity());
				else if(r.getClass().equals(Woods.class))
					assertEquals(2, r.getQuantity());
				else if(r.getClass().equals(Stones.class))
					assertEquals(2, r.getQuantity());
			}
	}

}
