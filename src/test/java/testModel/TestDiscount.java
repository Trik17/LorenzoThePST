package testModel;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import it.polimi.ingsw.GC_04.server.model.Discount;
import it.polimi.ingsw.GC_04.server.model.card.BuildingCard;
import it.polimi.ingsw.GC_04.server.model.card.CharacterCard;
import it.polimi.ingsw.GC_04.server.model.card.DevelopmentCard;
import it.polimi.ingsw.GC_04.server.model.card.TerritoryCard;
import it.polimi.ingsw.GC_04.server.model.card.VentureCard;
import it.polimi.ingsw.GC_04.server.model.resource.Resource;
import it.polimi.ingsw.GC_04.server.model.resource.Stones;

public class TestDiscount {

	Discount discount;
	
	@Test
	public void testDiscount() {
		discount = new Discount();
		List<Resource> resources = new ArrayList<>();
		resources.add(new Stones());
		
		DevelopmentCard tCard = new TerritoryCard();
		DevelopmentCard cCard = new CharacterCard();
		DevelopmentCard bCard = new BuildingCard();
		DevelopmentCard vCard = new VentureCard();
		
		discount.setDiscount(tCard, resources);
		discount.setDiscount(cCard, resources);
		discount.setDiscount(bCard, resources);
		discount.setDiscount(vCard, resources);
		
		assertEquals(resources,discount.getDiscount(tCard));
		assertEquals(resources,discount.getDiscount(cCard));
		assertEquals(resources,discount.getDiscount(bCard));
		assertEquals(resources,discount.getDiscount(vCard));
		
	}
}
