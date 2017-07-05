//package testModel;
//
//import static org.junit.Assert.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Test;
//
//import it.polimi.ingsw.GC_04.model.Player;
//import it.polimi.ingsw.GC_04.model.effect.CouncilPrivilege;
//import it.polimi.ingsw.GC_04.model.resource.Coins;
//import it.polimi.ingsw.GC_04.model.resource.FaithPoints;
//import it.polimi.ingsw.GC_04.model.resource.MilitaryPoints;
//import it.polimi.ingsw.GC_04.model.resource.RawMaterial;
//import it.polimi.ingsw.GC_04.model.resource.Resource;
//import it.polimi.ingsw.GC_04.model.resource.Servants;
//
//
//public class TestCouncilPrivilege {
//	private CouncilPrivilege councilPrivilege;
//	protected Player player1;
//	protected Player player2;
//	protected List <Player> players;
//	protected List<Resource> res;
//	private int turn1 = 1;
//	private int turn2 = 2;
//	
//	public void inizializer(){
//		player1=new Player("AndreaTest",turn1 ,null);
//		player2=new Player("MiriamTest", turn2,null);
//		players=new ArrayList<Player>();
//		players.add(player1);
//		players.add(player2);
//		councilPrivilege = new CouncilPrivilege();
//		councilPrivilege.apply(player1);
//		councilPrivilege.apply(player2);
//	}
//	
//	@Test
//	public void testCheckNumberResource(){
//		for(Player p : players){
//			res=p.getResources();
//			
//			for(Resource r:res){
//				if(r.getClass().equals(FaithPoints.class))
//					assertEquals(1, councilPrivilege.getEffect());
//				else if(r.getClass().equals(MilitaryPoints.class))
//					assertEquals(2, councilPrivilege.getEffect());
//				else if(r.getClass().equals(Coins.class))
//					assertEquals(2, councilPrivilege.getEffect());
//				else if(r.getClass().equals(Servants.class))
//					assertEquals(2, councilPrivilege.getEffect());
//				else if(r.getClass().equals(RawMaterial.class))
//					assertEquals(1, councilPrivilege.getEffect());
//			}
//		}
//	}
//
//}
