package testEffect;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.polimi.ingsw.GC_04.server.model.ExtraDice;
import it.polimi.ingsw.GC_04.server.model.effect.ExtraDiceProductionEffect;
import testModel.TestPlayer;

public class TestExtraDiceProduction extends TestPlayer{
	ExtraDice extra;
	ExtraDiceProductionEffect eff;
	
	@Before
	public void Initialize(){
		extra=p1.getExtraDice();
		eff=new ExtraDiceProductionEffect(3);
	}
	
	@Test
	public void testApplyExtra(){
		assertEquals(0, p1.getExtraDice().getProductionExtra());
		eff.apply(p1);
		assertEquals(3, p1.getExtraDice().getProductionExtra());
	}

}
