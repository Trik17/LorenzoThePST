package testEffect;

import org.junit.Before;

import it.polimi.ingsw.GC_04.server.StartGame;
import it.polimi.ingsw.GC_04.server.controller.Controller;
import it.polimi.ingsw.GC_04.server.model.Model;
import it.polimi.ingsw.GC_04.server.model.Player;

public class InizializeTest {
	protected Controller controller;
	protected Model model;
	protected Player p1;
	protected Player p2;
	protected Player p3;
	protected Player p4;
	protected Player[] players;
	
	@Before
	public void inizializerGame(){
		model=new Model();
		controller=new Controller(model,null);
		p1=new Player("AndreaTest",1 ,null);
		p2=new Player("miriamTest",2 ,null);
		p3=new Player("gigiTest",3 ,null);
		p4=new Player("CugolaTest",4 ,null);
		players=new Player[4];
		players[0]=p1;
		players[1]=p2;
		players[2]=p3;
		players[3]=p4;
		model.setPlayers(players);
		controller.setInizializer(players);
		
	}
}
