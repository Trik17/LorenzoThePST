package testModel;

import static org.junit.Assert.*;

import org.junit.Test;

import it.polimi.ingsw.GC_04.model.ExtraDice;
import it.polimi.ingsw.GC_04.model.card.*;

public class TestExtraDice {
	DevelopmentCard c;
	ExtraDice x;
	
	@Test
	public void testGetNull() {
		x=new ExtraDice();
		c=new TerritoryCard();
		assertEquals(0, x.getCardExtra(c));
	}
	
	@Test
	public void testGetNeg() {
		x=new ExtraDice();
		c=new BuildingCard();
		x.setCardExtra(c, -1);
		assertEquals(-1, x.getCardExtra(c));
	}
	@Test
	public void testGetPos() {
		x=new ExtraDice();
		c=new CharacterCard();
		x.setCardExtra(c, 1);
		assertEquals(1, x.getCardExtra(c));
	}
	
	@Test
	public void testGetZero() {
		x=new ExtraDice();
		c=new VentureCard();
		x.setCardExtra(c,0);
		assertEquals(0, x.getCardExtra(c));
	}
	
	
	
	

}
