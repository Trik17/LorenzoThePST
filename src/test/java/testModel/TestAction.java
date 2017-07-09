package testModel;

import org.junit.Before;

import it.polimi.ingsw.GC_04.server.controller.Initializer;
import it.polimi.ingsw.GC_04.server.model.DiceColor;
import it.polimi.ingsw.GC_04.server.model.FamilyMember;
import it.polimi.ingsw.GC_04.server.model.Model;
import it.polimi.ingsw.GC_04.server.model.Player;

public class TestAction {

	protected Model model;
	protected int servants1 = 2;
	protected int servants2 = 6;
	protected int servants3 = 0;
	protected Player player1;
	protected Player player2;
	protected FamilyMember fMemberBlackP1;
	protected FamilyMember fMemberNeutralP1;
	protected FamilyMember fMemberBlackP2;
	protected FamilyMember fMemberNeutralP2;
	
	@Before
	public void inizializer(){
		
		model = new Model();
		player1 = new Player("Luigi", 1);
		player2 = new Player("Martin", 2);
		Player[] players = new Player[2];
		players[0] = player1;
		players[1] = player2;
		model.setPlayers(players);
		Initializer initializer = new Initializer(players, model);
		fMemberBlackP1 = model.getPlayer(player1.getName()).getFamilyMember(DiceColor.BLACK);
		fMemberNeutralP1 = model.getPlayer(player1.getName()).getFamilyMember(DiceColor.NEUTRAL);
		fMemberBlackP2 = model.getPlayer(player2.getName()).getFamilyMember(DiceColor.BLACK);
		fMemberNeutralP2 = model.getPlayer(player2.getName()).getFamilyMember(DiceColor.NEUTRAL);
	}
	
	
}
