package testView;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import it.polimi.ingsw.GC_04.client.rmi.ViewCLI;
import it.polimi.ingsw.GC_04.controller.Controller;
import it.polimi.ingsw.GC_04.model.Dice;
import it.polimi.ingsw.GC_04.model.Model;
import it.polimi.ingsw.GC_04.model.card.BuildingCard;
import it.polimi.ingsw.GC_04.model.card.DevelopmentCard;
import it.polimi.ingsw.GC_04.model.effect.*;
import it.polimi.ingsw.GC_04.model.resource.*;

public class testViewCLI {//it isn't a real test
	
	
/*	
	
	@Test
	public void testSetRequestedAuthorizationEffects() {
		CouncilPrivilege cp=new CouncilPrivilege();
		Resource st=new Stones(1);
		Resource wo=new Woods(1);
		Resource co=new Coins(1);
		Resource co2=new Coins(2);
		Resource mp=new MilitaryPoints(1);
		Resource vp= new VictoryPoints(1);
		List<Resource> resources=new ArrayList<Resource>();
		List<Resource> resources2=new ArrayList<Resource>();
		resources.add(co);
		resources.add(mp);
		resources2.add(co2);
		resources2.add(vp);
		
		ResourceEffect simple=new SimpleResourceEffect(resources);
		ResourceEffect simple2=new SimpleResourceEffect(resources2);
		
		List<Resource> cost1=new ArrayList<Resource>();
		List<ResourceEffect> eff1=new ArrayList<ResourceEffect>();
		List<ResourceEffect> eff2=new ArrayList<ResourceEffect>();
		cost1.add(st);
		cost1.add(wo);
		eff1.add(cp);
		eff1.add(simple);
		eff2.add(simple2);
		ExchangeResourcesEffect ere1=new ExchangeResourcesEffect(eff1,cost1,null,null);
		ExchangeResourcesEffect ere2=new ExchangeResourcesEffect(eff2,cost1,null,null);
		
		List<Effect> ereList=new ArrayList<Effect>();
		List<Effect> ereList2=new ArrayList<Effect>();
		ereList.add(ere1);
		ereList.add(ere2);
		
		ExchangeResourcesEffect ere3=new ExchangeResourcesEffect(eff1,cost1,eff2,cost1);
		ereList.add(ere3);
		DevelopmentCard card=new BuildingCard(2,"miriamTheCraziest",null,cost1,null,ereList,null);
		
		
		Dice dice=new Dice(5);
		Effect take= new TakeACardEffect(null,dice , null);
		Effect take2= new TakeACardEffect(card,dice , cost1);
		
		ereList.add(take);
		ereList2.add(take);
		ereList.add(take2);
		ereList.add(take2);
		ereList.add(take2);
		
		ViewCLI viewCLI=new ViewCLI();
		Model model=new Model();
		Controller controller =new Controller(model);
		controller.organizeRequestedAuthorizationEffects(ereList);
		int[] rrrr = viewCLI.setRequestedAuthorizationEffects(ereList);
		for (int i = 0; i < rrrr.length; i++) {
			System.out.println(rrrr[i]);
		}
//		viewCLI.setRequestedAuthorizationEffects(ereList);
		
		assertTrue(true);
		
	}

	*/
}
