package testEffect;

import org.junit.Before;

import it.polimi.ingsw.GC_04.server.model.FamilyColor;
import it.polimi.ingsw.GC_04.server.model.FamilyMember;
import it.polimi.ingsw.GC_04.server.model.Model;
import it.polimi.ingsw.GC_04.server.model.Player;

public class TestEffect {

	protected Player player;
	
	@Before
	public void initaliza() {
		player = new Player("MIRIAM", 0);
		Model model = new Model();
		
		FamilyMember[] family = FamilyMember.createFamily(FamilyColor.RED, model);
		player.setFamily(family);
	}
}
